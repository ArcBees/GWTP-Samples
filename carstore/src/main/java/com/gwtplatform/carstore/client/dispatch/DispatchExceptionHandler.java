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

package com.gwtplatform.carstore.client.dispatch;

import javax.inject.Inject;
import javax.inject.Provider;

import com.gwtplatform.carstore.client.application.ApplicationPresenter;
import com.gwtplatform.carstore.client.application.event.DisplayMessageEvent;
import com.gwtplatform.carstore.client.application.widget.message.Message;
import com.gwtplatform.carstore.client.application.widget.message.MessageStyle;
import com.gwtplatform.dispatch.client.ExceptionHandler;
import com.gwtplatform.dispatch.rest.shared.ActionResponseException;
import com.gwtplatform.dispatch.rest.shared.RestActionException;
import com.gwtplatform.dispatch.shared.ActionException;

public class DispatchExceptionHandler implements ExceptionHandler {

    private final Provider<ApplicationPresenter> appPresenterProvider;

    @Inject
    DispatchExceptionHandler(Provider<ApplicationPresenter> appPresenterProvider) {
        this.appPresenterProvider = appPresenterProvider;
    }

    @Override
    public Status onFailure(Throwable e) {
        if (e instanceof ActionException) {
            return handleActionExceptions((ActionException) e);
        }

        return Status.CONTINUE;
    }

    private Status handleActionExceptions(ActionException e) {
        Status status;
        if (e instanceof RestActionException) {
            // This is a REST action exception
            status = handleRestActionExceptions((RestActionException) e);
        } else {
            // This is an RPC action exception
            status = handleRpcActionExceptions(e);
        }

        return status;
    }

    private Status handleRestActionExceptions(RestActionException e) {
        Status status = Status.CONTINUE;

        if (e instanceof ActionResponseException) {
            // Unauthorized access exception
            if (((ActionResponseException) e).getStatusCode() == 401) {
                DisplayMessageEvent.fire(appPresenterProvider.get(), new Message(
                        "You do not have access to this part of the system.", MessageStyle.ERROR));

                status = Status.STOP;
            }
        }

        return status;
    }

    private Status handleRpcActionExceptions(ActionException e) {
        return Status.CONTINUE;
    }
}
