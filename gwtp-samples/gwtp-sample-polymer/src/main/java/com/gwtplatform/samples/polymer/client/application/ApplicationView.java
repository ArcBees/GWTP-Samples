/*
 * Copyright 2015 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.samples.polymer.client.application;

import javax.inject.Inject;

import com.arcbees.gwtpolymer.event.AnimatedPagesTransitionEndEvent;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import static com.google.gwt.query.client.GQuery.$;

public class ApplicationView extends ViewWithUiHandlers<ApplicationUiHandlers> implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    Element toolbar;
    @UiField
    Element menu;
    @UiField
    Element drawerPanel;
    @UiField
    Element pageOne;
    @UiField
    Element pageTwo;
    @UiField
    HTMLPanel pages;
    @UiField
    Element more;

    private SimplePanel main;
    private SimplePanel oldMain;

    @Inject
    ApplicationView(
            Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        menu.setAttribute("core-drawer-toggle", "");
        pages.getElement().setAttribute("transitions", "slide-from-right");

        asWidget().addDomHandler(new AnimatedPagesTransitionEndEvent.AnimatedPagesTransitionEndHandler() {
            @Override
            public void onAnimatedPagesTransitionEnd(AnimatedPagesTransitionEndEvent event) {
                oldMain.removeFromParent();
                oldMain = null;
                pages.getElement().setPropertyInt("selected", 0);
            }
        }, AnimatedPagesTransitionEndEvent.getType());
    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == ApplicationPresenter.SLOT_MAIN_CONTENT) {
            if (pages.getWidgetCount() == 0) {
                main = new SimplePanel(content.asWidget());
                pages.add(main);
            } else {
                if (oldMain != null) {
                    oldMain.removeFromParent();
                }
                oldMain = main;
                main = new SimplePanel(content.asWidget());
                main.setWidget(content);
                pages.add(main);
                pages.getElement().setPropertyInt("selected", 1);
            }
        }
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        $(pageOne).click(new Function() {
            @Override
            public void f() {
                onPageOneClicked();
            }
        });
        $(pageTwo).click(new Function() {
            @Override
            public void f() {
                onPageTwoClicked();
            }
        });
    }

    private void onPageOneClicked() {
        getUiHandlers().goToPageOne();
        closeDrawer(drawerPanel);
    }

    private void onPageTwoClicked() {
        getUiHandlers().goToPageTwo();
        closeDrawer(drawerPanel);
    }

    private native void closeDrawer(Element drawerPanel) /*-{
        drawerPanel.closeDrawer();
    }-*/;
}
