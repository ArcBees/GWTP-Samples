package com.gwtplatform.samples.hplace.shared.dispatch;

import com.gwtplatform.dispatch.shared.Action;

public class GetProductAction implements Action<GetProductResult> { 

  int id;

  protected GetProductAction() {
    // Possibly for serialization.
  }

  public GetProductAction(int id) {
    this.id = id;
  }

  @Override
  public String getServiceName() {
    return Action.DEFAULT_SERVICE_NAME + "GetProduct";
  }

  @Override
  public boolean isSecured() {
    return false;
  }

  public int getId(){
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    GetProductAction other = (GetProductAction) obj;
    if (id != other.id)
        return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + new Integer(id).hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return "GetProductAction["
                 + id
    + "]";
  }
}
