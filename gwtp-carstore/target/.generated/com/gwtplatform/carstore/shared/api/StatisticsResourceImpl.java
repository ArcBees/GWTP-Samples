package com.gwtplatform.carstore.shared.api;

import javax.inject.Inject;

import com.gwtplatform.dispatch.rest.client.DefaultDateFormat;
import com.gwtplatform.carstore.shared.api.StatisticsResource;
import com.gwtplatform.carstore.shared.api.StatisticsResourceImpl_0_extractYearFromDate;
import com.gwtplatform.dispatch.rest.shared.RestAction;

public class StatisticsResourceImpl implements StatisticsResource {
    private final String defaultDateFormat;

    @Inject
    StatisticsResourceImpl(
            @DefaultDateFormat String defaultDateFormat) {
        this.defaultDateFormat = defaultDateFormat;
    }

    @Override
    public RestAction<java.lang.Integer> extractYearFromDate(
            java.util.Date date) {
        return new StatisticsResourceImpl_0_extractYearFromDate(defaultDateFormat,
                date);
    }

}
