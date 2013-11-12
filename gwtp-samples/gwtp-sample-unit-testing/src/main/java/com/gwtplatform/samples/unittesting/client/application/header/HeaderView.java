package com.gwtplatform.samples.unittesting.client.application.header;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class HeaderView extends ViewImpl implements HeaderPresenter.MyView {
    interface Binder extends UiBinder<Widget, HeaderView> {
    }

    @Inject
    HeaderView(Binder binder) {
        initWidget(binder.createAndBindUi(this));
    }
}
