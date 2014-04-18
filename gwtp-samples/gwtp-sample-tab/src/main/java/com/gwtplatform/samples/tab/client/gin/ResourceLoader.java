package com.gwtplatform.samples.tab.client.gin;

import javax.inject.Inject;

import com.gwtplatform.samples.tab.client.resources.AppResources;

public class ResourceLoader {
    @Inject
    ResourceLoader(AppResources resources) {
        resources.styles().ensureInjected();
        resources.sprites().ensureInjected();

        //... Inject more css into the document here on boot
    }
}
