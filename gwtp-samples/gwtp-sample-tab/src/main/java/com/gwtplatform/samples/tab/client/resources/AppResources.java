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

package com.gwtplatform.samples.tab.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * {@link ResourceLoader} injects the css on boostrapping from the {@Link ClientModule} and the resources exist in
 * src/main/resources/com.gwtplatform.samples.tab.client.resources .
 */
public interface AppResources extends ClientBundle {
    interface Normalize extends CssResource {
    }

    interface Style extends CssResource {
        String divBorder();

        String logo();

        @ClassName("label_error")
        String labelError();

        String container();

        String box();

        String links();

        String panel();

        String anchor();

        String confirmationLink();

        String popup();

        String topMessage();

        String isOn();
    }

    @Source("css/normalize.gss")
    Normalize normalize();

    @Source({"css/variables.gss", "css/style.gss"})
    Style style();

    @Source("images/logo.png")
    ImageResource logo();
}
