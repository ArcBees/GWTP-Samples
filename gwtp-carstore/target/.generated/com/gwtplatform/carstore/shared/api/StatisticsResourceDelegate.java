package com.gwtplatform.carstore.shared.api;

import javax.inject.Inject;

import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.dispatch.rest.delegates.client.AbstractResourceDelegate;
import com.gwtplatform.carstore.shared.api.StatisticsResource;
import com.gwtplatform.carstore.shared.api.StatisticsResourceImpl;
import com.gwtplatform.carstore.shared.api.StatisticsResourceImpl_0_extractYearFromDate;
import com.gwtplatform.dispatch.rest.shared.RestAction;

public class StatisticsResourceDelegate extends AbstractResourceDelegate<StatisticsResource> implements StatisticsResource {
    private final StatisticsResource resource;

    @Inject
    public StatisticsResourceDelegate(
            RestDispatch dispatcher,
            StatisticsResource resource) {
        super(dispatcher);

        this.resource = resource;
    }

    @Override
    public RestAction<java.lang.Integer> extractYearFromDate(
            java.util.Date date) {
        RestAction<java.lang.Integer> action = resource.extractYearFromDate(
                date);
        execute(action);

        return action;
    }

    @Override
    protected StatisticsResource asResource() {
        return this;
    }

    @Override
    protected StatisticsResourceDelegate newInstance() {
        return new StatisticsResourceDelegate(dispatcher, resource);
    }
}
