package com.gwtplatform.samples.mobile.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Action;

public class GetProductAction implements Action<GetProductResult> {
    private int id;

    public GetProductAction(int id) {
        this.id = id;
    }

    protected GetProductAction() {
        // Possibly for serialization.
    }

    @Override
    public String getServiceName() {
        return Action.DEFAULT_SERVICE_NAME + "GetProduct";
    }

    @Override
    public boolean isSecured() {
        return false;
    }

    public int getId() {
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

        return id == other.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 23;
        hashCode = (hashCode * 37) + new Integer(id).hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "GetProductAction[" + id + "]";
    }
}
