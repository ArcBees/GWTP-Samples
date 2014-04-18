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

package com.gwtplatform.samples.tab.client.application.globaldialog;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

/**
 * The view implementation for
 * {@link com.gwtplatform.samples.tab.client.application.localdialog.LocalDialogSubTabPresenter}.
 */
public class GlobalDialogSubTabView extends ViewWithUiHandlers<GlobalDialogSubTabUiHandlers> implements
        GlobalDialogSubTabPresenter.MyView {
    interface Binder extends UiBinder<Widget, GlobalDialogSubTabView> {
    }

    @UiField
    Button globalDialog;
    @UiField
    Anchor popupLink;

    @Inject
    GlobalDialogSubTabView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("globalDialog")
    void onGlobalClicked(ClickEvent event) {
        getUiHandlers().showGlobalDialog();
    }

    @UiHandler("popupLink")
    void onPopupLinkClicked(MouseDownEvent event) {
        getUiHandlers().showInfoPopup(event.getClientX(), event.getClientY());
    }
}
