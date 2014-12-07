package com.gwtplatform.carstore.shared.api;

import javax.ws.rs.core.HttpHeaders;

import com.gwtplatform.dispatch.rest.client.AbstractRestAction;
import com.gwtplatform.dispatch.rest.shared.HttpMethod;

public class SessionResourceImpl_1_logout extends AbstractRestAction<java.lang.Void> {
    public SessionResourceImpl_1_logout(
            String defaultDateFormat) {
        super(HttpMethod.DELETE, "/session", defaultDateFormat);

    }

    @Override
    public boolean isSecured() {
        return true;
    }
}
