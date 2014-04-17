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

package com.gwtplatform.samples.tab.client.application.localdialog;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewImpl;

/**
 * The view implementation for
 * {@link com.gwtplatform.samples.tab.client.application.localdialog.LocalDialogPresenterWidget}.
 */
public class LocalDialogView extends PopupViewImpl implements LocalDialogPresenterWidget.MyView {
    interface Binder extends UiBinder<PopupPanel, LocalDialogView> {
    }

    @UiField
    Button okButton;

    @Inject
    LocalDialogView(Binder uiBinder,
                    EventBus eventBus) {
        super(eventBus);

        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("okButton")
    void okButtonClicked(ClickEvent event) {
        hide();
    }
}
