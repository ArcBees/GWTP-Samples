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

package com.gwtplatform.samples.tab.client.application.homenews;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.samples.tab.client.resources.AppConstants;
import com.gwtplatform.samples.tab.client.resources.AppMessages;
import com.gwtplatform.samples.tab.client.resources.AppResources;

/**
 * The view implementation for {@link com.gwtplatform.samples.tab.client.application.homenews.HomeNewsPresenter} .
 */
public class HomeNewsView extends ViewWithUiHandlers<HomeNewsUiHandler> implements HomeNewsPresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeNewsView> {
    }

    @UiField(provided = true)
    AppResources resources;
    @UiField
    Anchor confirmationLink;
    @UiField
    HTML orderText;
    @UiField
    HTML gwtpTitle;

    private final AppConstants appConstants;
    private final AppMessages appMessages;

    @Inject
    HomeNewsView(Binder uiBinder,
                 AppResources resources,
                 AppConstants appConstants,
                 AppMessages appMessages) {
        this.resources = resources;
        this.appConstants = appConstants;
        this.appMessages = appMessages;

        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setConfirmationText(String text) {
        confirmationLink.setText(text);
    }

    @UiHandler("confirmationLink")
    public void onClick(ClickEvent clickEvent) {
        getUiHandlers().toggleConfirmation();
    }

    @Override
    public void display() {
        String orderNumberOf = appMessages.iWillOrderNumberOf(5);
        orderText.setText(orderNumberOf);

        String gwtpTitle = appConstants.gwtpPlatformTitle();
        this.gwtpTitle.setText(gwtpTitle);
    }
}
