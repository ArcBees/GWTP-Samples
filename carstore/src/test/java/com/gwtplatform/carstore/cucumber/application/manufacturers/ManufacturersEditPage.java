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

package com.gwtplatform.carstore.cucumber.application.manufacturers;

import org.openqa.selenium.WebElement;

import com.gwtplatform.carstore.cucumber.application.BasePage;
import com.gwtplatform.carstore.cucumber.util.ByDebugId;

import static com.gwtplatform.carstore.client.debug.DebugIds.DBG_MANUFACTURER_CLOSE;
import static com.gwtplatform.carstore.client.debug.DebugIds.DBG_MANUFACTURER_EDITOR;
import static com.gwtplatform.carstore.client.debug.DebugIds.DBG_MANUFACTURER_INPUT;
import static com.gwtplatform.carstore.client.debug.DebugIds.DBG_MANUFACTURER_SAVE;

public class ManufacturersEditPage extends BasePage {
    public void setManufacturer(String manufacturer) {
        WebElement manufacturerInput = getManufacturerInput();
        manufacturerInput.clear();
        manufacturerInput.sendKeys(manufacturer);
    }

    public String getManufacturer() {
        return getManufacturerInput().getText();
    }

    public void clickOnSave() {
        getSaveButton().click();
    }

    public void clickOnClose() {
        getCloseButton().click();
    }

    public boolean isManufacturerEditorVisible() {
        return getManufacturerEditor().isDisplayed();
    }

    private WebElement getManufacturerInput() {
        return waitUntilPresenceOfElementLocated(ByDebugId.id(DBG_MANUFACTURER_INPUT));
    }

    private WebElement getSaveButton() {
        return waitUntilElementIsClickable(ByDebugId.id(DBG_MANUFACTURER_SAVE));
    }

    private WebElement getCloseButton() {
        return waitUntilElementIsClickable(ByDebugId.id(DBG_MANUFACTURER_CLOSE));
    }

    private WebElement getManufacturerEditor() {
        return waitUntilElementIsVisible(ByDebugId.id(DBG_MANUFACTURER_EDITOR));
    }
}
