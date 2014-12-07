package com.gwtplatform.carstore.shared.api;

import javax.ws.rs.core.HttpHeaders;

import com.gwtplatform.dispatch.rest.client.AbstractRestAction;
import com.gwtplatform.dispatch.rest.shared.HttpMethod;

public class SessionResourceImpl_0_getCurrentUser extends AbstractRestAction<com.gwtplatform.carstore.shared.dto.CurrentUserDto> {
    public SessionResourceImpl_0_getCurrentUser(
            String defaultDateFormat) {
        super(HttpMethod.GET, "/session", defaultDateFormat);

    }

    @Override
    public boolean isSecured() {
        return true;
    }
}
