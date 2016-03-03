/*
 * Copyright 2016 ArcBees Inc.
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

package com.gwtplatform.samples.multimodule.module1.client.application.response;

import javax.inject.Inject;
import javax.inject.Provider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.common.client.IndirectProvider;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.CustomProvider;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.samples.multimodule.module1.client.place.NameTokens;
import com.gwtplatform.samples.multimodule.module1.client.place.TokenParameters;
import com.gwtplatform.samples.multimodule.module1.shared.SendTextEndPoint;
import com.gwtplatform.samples.multimodule.module1.shared.TextResponse;

public class ResponsePresenter
        extends Presenter<ResponsePresenter.MyView, ResponsePresenter.MyProxy>
        implements ResponseUiHandlers {
    public static class MyCustomProvider implements IndirectProvider<ResponsePresenter> {
        private final Provider<ResponsePresenter> provider;

        @SuppressWarnings("unchecked")
        public MyCustomProvider(Provider<?> provider) {
            this.provider = (Provider<ResponsePresenter>) provider;
        }

        @Override
        public void get(AsyncCallback<ResponsePresenter> callback) {
            GWT.log("PATATES");
            callback.onSuccess(provider.get());
        }
    }

    @ProxyStandard
    @NameToken(NameTokens.RESPONSE)
    @CustomProvider(MyCustomProvider.class)
    interface MyProxy extends ProxyPlace<ResponsePresenter> {
    }

    interface MyView extends View, HasUiHandlers<ResponseUiHandlers> {
        void setServerResponse(String serverResponse);

        void setTextToServer(String textToServer);
    }

    private final PlaceManager placeManager;
    private final ResourceDelegate<SendTextEndPoint> sendTextService;

    private String textToServer;

    @Inject
    ResponsePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager,
            ResourceDelegate<SendTextEndPoint> sendTextService) {
        super(eventBus, view, proxy, RevealType.Root);

        this.placeManager = placeManager;
        this.sendTextService = sendTextService;

        getView().setUiHandlers(this);
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);

        textToServer = request.getParameter(TokenParameters.TEXT_TO_SERVER, null);
    }

    @Override
    public void onClose() {
        PlaceRequest homePlaceRequest = new PlaceRequest.Builder().nameToken(NameTokens.HOME).build();
        placeManager.revealPlace(homePlaceRequest);
    }

    @Override
    protected void onReset() {
        super.onReset();

        getView().setTextToServer(textToServer);
        getView().setServerResponse("Waiting for response...");

        sendTextService
                .withCallback(new AsyncCallback<TextResponse>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        getView().setServerResponse("An error occured: " + caught.getMessage());
                    }

                    @Override
                    public void onSuccess(TextResponse response) {
                        getView().setServerResponse(response.getResponse());
                    }
                })
                .send(textToServer);
    }

    @ProxyEvent
    void gaga(ValueChangeEvent<TextResponse> event) {
    }

    @ProxyEvent
    void blob(ClickEvent event) {
    }
}
