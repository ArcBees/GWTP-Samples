package com.gwtplatform.samples.unittesting.client.application;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.samples.unittesting.client.application.header.HeaderPresenter;
import com.gwtplatform.samples.unittesting.client.place.NameTokens;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {
    interface MyView extends View {
        void setTitle(String title);
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
    interface MyProxy extends ProxyPlace<ApplicationPresenter> {
    }

    static final Object HEADER_SLOT = new Object();

    private final HeaderPresenter headerPresenter;

    @Inject
    ApplicationPresenter(EventBus eventBus,
                         MyView view,
                         MyProxy proxy,
                         HeaderPresenter headerPresenter) {
        super(eventBus, view, proxy, RevealType.Root);

        this.headerPresenter = headerPresenter;
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        getView().setTitle("GWTP Samples - Unit Testing");
    }

    @Override
    protected void onBind() {
        super.onBind();

        setInSlot(HEADER_SLOT, headerPresenter);
    }
}
