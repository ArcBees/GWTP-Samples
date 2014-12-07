package com.gwtplatform.carstore.shared.api;

import javax.ws.rs.core.HttpHeaders;

import com.gwtplatform.dispatch.rest.client.AbstractRestAction;
import com.gwtplatform.dispatch.rest.shared.HttpMethod;

public class StatisticsResourceImpl_0_extractYearFromDate extends AbstractRestAction<java.lang.Integer> {
    public StatisticsResourceImpl_0_extractYearFromDate(
            String defaultDateFormat,
            java.util.Date date) {
        super(HttpMethod.GET, "/stats", defaultDateFormat);

        addQueryParam("date", date, "MM-yyyy-dd");
    }

    @Override
    public boolean isSecured() {
        return true;
    }
}
