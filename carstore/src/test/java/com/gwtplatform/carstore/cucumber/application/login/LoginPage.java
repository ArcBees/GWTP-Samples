/*
 * Copyright 2013 ArcBees Inc.
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

package com.gwtplatform.carstore.cucumber.application.login;

import org.openqa.selenium.WebElement;

import com.google.inject.Inject;
import com.gwtplatform.carstore.client.place.NameTokens;
import com.gwtplatform.carstore.cucumber.application.BasePage;
import com.gwtplatform.carstore.cucumber.application.widgets.HeaderWidgetPage;
import com.gwtplatform.carstore.cucumber.util.ByDebugId;

import static com.gwtplatform.carstore.client.debug.DebugIds.DBG_LOGIN;
import static com.gwtplatform.carstore.client.debug.DebugIds.DBG_PASSWORD;
import static com.gwtplatform.carstore.client.debug.DebugIds.DBG_USERNAME;

public class LoginPage extends BasePage {
    private final HeaderWidgetPage headerWidgetPage;

    @Inject
    LoginPage(
            HeaderWidgetPage headerWidgetPage) {
        this.headerWidgetPage = headerWidgetPage;
    }

    public void setUsername(String username) {
        getUserName().sendKeys(username);
    }

    public void setPassword(String password) {
        getPassword().sendKeys(password);
    }

    public void submitLoginForm() {
        getLogin().click();
    }

    public Boolean isOnLoginPage() {
        return webDriver.getCurrentUrl().contains("#" + NameTokens.LOGIN);
    }

    public void waitUntilLoggedIn() {
        headerWidgetPage.waitUntilLogoutIsClickable();
    }

    private WebElement getUserName() {
        return waitUntilElementIsClickable(ByDebugId.id(DBG_USERNAME));
    }

    private WebElement getPassword() {
        return waitUntilElementIsClickable(ByDebugId.id(DBG_PASSWORD));
    }

    private WebElement getLogin() {
        return waitUntilElementIsClickable(ByDebugId.id(DBG_LOGIN));
    }
}
