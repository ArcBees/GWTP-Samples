/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.samples.mobile.client.application.products;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.TitleFunction;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.samples.mobile.client.application.breadcrumbs.BreadcrumbsPresenter;
import com.gwtplatform.samples.mobile.client.place.NameTokens;
import com.gwtplatform.samples.mobile.client.place.ParameterTokens;
import com.gwtplatform.samples.mobile.shared.dispatch.GetProductListAction;
import com.gwtplatform.samples.mobile.shared.dispatch.GetProductListResult;
import com.gwtplatform.samples.mobile.shared.dispatch.Product;

public class ProductsPresenter extends Presenter<ProductsPresenter.MyView, ProductsPresenter.MyProxy> {
    /**
     * {@link ProductsPresenter}'s proxy.
     */
    @ProxyCodeSplit
    @NameToken(NameTokens.productList)
    public interface MyProxy extends ProxyPlace<ProductsPresenter> {
    }

    /**
     * {@link ProductsPresenter}'s view.
     */
    public interface MyView extends View {
        void setBackLinkHistoryToken(String historyToken);

        void setList(List<Product> products);

        void setMessage(String string);

        void setTitle(String title);
    }

    @TitleFunction
    public static String getListTitle(PlaceRequest request) {
        return getTitleFor(request.getParameter(ParameterTokens.TOKEN_TYPE, null));
    }

    private static String getTitleFor(String type) {
        switch (type) {
            case ParameterTokens.TYPE_FAVORITE_PRODUCTS:
                return "Favorite products";
            case ParameterTokens.TYPE_SPECIALS:
                return "Specials";
            default:
                return "All products";
        }
    }

    private final DispatchAsync dispatcher;
    private final PlaceManager placeManager;

    private String currentType = ParameterTokens.TYPE_ALL_PRODUCTS;

    @Inject
    ProductsPresenter(EventBus eventBus,
                      MyView view,
                      MyProxy proxy,
                      PlaceManager placeManager,
                      DispatchAsync dispatcher) {
        super(eventBus, view, proxy, BreadcrumbsPresenter.SLOT_SetMainContent);

        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);

        String type = request.getParameter(ParameterTokens.TOKEN_TYPE, ParameterTokens.TYPE_ALL_PRODUCTS);
        switch (type) {
            case ParameterTokens.TYPE_FAVORITE_PRODUCTS:
                currentType = ParameterTokens.TYPE_FAVORITE_PRODUCTS;
                break;
            case ParameterTokens.TYPE_SPECIALS:
                currentType = ParameterTokens.TYPE_SPECIALS;
                break;
            default:
                currentType = ParameterTokens.TYPE_ALL_PRODUCTS;
                break;
        }

        setViewTitle();
    }

    @Override
    protected void onReset() {
        super.onReset();

        getView().setMessage("Loading list...");
        getView().setBackLinkHistoryToken(placeManager.buildRelativeHistoryToken(-1));
        dispatcher.execute(new GetProductListAction(getFlags()), new AsyncCallback<GetProductListResult>() {
            @Override
            public void onFailure(Throwable caught) {
                getView().setMessage("Loading error!");
            }

            @Override
            public void onSuccess(GetProductListResult result) {
                getView().setList(result.getProducts());
            }
        });
    }

    private int getFlags() {
        if (currentType.equals(ParameterTokens.TYPE_FAVORITE_PRODUCTS)) {
            return Product.FLAG_FAVORITE;
        } else if (currentType.equals(ParameterTokens.TYPE_SPECIALS)) {
            return Product.FLAG_SPECIAL;
        }
        return 0;
    }

    private void setViewTitle() {
        getView().setTitle(getTitleFor(currentType));
    }
}
