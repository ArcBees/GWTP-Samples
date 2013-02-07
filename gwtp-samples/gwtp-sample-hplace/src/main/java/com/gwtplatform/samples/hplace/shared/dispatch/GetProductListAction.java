package com.gwtplatform.samples.hplace.shared.dispatch;

import com.gwtplatform.dispatch.shared.Action;

public class GetProductListAction implements Action<GetProductListResult> { 

  int flags;

  protected GetProductListAction() {
    // Possibly for serialization.
  }

  public GetProductListAction(int flags) {
    this.flags = flags;
  }

  @Override
  public String getServiceName() {
    return Action.DEFAULT_SERVICE_NAME + "GetProductList";
  }

  @Override
  public boolean isSecured() {
    return false;
  }

  public int getFlags(){
    return flags;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    GetProductListAction other = (GetProductListAction) obj;
    if (flags != other.flags)
        return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + new Integer(flags).hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return "GetProductListAction["
                 + flags
    + "]";
  }
}
