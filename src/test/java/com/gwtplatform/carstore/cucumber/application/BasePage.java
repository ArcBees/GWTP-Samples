/*
 * Copyright 2013 ArcBees Inc.
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

package com.gwtplatform.carstore.cucumber.application;

import javax.inject.Inject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.gwtplatform.carstore.cucumber.util.TestParameters;

public class BasePage {
    @Inject
    private static ElementLocatorFactory elementLocatorFactory;

    @Inject
    protected WebDriver webDriver;

    protected BasePage() {
        PageFactory.initElements(elementLocatorFactory, this);
    }

    public void getUrl(String url) {
        webDriver.get(url);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void waitUntilPlaceIsLoaded(final String nameToken) {
        webDriverWait().until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return webDriver.getCurrentUrl().contains("#" + nameToken);
            }
        });
    }

    protected void chooseOkOnNextConfirm() {
        ((JavascriptExecutor) webDriver).executeScript("window.confirm = function(msg){return true;};");
    }

    protected void chooseCancelOnNextConfirm() {
        ((JavascriptExecutor) webDriver).executeScript("window.confirm = function(msg){return false;};");
    }

    protected WebElement waitUntilElementIsLoaded(String id) {
        return waitUntilElementIsLoaded(By.id(id));
    }

    protected WebElement waitUntilElementIsLoaded(By locator) {
        return waitUntilElementIsLoaded(webDriver, locator);
    }

    protected void waitUntilElementIsVisible(WebElement element) {
        webDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilElementIsDetached(WebElement element) {
        webDriverWait().until(ExpectedConditions.stalenessOf(element));
    }

    protected WebElement waitUntilElementIsLoaded(final SearchContext parent, final By locator) {
        return webDriverWait().until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver input) {
                return parent.findElement(locator);
            }
        });
    }

    private WebDriverWait webDriverWait() {
        return new WebDriverWait(webDriver, TestParameters.TIME_OUT_IN_SECONDS);
    }
}
