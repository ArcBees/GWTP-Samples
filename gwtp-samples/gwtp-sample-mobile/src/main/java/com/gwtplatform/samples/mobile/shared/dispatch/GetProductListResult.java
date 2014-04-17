package com.gwtplatform.samples.mobile.shared.dispatch;

import java.util.ArrayList;

import com.gwtplatform.dispatch.rpc.shared.Result;

public class GetProductListResult implements Result {
    private ArrayList<Product> products;

    public GetProductListResult(ArrayList<Product> products) {
        this.products = products;
    }

    protected GetProductListResult() {
        // Possibly for serialization.
    }

    public java.util.ArrayList<Product> getProducts() {
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
        return "GetProductListResult[" + products + "]";
    }
}
