/**
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

package com.gwtplatform.samples.unittesting.client.application;

import javax.inject.Inject;

import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gwtplatform.mvp.client.AutobindDisable;
import com.gwtplatform.samples.unittesting.client.application.header.HeaderPresenter;

import static org.mockito.Mockito.verify;

@RunWith(JukitoRunner.class)
public class ApplicationPresenterTest {
    public static class MyModule extends JukitoModule {
        @Override
        protected void configureTest() {
            bind(AutobindDisable.class).toInstance(new AutobindDisable(true));
        }
    }

    @Inject
    ApplicationPresenter presenter; // an actual ApplicationPresenter instance (not a mock!)

    @Test
    public void onReveal_anytime_setsTitleIntoView(ApplicationPresenter.MyView myView) { // A mock. The same instance
    // is shared by applicationPresenter
        // Given
        String title = "GWTP Samples - Unit Testing";

        // When
        presenter.onReveal();

        // Then
        verify(myView).setTitle(title);
    }

    @Test
    public void onBind_anytime_setsHeaderPresenterInSlot(
            HeaderPresenter headerPresenter, ApplicationPresenter.MyView myView) {
        // When
        presenter.onBind();

        // Then
        verify(myView).setInSlot(ApplicationPresenter.HEADER_SLOT, headerPresenter);
    }
}
