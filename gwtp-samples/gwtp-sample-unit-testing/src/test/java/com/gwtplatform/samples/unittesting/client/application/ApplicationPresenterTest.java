package com.gwtplatform.samples.unittesting.client.application;

import javax.inject.Inject;
import javax.inject.Provider;

import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gwtplatform.samples.unittesting.client.application.header.HeaderPresenter;

import static org.mockito.Mockito.verify;

@RunWith(JukitoRunner.class)
public class ApplicationPresenterTest {
    @Inject
    Provider<ApplicationPresenter> provider;

    @Test
    public void onReveal_anytime_setsTitleIntoView(ApplicationPresenter.MyView myView) {
        //given
        String title = "GWTP Samples - Unit Testing";

        //when
        provider.get().onReveal();

        //then
        verify(myView).setTitle(title);
    }

    @Test
    public void onBind_anytime_setsHeaderPresenterInSlot(HeaderPresenter headerPresenter,
                                                         ApplicationPresenter.MyView myView) {
        //when
        provider.get(); // this call will instantiate the ApplicationPresenter, then call onBind()

        //then
        verify(myView).setInSlot(ApplicationPresenter.HEADER_SLOT, headerPresenter);
    }
}
