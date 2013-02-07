package com.gwtplatform.samples.hplace.shared.dispatch;



import com.gwtplatform.dispatch.shared.Result;

public class GetProductListResult implements Result { 

  java.util.ArrayList<com.gwtplatform.samples.hplace.shared.dispatch.Product> products;

  protected GetProductListResult() {
    // Possibly for serialization.
  }

  public GetProductListResult(java.util.ArrayList<com.gwtplatform.samples.hplace.shared.dispatch.Product> products) {
    this.products = products;
  }

  public java.util.ArrayList<com.gwtplatform.samples.hplace.shared.dispatch.Product> getProducts(){
    return products;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    GetProductListResult other = (GetProductListResult) obj;
    if (products == null) {
      if (other.products != null)
        return false;
    } else if (!products.equals(other.products))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 23;
    hashCode = (hashCode * 37) + (products == null ? 1 : products.hashCode());
    return hashCode;
  }

  @Override
  public String toString() {
    return "GetProductListResult["
                 + products
    + "]";
  }
}
