package com.gwtplatform.carstore.shared.api;

import javax.inject.Inject;

import com.gwtplatform.dispatch.rest.client.DefaultDateFormat;
import com.gwtplatform.carstore.shared.api.SessionResource;
import com.gwtplatform.carstore.shared.api.SessionResourceImpl_0_getCurrentUser;
import com.gwtplatform.carstore.shared.api.SessionResourceImpl_1_logout;
import com.gwtplatform.dispatch.rest.shared.RestAction;

public class SessionResourceImpl implements SessionResource {
    private final String defaultDateFormat;

    @Inject
    SessionResourceImpl(
            @DefaultDateFormat String defaultDateFormat) {
        this.defaultDateFormat = defaultDateFormat;
    }

    @Override
    public com.gwtplatform.carstore.shared.dto.CurrentUserDto getCurrentUser() {
        return null;
    }

    RestAction<com.gwtplatform.carstore.shared.dto.CurrentUserDto> getCurrentUser$action() {
        return new SessionResourceImpl_0_getCurrentUser(defaultDateFormat);
    }

    @Override
    public void logout() {
    }

    RestAction<java.lang.Void> logout$action() {
        return new SessionResourceImpl_1_logout(defaultDateFormat);
    }

}
