package com.gwtplatform.dispatch.rest.client.serialization;

import javax.inject.Inject;
import javax.inject.Provider;

import com.google.inject.TypeLiteral;
import com.gwtplatform.dispatch.rest.client.serialization.mappers.*;

public class JacksonMapperProviderImpl extends AbstractJacksonMapperProvider {
    @Inject
    JacksonMapperProviderImpl(Provider<com_gwtplatform_carstore_shared_dto_CurrentUserDtoMapper> com_gwtplatform_carstore_shared_dto_CurrentUserDtoMapperProvider, 
Provider<java_lang_IntegerMapper> java_lang_IntegerMapperProvider
) {
        addProvider("com.gwtplatform.carstore.shared.dto.CurrentUserDto", com_gwtplatform_carstore_shared_dto_CurrentUserDtoMapperProvider);
        addProvider("java.lang.Integer", java_lang_IntegerMapperProvider);
    }
}
