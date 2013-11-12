package com.gwtplatform.samples.unittesting.client.application.header;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;

public class HeaderPresenter extends PresenterWidget<HeaderPresenter.MyView> {
    interface MyView extends View {
    }

    @Inject
    HeaderPresenter(EventBus eventBus,
                    MyView view) {
        super(eventBus, view);
    }
}
