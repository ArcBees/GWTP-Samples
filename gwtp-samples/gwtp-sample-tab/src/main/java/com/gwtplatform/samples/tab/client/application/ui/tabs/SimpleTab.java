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

package com.gwtplatform.samples.tab.client.application.ui.tabs;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.assistedinject.Assisted;
import com.gwtplatform.mvp.client.TabData;

/**
 * A {@link BaseTab} styled as a square and meant to be contained in a {@link SimpleTabPanel}.
 */
public class SimpleTab extends BaseTab {
    interface Binder extends UiBinder<Widget, SimpleTab> {
    }

    @Inject
    SimpleTab(Binder uiBinder,
              @Assisted TabData tabData) {
        super(tabData);

        initWidget(uiBinder.createAndBindUi(this));

        setText(tabData.getLabel());
    }
}
