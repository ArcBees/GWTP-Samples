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

import com.google.common.base.Strings;
import com.google.inject.assistedinject.Assisted;
import com.jukito.bindmany.model.Messages;
import com.jukito.bindmany.model.Mode;
import com.jukito.bindmany.model.Person;
import com.jukito.bindmany.model.Title;

public class PersonRenderer {
    private final Mode mode;
    private final Messages messages;

    @Inject
    PersonRenderer(
            Messages messages,
            @Assisted Mode mode) {
        this.mode = mode;
        this.messages = messages;
    }

    public String render(Person person) {
        String result = "";

        if (person != null) {
            String firstName = person.getFirstName();
            String middleName = person.getMiddleName();
            String lastName = person.getLastName();
            String title = renderTitle(person);

            if (mode.isDisplayTitle() && !Strings.isNullOrEmpty(title)) {
                result += title + " ";
            }
            if (mode.isDisplayFirstName() && !Strings.isNullOrEmpty(firstName)) {
                result += firstName + " ";
            }
            if (mode.isDisplayMiddleName() && !Strings.isNullOrEmpty(middleName)) {
                result += middleName + " ";
            }
            if (mode.isDisplayLastName() && !Strings.isNullOrEmpty(lastName)) {
                result += lastName;
            }
        }

        if (result.isEmpty()) {
            result = messages.unknown();
        }

        return result;
    }

    protected String renderTitle(Person person) {
        Title title = person.getTitle();
        return title == null ? "" : messages.title(title);
    }
}
