package com.gwtplatform.samples.tab.client.security;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class CurrentUserChangedEvent extends GwtEvent<CurrentUserChangedHandler> {
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

    private static final Type<CurrentUserChangedHandler> TYPE = new Type<>();

    public static Type<CurrentUserChangedHandler> getType() {
        return TYPE;
    }

    @Override
    public Type<CurrentUserChangedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CurrentUserChangedHandler handler) {
        handler.onCurrentUserChanged(this);
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
}
