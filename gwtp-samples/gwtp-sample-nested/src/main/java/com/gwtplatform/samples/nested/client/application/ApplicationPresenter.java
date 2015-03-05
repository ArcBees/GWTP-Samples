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

package com.gwtplatform.samples.nested.client.application;

import javax.inject.Inject;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.LockInteractionEvent;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

/**
 * This is the top-level presenter of the hierarchy. Other presenters reveal themselves within this presenter.
 * <p/>
 * The goal of this sample is to show how to use nested presenters. These can be useful to decouple multiple presenters
 * that need to be displayed on the screen simultaneously.
 */
public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {
    /**
     * {@link ApplicationPresenter}'s proxy.
     */
    @ProxyStandard
    public interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    /**
     * {@link ApplicationPresenter}'s view.
     */
    public interface MyView extends View {
        void showLoading(boolean visibile);
    }

    /**
     * Use this in leaf presenters, inside their {@link #revealInParent} method.
     */
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_SetMainContent = new Type<>();

    @Inject
    ApplicationPresenter(EventBus eventBus,
                         MyView view,
                         MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
    }

    /**
     * We display a short lock message whenever navigation is in progress.
     *
     * @param event The {@link LockInteractionEvent}.
     */
    @ProxyEvent
    public void onLockInteraction(LockInteractionEvent event) {
        getView().showLoading(event.shouldLock());
    }
}
