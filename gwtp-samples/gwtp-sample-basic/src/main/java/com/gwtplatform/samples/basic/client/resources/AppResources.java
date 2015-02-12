package com.gwtplatform.samples.basic.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface AppResources extends ClientBundle {
    interface Normalize extends CssResource {
    }

    interface Style extends CssResource {
        String label_error();

        String container();

        String box();
    }

    @Source("css/normalize.gss")
    Normalize normalize();
    
    @Source("css/style.gss")
    public Style style();
}
