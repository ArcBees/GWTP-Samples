package com.gwtplatform.mvp.client;

import com.google.gwt.inject.client.GinModules;

@GinModules(value={com.gwtplatform.carstore.client.gin.TabletModule.class}, properties={"gin.ginjector.modules"})
public interface TabletGinjector extends ClientGinjector {
}
