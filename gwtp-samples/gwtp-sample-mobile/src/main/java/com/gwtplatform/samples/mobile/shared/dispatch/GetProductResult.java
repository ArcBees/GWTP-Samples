package com.gwtplatform.samples.mobile.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Result;

public class GetProductResult implements Result {
    private Product product;

    public GetProductResult(Product product) {
        this.product = product;
    }

    protected GetProductResult() {
        // Possibly for serialization.
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GetProductResult other = (GetProductResult) obj;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 23;
        hashCode = (hashCode * 37) + (product == null ? 1 : product.hashCode());
        return hashCode;
    }

    @Override
    public String toString() {
        return "GetProductResult[" + product + "]";
    }
}
