/*
 * Copyright 2016 ArcBees Inc.
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

package com.gwtplatform.samples.multimodule.module1.client.gin;

import javax.inject.Singleton;

import com.gwtplatform.common.client.annotations.GwtpModule;
import com.gwtplatform.dispatch.rest.client.RestApplicationPath;
import com.gwtplatform.dispatch.rest.client.gin.RestDispatchAsyncModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;
import com.gwtplatform.samples.multimodule.module1.client.application.ApplicationModule;
import com.gwtplatform.samples.multimodule.module1.client.place.MyGatekeeper;
import com.gwtplatform.samples.multimodule.module1.client.place.NameTokens;
import com.gwtplatform.samples.multimodule.module1.client.resources.ResourceLoader;

@GwtpModule
public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule.Builder()
                .tokenFormatter(RouteTokenFormatter.class)
                .defaultPlace(NameTokens.HOME)
                .errorPlace(NameTokens.HOME)
                .unauthorizedPlace(NameTokens.HOME)
                .build());
        install(new RestDispatchAsyncModule());
        install(new ApplicationModule());

        bind(ResourceLoader.class).asEagerSingleton();
        bindConstant().annotatedWith(RestApplicationPath.class).to("/api");

        bind(MyGatekeeper.class).in(Singleton.class);
    }
}
