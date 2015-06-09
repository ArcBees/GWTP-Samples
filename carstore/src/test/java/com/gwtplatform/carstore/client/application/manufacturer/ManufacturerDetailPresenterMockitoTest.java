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

package com.gwtplatform.carstore.client.application.manufacturer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.carstore.client.application.event.ChangeActionBarEvent;
import com.gwtplatform.carstore.client.application.event.ChangeActionBarEvent.ActionType;
import com.gwtplatform.carstore.client.application.manufacturer.ManufacturerDetailPresenter.MyProxy;
import com.gwtplatform.carstore.client.application.manufacturer.ManufacturerDetailPresenter.MyView;
import com.gwtplatform.carstore.client.resources.EditManufacturerMessages;
import com.gwtplatform.carstore.shared.api.ManufacturersResource;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ManufacturerDetailPresenterMockitoTest {
    // SUT
    private ManufacturerDetailPresenter presenter;

    // Mocks (created by Mockito)
    @Mock
    private EventBus eventBus;
    @Mock
    private MyView view;
    @Mock
    private MyProxy proxy;
    @Mock
    private ResourceDelegate<ManufacturersResource> manufacturersDelegate;
    @Mock
    private PlaceManager placeManager;

    @Before
    public void setUp() {
        // Create @Mock and @Captor fields.
        MockitoAnnotations.initMocks(this);

        // Manual way to create a mock
        EditManufacturerMessages messages = mock(EditManufacturerMessages.class);

        // Manual creation of the SUT.
        presenter = new ManufacturerDetailPresenter(eventBus, view, proxy,
                manufacturersDelegate, placeManager, messages);
    }

    /**
     * Sample Mockito.
     */
    @Test
    public void onReveal() {
        // when
        presenter.onReveal();

        // then
        // Manual way to create an argument captor
        ArgumentCaptor<ChangeActionBarEvent> captor
                = ArgumentCaptor.forClass(ChangeActionBarEvent.class);

        verify(eventBus).fireEventFromSource(captor.capture(), same(presenter));

        ChangeActionBarEvent event = captor.getValue();
        assertThat(event).isNotNull();
        assertThat(event.getActions()).containsOnly(ActionType.DONE);
        assertThat(event.getTabsVisible()).isFalse();
    }
}
