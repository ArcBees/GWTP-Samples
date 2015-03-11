package com.gwtplatform.samples.tab.client.gin;

import javax.inject.Inject;

import com.gwtplatform.samples.tab.client.resources.AppResources;
import com.gwtplatform.samples.tab.client.resources.DialogResources;
import com.gwtplatform.samples.tab.client.resources.TabsResources;

public class ResourceLoader {
    @Inject
    ResourceLoader(
            AppResources resources,
            TabsResources tabsResources,
            DialogResources dialogResources) {
        resources.normalize().ensureInjected();
        resources.style().ensureInjected();
        tabsResources.style().ensureInjected();
        dialogResources.style().ensureInjected();

        //... Inject more css into the document here on boot
    }
}
