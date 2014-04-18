package com.gwtplatform.samples.mobile.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Action;

public class GetProductListAction implements Action<GetProductListResult> {
    private int flags;

    public GetProductListAction(int flags) {
        this.flags = flags;
    }

    protected GetProductListAction() {
        // Possibly for serialization.
    }

    @Override
    public String getServiceName() {
        return Action.DEFAULT_SERVICE_NAME + "GetProductList";
    }

    @Override
    public boolean isSecured() {
        return false;
    }

    public int getFlags() {
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

        return flags == other.flags;
    }

    @Override
    public int hashCode() {
        int hashCode = 23;
        hashCode = (hashCode * 37) + new Integer(flags).hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "GetProductListAction[" + flags + "]";
    }
}
