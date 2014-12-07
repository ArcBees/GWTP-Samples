package com.gwtplatform.carstore.shared.api;

import javax.inject.Inject;

import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.dispatch.rest.delegates.client.AbstractResourceDelegate;
import com.gwtplatform.carstore.shared.api.SessionResource;
import com.gwtplatform.carstore.shared.api.SessionResourceImpl;
import com.gwtplatform.carstore.shared.api.SessionResourceImpl_0_getCurrentUser;
import com.gwtplatform.carstore.shared.api.SessionResourceImpl_1_logout;
import com.gwtplatform.dispatch.rest.shared.RestAction;

public class SessionResourceDelegate extends AbstractResourceDelegate<SessionResource> implements SessionResource {
    private final SessionResource resource;

    @Inject
    public SessionResourceDelegate(
            RestDispatch dispatcher,
            SessionResource resource) {
        super(dispatcher);

        this.resource = resource;
    }

    @Override
    public com.gwtplatform.carstore.shared.dto.CurrentUserDto getCurrentUser() {
        RestAction<com.gwtplatform.carstore.shared.dto.CurrentUserDto> action = ((SessionResourceImpl) resource).getCurrentUser$action();
        execute(action);

        return null;
    }

    @Override
    public void logout() {
        RestAction<java.lang.Void> action = ((SessionResourceImpl) resource).logout$action();
        execute(action);
    }

    @Override
    protected SessionResource asResource() {
        return this;
    }

    @Override
    protected SessionResourceDelegate newInstance() {
        return new SessionResourceDelegate(dispatcher, resource);
    }
}
