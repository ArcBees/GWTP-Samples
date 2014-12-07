package com.gwtplatform.dispatch.annotation;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

import com.google.gwt.event.shared.HasHandlers;

public class FooChangedEvent extends GwtEvent<FooChangedEvent.FooChangedHandler> { 

  com.gwtplatform.dispatch.annotation.Foo foo;
  boolean originator;
  java.lang.String additionalMessage;
  double priority;

  public static class Builder { 
    // Required parameters
    private final com.gwtplatform.dispatch.annotation.Foo foo;
    private final boolean originator;

    // Optional parameters - initialized to default values
    private java.lang.String additionalMessage;
    private double priority;

    public Builder(com.gwtplatform.dispatch.annotation.Foo foo, boolean originator) {
      this.foo = foo;
      this.originator = originator;
    }

    public Builder additionalMessage(java.lang.String additionalMessage) {
      this.additionalMessage = additionalMessage;
      return this;
    }

    public Builder priority(double priority) {
      this.priority = priority;
      return this;
    }

    public FooChangedEvent build() {
      return new FooChangedEvent(this);
    }
  }

  public FooChangedEvent(com.gwtplatform.dispatch.annotation.Foo foo, boolean originator) {
    this.foo = foo;
    this.originator = originator;
  }

  private FooChangedEvent(Builder builder) {
    this.foo = builder.foo;
    this.originator = builder.originator;
    this.additionalMessage = builder.additionalMessage;
    this.priority = builder.priority;
  }

  public void fire(HasHandlers source) {
    source.fireEvent(this);
  }

  public static void fire(HasHandlers source, FooChangedEvent eventInstance) {
    source.fireEvent(eventInstance);
  }

  public interface HasFooChangedHandlers extends HasHandlers {
    HandlerRegistration addFooChangedHandler(FooChangedHandler handler);
  }

  public interface FooChangedHandler extends EventHandler {
    public void onFooChanged(FooChangedEvent event);
  }

  private static final Type<FooChangedHandler> TYPE = new Type<FooChangedHandler>();

  public static Type<FooChangedHandler> getType() {
    return TYPE;
  }

  @Override
  public Type<FooChangedHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(FooChangedHandler handler) {
    handler.onFooChanged(this);
  }

  public com.gwtplatform.dispatch.annotation.Foo getFoo(){
    return foo;
  }

  public boolean isOriginator(){
    return originator;
  }

  public java.lang.String getAdditionalMessage(){
    return additionalMessage;
  }

  public double getPriority(){
    return priority;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    FooChangedEvent other = (FooChangedEvent) obj;
    if (foo == null) {
      if (other.foo != null)
        return false;
    } else if (!foo.equals(other.foo))
      return false;
    if (originator != other.originator)
        return false;
    if (additionalMessage == null) {
      if (other.additionalMessage != null)
        return false;
    } else if (!additionalMessage.equals(other.additionalMessage))
      return false;
    if (priority != other.priority)
        return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (foo == null ? 1 : foo.hashCode());
    hashCode = (hashCode * 37) + new Boolean(originator).hashCode();
    hashCode = (hashCode * 37) + (additionalMessage == null ? 1 : additionalMessage.hashCode());
    hashCode = (hashCode * 37) + new Double(priority).hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return "FooChangedEvent["
                 + foo
                 + ","
                 + originator
                 + ","
                 + additionalMessage
                 + ","
                 + priority
    + "]";
  }
}
