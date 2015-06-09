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

import javax.inject.Inject;

import org.jukito.JukitoRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.carstore.client.application.event.ChangeActionBarEvent;
import com.gwtplatform.carstore.client.application.event.ChangeActionBarEvent.ActionType;
import com.gwtplatform.carstore.client.application.event.DisplayMessageEvent;
import com.gwtplatform.carstore.client.place.NameTokens;
import com.gwtplatform.carstore.client.resources.EditManufacturerMessages;
import com.gwtplatform.carstore.shared.api.ManufacturersResource;
import com.gwtplatform.carstore.shared.dto.ManufacturerDto;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.isA;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.verify;

import static com.gwtplatform.dispatch.rest.delegates.test.DelegateTestUtils.givenDelegate;

@RunWith(JukitoRunner.class)
public class ManufacturerDetailPresenterTest {
    private static final String A_MESSAGE = "Jukito Rocks";

    // SUT (Injected by Jukito). We don't need to create all dependencies explicitly, Jukito will mock them.
    @Inject
    private ManufacturerDetailPresenter presenter;

    // Mocks (injected by Jukito)
    @Inject
    private ResourceDelegate<ManufacturersResource> manufacturersResource;
    @Inject
    private EventBus eventBus;
    @Inject
    private PlaceManager placeManager;

    // Captors (Create by Mockito)
    @Captor
    private ArgumentCaptor<ChangeActionBarEvent> changeActionBarEventCaptor;
    @Captor
    private ArgumentCaptor<PlaceRequest> placeRequestCaptor;

    @Before
    public void setUp() {
        // Create @Mock and @Captor fields.
        MockitoAnnotations.initMocks(this);

        // Configure delegates with appropriate resources
        givenDelegate(manufacturersResource).useResource(ManufacturersResource.class);
    }

    /**
     * Sample Jukito.
     */
    @Test
    public void onReveal_newManufacturer_preparesActionBar() {
        // when
        presenter.onReveal();

        // then
        verify(eventBus).fireEventFromSource(changeActionBarEventCaptor.capture(), same(presenter));

        ChangeActionBarEvent event = changeActionBarEventCaptor.getValue();
        assertThat(event).isNotNull();
        assertThat(event.getActions()).containsOnly(ActionType.DONE);
        assertThat(event.getTabsVisible()).isFalse();
    }

    /**
     * Sample Rest-Dispatch. Jukito will inject mocks in test method parameters and fields.
     */
    @Test
    public void onSave_showsMessage_revealsManufacturers(EditManufacturerMessages messages) {
        // given
        ManufacturerDto manufacturer = new ManufacturerDto();
        ManufacturerDto resultManufacturer = new ManufacturerDto();

        givenDelegate(manufacturersResource)
                .succeed()
                .withResult(resultManufacturer)
                .when()
                .saveOrCreate(same(manufacturer));

        given(messages.manufacturerSaved()).willReturn(A_MESSAGE);

        // when
        presenter.onSave(manufacturer);

        // then
        // note `isA` is used instead of `any`. This is because the event bus accepts all `GwtEvent` subclasses.
        // `isA` also verifies the type
        verify(eventBus).fireEventFromSource(isA(DisplayMessageEvent.class), same(presenter));
        verify(placeManager).revealPlace(placeRequestCaptor.capture());

        PlaceRequest placeRequest = placeRequestCaptor.getValue();
        assertThat(placeRequest.getNameToken()).isEqualTo(NameTokens.MANUFACTURER);
    }
}
