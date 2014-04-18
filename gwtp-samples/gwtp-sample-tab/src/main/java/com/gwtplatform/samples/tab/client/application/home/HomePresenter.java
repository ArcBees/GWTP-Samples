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

package com.gwtplatform.samples.tab.client.application.home;

import javax.inject.Inject;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.RequestTabsHandler;
import com.gwtplatform.mvp.client.TabView;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.RequestTabs;
import com.gwtplatform.mvp.client.annotations.TabInfo;
import com.gwtplatform.mvp.client.proxy.NonLeafTabContentProxy;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.samples.tab.client.application.ApplicationPresenter;
import com.gwtplatform.samples.tab.client.application.homenews.HomeNewsPresenter;
import com.gwtplatform.samples.tab.client.place.NameTokens;
import com.gwtplatform.samples.tab.client.resources.AppConstants;

/**
 * A sample {@link com.gwtplatform.mvp.client.TabContainerPresenter TabContainerPresenter} appearing as a tab within
 * {@link ApplicationPresenter} and itself containing two tabs. When the tab for {@link HomePresenter} is clicked, them
 * {@link HomeNewsPresenter} is displayed.
 * <p/>
 * It demonstrates the option 2 described in {@link TabInfo}, together with the use of the {@code nameToken} parameter
 * of {@code @TabInfo} to specify which place to show when the tab is clicked.
 */
public class HomePresenter extends HomePresenterBase<HomePresenter.MyView, HomePresenter.MyProxy> {
    /**
     * {@link HomePresenter}'s proxy.
     */
    @ProxyCodeSplit
    public interface MyProxy extends NonLeafTabContentProxy<HomePresenter> {
    }

    @TabInfo(container = ApplicationPresenter.class, priority = 0, // The first tab in the main page
             nameToken = NameTokens.homeNewsPage)
    // Go to HomeNewsPresenter when clicked
    static String getTabLabel(AppConstants constants) {
        return constants.home();
    }

    /**
     * {@link HomePresenter}'s view.
     */
    public interface MyView extends TabView {
    }

    /**
     * This will be the event sent to our "unknown" child presenters, in order for them to register their tabs.
     */
    @RequestTabs
    public static final Type<RequestTabsHandler> SLOT_RequestTabs = new Type<>();

    private final PlaceManager placeManager;

    @Inject
    HomePresenter(EventBus eventBus,
                  MyView view,
                  MyProxy proxy,
                  PlaceManager placeManager) {
        super(eventBus, view, proxy, SLOT_RequestTabs, ApplicationPresenter.SLOT_SetTabContent);

        this.placeManager = placeManager;
    }

    @Override
    public void onReset() {
        super.onReset();
        MyProxy proxy = getProxy();
        proxy.changeTab(proxy.getTabData(), placeManager.getCurrentPlaceRequest().getNameToken());
    }
}
