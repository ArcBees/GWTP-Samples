package com.gwtplatform.dispatch.rest.client;

import com.gwtplatform.dispatch.rest.client.MetadataType;

public class ActionMetadataProviderImpl extends AbstractActionMetadataProvider {
    public ActionMetadataProviderImpl() {
        register(com.gwtplatform.carstore.shared.api.SessionResourceImpl_1_logout.class,
                 MetadataType.RESPONSE_TYPE,
                 "java.lang.Void");
        register(com.gwtplatform.carstore.shared.api.SessionResourceImpl_0_getCurrentUser.class,
                 MetadataType.RESPONSE_TYPE,
                 "com.gwtplatform.carstore.shared.dto.CurrentUserDto");
        register(com.gwtplatform.carstore.shared.api.StatisticsResourceImpl_0_extractYearFromDate.class,
                 MetadataType.RESPONSE_TYPE,
                 "java.lang.Integer");
    }
}
