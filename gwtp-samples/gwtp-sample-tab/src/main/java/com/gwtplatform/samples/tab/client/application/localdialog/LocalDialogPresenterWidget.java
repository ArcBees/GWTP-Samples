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
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.samples.tab.client.application.globaldialog.GlobalDialogPresenterWidget;

/**
 * The {@link PresenterWidget} of a dialog box that is meant to be displayed only when its parent presenter is visible.
 * Compare to {@link GlobalDialogPresenterWidget}.
 */
public class LocalDialogPresenterWidget extends PresenterWidget<LocalDialogPresenterWidget.MyView> {
    /**
     * {@link LocalDialogPresenterWidget}'s PopupView.
     */
    public interface MyView extends PopupView {
    }

    @Inject
    LocalDialogPresenterWidget(EventBus eventBus,
                               MyView view) {
        super(eventBus, view);
    }
}
