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

package com.gwtplatform.samples.tab.client.security;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class CurrentUserChangedEvent extends GwtEvent<CurrentUserChangedHandler> {
    private static final Type<CurrentUserChangedHandler> TYPE = new Type<>();

    public CurrentUserChangedEvent() {
        // Possibly for serialization.
    }

    public static void fire(HasHandlers source) {
        CurrentUserChangedEvent eventInstance = new CurrentUserChangedEvent();
        source.fireEvent(eventInstance);
    }

    public static void fire(HasHandlers source, CurrentUserChangedEvent eventInstance) {
        source.fireEvent(eventInstance);
    }

    public static Type<CurrentUserChangedHandler> getType() {
        return TYPE;
    }

    @Override
    public Type<CurrentUserChangedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "CurrentUserChangedEvent[" + "]";
    }

    @Override
    protected void dispatch(CurrentUserChangedHandler handler) {
        handler.onCurrentUserChanged(this);
    }
}
