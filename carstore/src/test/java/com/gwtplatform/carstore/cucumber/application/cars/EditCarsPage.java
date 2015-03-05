/**
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

package com.gwtplatform.carstore.cucumber.application.cars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.gwtplatform.carstore.cucumber.application.BasePage;
import com.gwtplatform.carstore.cucumber.util.ByDebugId;

public class EditCarsPage extends BasePage {
    public String getCurrentCarTabName() {
        WebElement selectedTab = getCarsTabs().findElement(By.className("gwt-TabBarItem-selected"));
        WebElement tabNameContainer = selectedTab.findElement(By.cssSelector("span"));
        return tabNameContainer.getText();
    }

    public void setCarManufacturer(String manufacturer) {
        Select manufacturerSelect = new Select(getCarManufacturerInput());
        manufacturerSelect.selectByVisibleText(manufacturer);
    }

    public void setCarModel(String model) {
        getCarModelInput().clear();
        getCarModelInput().sendKeys(model);
    }

    public void clickOnSave() {
        getSaveButton().click();
    }

    public void clickOnClose() {
        getCloseButton().click();
    }

    private WebElement getCarsTabs() {
        return waitUntilElementIsClickable(ByDebugId.id("cars-tab-panel"));
    }

    private WebElement getCarModelInput() {
        return waitUntilElementIsClickable(ByDebugId.id("car-model-input"));
    }

    private WebElement getCarManufacturerInput() {
        return waitUntilElementIsClickable(ByDebugId.id("car-manufacturer-input"));
    }

    private WebElement getCarPropertiesEditor() {
        return waitUntilElementIsVisible(ByDebugId.id("car-properties-editor"));
    }

    private WebElement getSaveButton() {
        return waitUntilElementIsClickable(ByDebugId.id("car-save"));
    }

    private WebElement getCloseButton() {
        return waitUntilElementIsClickable(ByDebugId.id("car-close"));
    }
}
