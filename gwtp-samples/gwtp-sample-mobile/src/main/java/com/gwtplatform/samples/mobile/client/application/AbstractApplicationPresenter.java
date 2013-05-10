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

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.Title;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.samples.mobile.client.place.NameTokens;

public abstract class AbstractApplicationPresenter
        extends Presenter<AbstractApplicationPresenter.MyView, AbstractApplicationPresenter.MyProxy> {
    @ProxyCodeSplit
    @NameToken(NameTokens.homePage)
    @Title("Home")
    public interface MyProxy extends ProxyPlace<AbstractApplicationPresenter> {
    }

    public interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {
    }

    public AbstractApplicationPresenter(EventBus eventBus,
                                        MyView view,
                                        MyProxy proxy,
                                        GwtEvent.Type<RevealContentHandler<?>> slot) {
        super(eventBus, view, proxy, slot);
    }
}
