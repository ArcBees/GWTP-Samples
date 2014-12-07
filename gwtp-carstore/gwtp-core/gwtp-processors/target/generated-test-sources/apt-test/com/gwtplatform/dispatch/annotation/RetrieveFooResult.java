package com.gwtplatform.dispatch.annotation;

import com.google.gwt.user.client.rpc.IsSerializable;

import com.gwtplatform.dispatch.rpc.shared.Result;

public class RetrieveFooResult implements Result { 

  com.gwtplatform.dispatch.annotation.Foo foo;
  int meaningOfLife;
  boolean answer42;

  public static class Builder implements IsSerializable { 
    // Required parameters
    private final com.gwtplatform.dispatch.annotation.Foo foo;
    private final int meaningOfLife;

    // Optional parameters - initialized to default values
    private boolean answer42;

    public Builder(com.gwtplatform.dispatch.annotation.Foo foo, int meaningOfLife) {
      this.foo = foo;
      this.meaningOfLife = meaningOfLife;
    }

    public Builder answer42(boolean answer42) {
      this.answer42 = answer42;
      return this;
    }

    public RetrieveFooResult build() {
      return new RetrieveFooResult(this);
    }
  }

  protected RetrieveFooResult() {
    // Possibly for serialization.
  }

  public RetrieveFooResult(com.gwtplatform.dispatch.annotation.Foo foo, int meaningOfLife) {
    this.foo = foo;
    this.meaningOfLife = meaningOfLife;
  }

  private RetrieveFooResult(Builder builder) {
    this.foo = builder.foo;
    this.meaningOfLife = builder.meaningOfLife;
    this.answer42 = builder.answer42;
  }

  public com.gwtplatform.dispatch.annotation.Foo getFoo(){
    return foo;
  }

  public int getMeaningOfLife(){
    return meaningOfLife;
  }

  public boolean isAnswer42(){
    return answer42;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    RetrieveFooResult other = (RetrieveFooResult) obj;
    if (foo == null) {
      if (other.foo != null)
        return false;
    } else if (!foo.equals(other.foo))
      return false;
    if (meaningOfLife != other.meaningOfLife)
        return false;
    if (answer42 != other.answer42)
        return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (foo == null ? 1 : foo.hashCode());
    hashCode = (hashCode * 37) + new Integer(meaningOfLife).hashCode();
    hashCode = (hashCode * 37) + new Boolean(answer42).hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return "RetrieveFooResult["
                 + foo
                 + ","
                 + meaningOfLife
                 + ","
                 + answer42
    + "]";
  }
}
