package com.gwtplatform.dispatch.annotation;



import com.gwtplatform.dispatch.rpc.shared.Result;

public class RetrieveBarResult implements Result,com.gwtplatform.dispatch.annotation.HasThing<com.gwtplatform.dispatch.annotation.Foo> { 

  com.gwtplatform.dispatch.annotation.Foo thing;
  int meaningOfLife;

  protected RetrieveBarResult() {
    // Possibly for serialization.
  }

  public RetrieveBarResult(com.gwtplatform.dispatch.annotation.Foo thing, int meaningOfLife) {
    this.thing = thing;
    this.meaningOfLife = meaningOfLife;
  }

  public com.gwtplatform.dispatch.annotation.Foo getThing(){
    return thing;
  }

  public int getMeaningOfLife(){
    return meaningOfLife;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    RetrieveBarResult other = (RetrieveBarResult) obj;
    if (thing == null) {
      if (other.thing != null)
        return false;
    } else if (!thing.equals(other.thing))
      return false;
    if (meaningOfLife != other.meaningOfLife)
        return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (thing == null ? 1 : thing.hashCode());
    hashCode = (hashCode * 37) + new Integer(meaningOfLife).hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return "RetrieveBarResult["
                 + thing
                 + ","
                 + meaningOfLife
    + "]";
  }
}
