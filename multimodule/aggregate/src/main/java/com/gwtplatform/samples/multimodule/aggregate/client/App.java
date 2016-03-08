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

package com.gwtplatform.samples.multimodule.aggregate.client;

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.gwtplatform.common.client.annotations.GwtpApp;
import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.PreBootstrapper;
import com.gwtplatform.mvp.client.annotations.UseBootstrapper;
import com.gwtplatform.mvp.client.annotations.UsePreBootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.samples.multimodule.aggregate.client.App.MyBootstrapper;
import com.gwtplatform.samples.multimodule.aggregate.client.App.MyPreBootstrapper;

@GwtpApp
@UseBootstrapper(MyBootstrapper.class)
@UsePreBootstrapper(MyPreBootstrapper.class)
public class App {
    public static class MyBootstrapper implements Bootstrapper {
        private final PlaceManager placeManager;

        @Inject
        MyBootstrapper(PlaceManager placeManager) {
            this.placeManager = placeManager;
        }

        @Override
        public void onBootstrap() {
            placeManager.revealCurrentPlace();
        }
    }

    public static class MyPreBootstrapper implements PreBootstrapper {
        @Override
        public void onPreBootstrap() {
            GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                @Override
                public void onUncaughtException(Throwable e) {
                    GWT.log("POTATOES!!1", e);
                }
            });
        }
    }
}
