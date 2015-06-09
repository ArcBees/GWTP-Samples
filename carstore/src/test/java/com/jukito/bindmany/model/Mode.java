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

public enum Mode {
    SHORT(true, false, true, false),
    FORMAL(true, true, true, true);

    private final boolean displayFirstName;
    private final boolean displayMiddleName;
    private final boolean displayLastName;
    private final boolean displayTitle;

    Mode(
            boolean displayFirstName,
            boolean displayMiddleName,
            boolean displayLastName,
            boolean displayTitle) {
        this.displayFirstName = displayFirstName;
        this.displayMiddleName = displayMiddleName;
        this.displayLastName = displayLastName;
        this.displayTitle = displayTitle;
    }

    public boolean isDisplayFirstName() {
        return displayFirstName;
    }

    public boolean isDisplayMiddleName() {
        return displayMiddleName;
    }

    public boolean isDisplayLastName() {
        return displayLastName;
    }

    public boolean isDisplayTitle() {
        return displayTitle;
    }
}
