package com.gwtplatform.mvp.client;

import com.google.gwt.inject.client.GinModules;

@GinModules(value={com.gwtplatform.carstore.client.gin.MobileModule.class}, properties={"gin.ginjector.modules"})
public interface MobileGinjector extends ClientGinjector {
}
