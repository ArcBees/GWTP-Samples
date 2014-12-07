package com.gwtplatform.dispatch.annotation;

import com.gwtplatform.dispatch.rpc.shared.Action;

public class RetrieveBarAction implements Action<RetrieveBarResult> { 

  java.lang.String goodName;

  protected RetrieveBarAction() {
    // Possibly for serialization.
  }

  public RetrieveBarAction(java.lang.String goodName) {
    this.goodName = goodName;
  }

  @Override
  public String getServiceName() {
    return "dispatch/Blah";
  }

  @Override
  public boolean isSecured() {
    return false;
  }

  public java.lang.String getGoodName(){
    return goodName;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    RetrieveBarAction other = (RetrieveBarAction) obj;
    if (goodName == null) {
      if (other.goodName != null)
        return false;
    } else if (!goodName.equals(other.goodName))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (goodName == null ? 1 : goodName.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "RetrieveBarAction["
                 + goodName
    + "]";
  }
}
