package com.gwtplatform.samples.tab.client.security;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class CurrentUserChangedEvent extends GwtEvent<CurrentUserChangedEvent.CurrentUserChangedHandler> {
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

    public interface HasCurrentUserChangedHandlers extends HasHandlers {
        HandlerRegistration addCurrentUserChangedHandler(CurrentUserChangedHandler handler);
    }

    public interface CurrentUserChangedHandler extends EventHandler {
        public void onCurrentUserChanged(CurrentUserChangedEvent event);
    }

    private static final Type<CurrentUserChangedHandler> TYPE = new Type<CurrentUserChangedHandler>();

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
