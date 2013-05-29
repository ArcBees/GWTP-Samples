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

package com.gwtplatform.samples.tab.client.gin;

import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.GaAccount;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.client.proxy.DefaultPlaceManager;
import com.gwtplatform.samples.tab.client.application.ApplicationModule;
import com.gwtplatform.samples.tab.client.place.NameTokens;
import com.gwtplatform.samples.tab.client.security.CurrentUser;
import com.gwtplatform.samples.tab.client.security.IsAdminGatekeeper;

public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule(DefaultPlaceManager.class));
        install(new ApplicationModule());

        bind(CurrentUser.class).in(Singleton.class);
        bind(IsAdminGatekeeper.class).in(Singleton.class);

        // DefaultPlaceManager Constants
        bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.homeNewsPage);
        bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.homeNewsPage);
        bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.homeNewsPage);

        // Google Analytics
        bindConstant().annotatedWith(GaAccount.class).to("UA-8319339-6");

        // Load and inject CSS resources
        bind(ResourceLoader.class).asEagerSingleton();
    }
}
