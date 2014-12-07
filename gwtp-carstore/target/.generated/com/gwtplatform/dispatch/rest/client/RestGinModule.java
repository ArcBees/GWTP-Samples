package com.gwtplatform.dispatch.rest.client;

import javax.inject.Singleton;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.TypeLiteral;
import com.gwtplatform.carstore.shared.api.SessionResource;
import com.gwtplatform.carstore.shared.api.SessionResourceImpl;
import com.gwtplatform.carstore.shared.api.StatisticsResource;
import com.gwtplatform.carstore.shared.api.StatisticsResourceImpl;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.carstore.shared.api.SessionResourceDelegate;
import com.gwtplatform.dispatch.rest.delegates.client.ResourceDelegate;
import com.gwtplatform.carstore.shared.api.StatisticsResourceDelegate;
import com.gwtplatform.dispatch.rest.client.ActionMetadataProvider;
import com.gwtplatform.dispatch.rest.client.ActionMetadataProviderImpl;
import com.gwtplatform.dispatch.rest.client.serialization.JacksonMapperProvider;
import com.gwtplatform.dispatch.rest.client.serialization.JacksonMapperProviderImpl;

public class RestGinModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(SessionResource.class)
                .to(SessionResourceImpl.class)
                .in(Singleton.class);
        bind(StatisticsResource.class)
                .to(StatisticsResourceImpl.class)
                .in(Singleton.class);
        bind(new TypeLiteral<ResourceDelegate<com.gwtplatform.carstore.shared.api.SessionResource>>() {})
                .to(SessionResourceDelegate.class)
                .in(Singleton.class);
        bind(new TypeLiteral<ResourceDelegate<com.gwtplatform.carstore.shared.api.StatisticsResource>>() {})
                .to(StatisticsResourceDelegate.class)
                .in(Singleton.class);
        bind(ActionMetadataProvider.class)
                .to(ActionMetadataProviderImpl.class)
                .in(Singleton.class);
        bind(JacksonMapperProvider.class)
                .to(JacksonMapperProviderImpl.class)
                .in(Singleton.class);
    }
}
