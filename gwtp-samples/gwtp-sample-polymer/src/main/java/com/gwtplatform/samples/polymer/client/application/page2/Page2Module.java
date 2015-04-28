/*
 * Copyright 2015 ArcBees Inc.
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

package com.gwtplatform.samples.polymer.client.application.page2;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class Page2Module extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(Page2Presenter.class, Page2Presenter.MyView.class, Page2View.class,
                Page2Presenter.MyProxy.class);
    }
}
