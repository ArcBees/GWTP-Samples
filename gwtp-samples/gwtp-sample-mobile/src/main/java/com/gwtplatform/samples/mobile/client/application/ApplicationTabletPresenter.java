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

package com.gwtplatform.samples.mobile.client.application;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.samples.mobile.client.application.breadcrumbs.BreadcrumbsPresenter;
import com.gwtplatform.samples.mobile.client.place.NameTokens;
import com.gwtplatform.samples.mobile.client.place.ParameterTokens;

public class ApplicationTabletPresenter extends AbstractApplicationPresenter implements ApplicationUiHandlers {
    private PlaceManager placeManager;

    @Inject
    ApplicationTabletPresenter(EventBus eventBus,
                               MyView view,
                               MyProxy proxy,
                               PlaceManager placeManager) {
        super(eventBus, view, proxy, BreadcrumbsPresenter.SLOT_SetMainContent);

        this.placeManager = placeManager;

        view.setUiHandlers(this);
    }

    @Override
    public void revealAllProductsList() {
        PlaceRequest request = new PlaceRequest.Builder()
                .nameToken(NameTokens.productList)
                .with(ParameterTokens.TOKEN_TYPE, ParameterTokens.TYPE_ALL_PRODUCTS)
                .build();
        placeManager.revealRelativePlace(request);
    }

    @Override
    public void revealFavoriteProductsList() {
        PlaceRequest request = new PlaceRequest.Builder()
                .nameToken(NameTokens.productList)
                .with(ParameterTokens.TOKEN_TYPE, ParameterTokens.TYPE_FAVORITE_PRODUCTS)
                .build();
        placeManager.revealRelativePlace(request);
    }

    @Override
    public void revealSpecialsList() {
        PlaceRequest request = new PlaceRequest.Builder()
                .nameToken(NameTokens.productList)
                .with(ParameterTokens.TOKEN_TYPE, ParameterTokens.TYPE_SPECIALS)
                .build();
        placeManager.revealRelativePlace(request);
    }
}
