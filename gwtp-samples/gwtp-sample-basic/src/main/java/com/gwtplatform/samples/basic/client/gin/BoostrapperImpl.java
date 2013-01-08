package com.gwtplatform.samples.basic.client.gin;

import javax.inject.Inject;

import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.annotations.IsTheBootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

@IsTheBootstrapper
public class BoostrapperImpl implements Bootstrapper {
    private final PlaceManager placeManager;

    @Inject
    public BoostrapperImpl(PlaceManager placeManager) {
        this.placeManager = placeManager;
    }

    public void init() {
        placeManager.revealCurrentPlace();
    }
}
