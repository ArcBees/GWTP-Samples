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

package com.jukito.bindmany;

import javax.inject.Inject;

import org.jukito.All;
import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.jukito.bindmany.model.Messages;
import com.jukito.bindmany.model.Mode;
import com.jukito.bindmany.model.Person;
import com.jukito.bindmany.model.PersonNameTestCase;
import com.jukito.bindmany.model.Title;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(JukitoRunner.class)
public class PersonRendererTest {
    public static class Module extends JukitoModule {
        @Override
        protected void configureTest() {
            bindManyInstances(PersonNameTestCase.class,
                    new PersonNameTestCase("Zom", "Bee")
                            .mode(Mode.SHORT).expected("Zom Bee"),
                    new PersonNameTestCase("Zom", "Bee").title(Title.MR)
                            .mode(Mode.SHORT).expected("Zom Bee"),
                    new PersonNameTestCase("Zom", "Bee").middleName("Buzz")
                            .mode(Mode.SHORT).expected("Zom Bee"),
                    new PersonNameTestCase("Zom", "Bee").title(Title.MR).middleName("Buzz")
                            .mode(Mode.SHORT).expected("Zom Bee"),

                    new PersonNameTestCase("Zom", "Bee")
                            .mode(Mode.FORMAL).expected("Zom Bee"),
                    new PersonNameTestCase("Zom", "Bee").title(Title.MS)
                            .mode(Mode.FORMAL).expected("Ms. Zom Bee"),
                    new PersonNameTestCase("Zom", "Bee").middleName("Buzz")
                            .mode(Mode.FORMAL).expected("Zom Buzz Bee"),
                    new PersonNameTestCase("Zom", "Bee").title(Title.MS).middleName("Buzz")
                            .mode(Mode.FORMAL).expected("Ms. Zom Buzz Bee"),

                    new PersonNameTestCase()
                            .mode(Mode.SHORT).expected(UNKNOWN),
                    new PersonNameTestCase()
                            .mode(Mode.FORMAL).expected(UNKNOWN)
            );
        }
    }

    private static final String UNKNOWN = "unknown";

    @Inject
    private Messages messages;

    @Before
    public void setUp() {
        given(messages.unknown()).willReturn(UNKNOWN);
        given(messages.title(Title.MR)).willReturn("Mr.");
        given(messages.title(Title.MS)).willReturn("Ms.");
    }

    @Test
    public void render(@All PersonNameTestCase testCase) {
        // given
        Person person = testCase.getPerson();
        Mode mode = testCase.getMode();
        PersonRenderer renderer = new PersonRenderer(messages, mode);

        // when
        String result = renderer.render(person);

        // then
        String expected = testCase.getExpected();

        assertThat(result)
                .overridingErrorMessage("Expected %s with mode %s to be '%s'.", person, mode, expected)
                .isEqualTo(expected);
    }
}
