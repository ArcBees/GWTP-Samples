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

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.TabContentProxyPlace;
import com.gwtplatform.samples.tab.client.application.ApplicationPresenter;
import com.gwtplatform.samples.tab.client.application.dialog.DialogSamplePresenter;
import com.gwtplatform.samples.tab.client.place.NameTokens;

/**
 * A sample {@link Presenter} that demonstrates how to trigger a local dialog box. It appears as a tab within
 * {@link DialogSamplePresenter}, which is itself a s tab in {@link ApplicationPresenter}.
 * <p/>
 * It demonstrates the option 1 described in {@link TabInfo}.
 */
public class LocalDialogSubTabPresenter
        extends Presenter<LocalDialogSubTabPresenter.MyView, LocalDialogSubTabPresenter.MyProxy>
        implements LocalDialogSubTabUihandlers {
    /**
     * {@link LocalDialogSubTabPresenter}'s proxy.
     */
    @ProxyCodeSplit
    @NameToken(NameTokens.localDialogSamplePage)
    @TabInfo(container = DialogSamplePresenter.class, label = "Local", priority = 5)
    // The second tab in the dialog tab
    public interface MyProxy extends TabContentProxyPlace<LocalDialogSubTabPresenter> {
    }

    /**
     * {@link LocalDialogSubTabPresenter}'s view.
     */
    public interface MyView extends View, HasUiHandlers<LocalDialogSubTabUihandlers> {
    }

    private final LocalDialogPresenterWidget localDialog;

    @Inject
    LocalDialogSubTabPresenter(EventBus eventBus,
                               MyView view,
                               MyProxy proxy,
                               LocalDialogPresenterWidget localDialog) {
        super(eventBus, view, proxy, DialogSamplePresenter.SLOT_SetTabContent);

        this.localDialog = localDialog;

        view.setUiHandlers(this);
    }

    @Override
    public void showLocalDialog() {
        addToPopupSlot(localDialog);
    }
}
