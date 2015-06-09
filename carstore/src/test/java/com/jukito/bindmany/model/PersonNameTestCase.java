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

package com.jukito.bindmany.model;

public class PersonNameTestCase {
    private final Person person;

    private Mode mode;
    private String expected;

    public PersonNameTestCase() {
        person = null;
    }

    public PersonNameTestCase(
            String firstName,
            String lastName) {
        person = new Person(firstName, lastName);
    }

    public PersonNameTestCase title(Title title) {
        person.setTitle(title);
        return this;
    }

    public PersonNameTestCase middleName(String middleName) {
        person.setMiddleName(middleName);
        return this;
    }

    public PersonNameTestCase mode(Mode mode) {
        this.mode = mode;
        return this;
    }

    public PersonNameTestCase expected(String expected) {
        this.expected = expected;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Mode getMode() {
        return mode;
    }

    public String getExpected() {
        return expected;
    }
}
