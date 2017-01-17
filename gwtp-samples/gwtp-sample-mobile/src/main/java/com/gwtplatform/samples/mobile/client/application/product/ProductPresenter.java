/*
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

package com.gwtplatform.samples.mobile.client.application.product;

import javax.inject.Inject;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.samples.mobile.client.application.breadcrumbs.BreadcrumbsPresenter;
import com.gwtplatform.samples.mobile.client.place.NameTokens;
import com.gwtplatform.samples.mobile.client.place.ParameterTokens;
import com.gwtplatform.samples.mobile.shared.dispatch.GetProductAction;
import com.gwtplatform.samples.mobile.shared.dispatch.GetProductResult;
import com.gwtplatform.samples.mobile.shared.dispatch.Product;

public class ProductPresenter extends Presenter<ProductPresenter.MyView, ProductPresenter.MyProxy> {
    /**
     * {@link ProductPresenter}'s proxy.
     */
    @ProxyCodeSplit
    @NameToken(NameTokens.product)
    public interface MyProxy extends ProxyPlace<ProductPresenter> {
    }

    /**
     * {@link ProductPresenter}'s view.
     */
    public interface MyView extends View {
        void setBackLinkHistoryToken(String historyToken);

        void setMessage(String string);

        void setProductDetails(Product product);
    }

    private final DispatchAsync dispatcher;
    private final PlaceManager placeManager;

    private int id;

    @Inject
    ProductPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager,
            DispatchAsync dispatcher) {
        super(eventBus, view, proxy, BreadcrumbsPresenter.SLOT_MAIN_CONTENT);

        this.placeManager = placeManager;
        this.dispatcher = dispatcher;
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);

        String idString = request.getParameter(ParameterTokens.TOKEN_ID, null);
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            id = 0;
        }
    }

    @Override
    protected void onReset() {
        super.onReset();

        getView().setMessage("Loading...");
        getView().setBackLinkHistoryToken(placeManager.buildRelativeHistoryToken(-1));
        dispatcher.execute(new GetProductAction(id), new AsyncCallback<GetProductResult>() {
            @Override
            public void onFailure(Throwable caught) {
                getView().setMessage("Unknown product");
            }

            @Override
            public void onSuccess(GetProductResult result) {
                getView().setProductDetails(result.getProduct());
            }
        });
    }
}
