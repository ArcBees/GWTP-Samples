/*
 * Copyright 2014 ArcBees Inc.
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

package com.gwtplatform.carstore.cucumber.application.stats;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.gwtplatform.carstore.cucumber.application.BasePage;
import com.gwtplatform.carstore.cucumber.util.ByDebugId;

import static com.gwtplatform.carstore.client.debug.DebugIds.DBG_EXTRACT_YEAR_BUTTON;
import static com.gwtplatform.carstore.client.debug.DebugIds.DBG_EXTRACT_YEAR_DATE_PICKER;
import static com.gwtplatform.carstore.client.debug.DebugIds.DBG_EXTRACT_YEAR_RESULT;

public class StatsPage extends BasePage {
    public void selectDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMM");
        WebElement datePickerMonth = getDatePicker().findElement(By.className("datePickerMonth"));
        Date datePickerDate = getCurrentDatePickerDate(dateFormat, datePickerMonth);
        WebElement navigateCalendarButton = getNavigateCalendarButton(calendar, datePickerDate);

        navigateToMonth(calendar.getTime(), dateFormat, datePickerMonth, navigateCalendarButton);
        clickCalendarDay(day);
    }

    public void extractYear() {
        getButton().click();
    }

    public int getExtractedYear() {
        String year = getResult().getText();

        try {
            return Integer.valueOf(year);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private Date getCurrentDatePickerDate(SimpleDateFormat dateFormat, WebElement datePickerMonth) {
        Date datePickerDate;
        try {
            datePickerDate = dateFormat.parse(datePickerMonth.getText());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return datePickerDate;
    }

    private WebElement getNavigateCalendarButton(Calendar calendar, Date datePickerDate) {
        WebElement navigateCalendarButton;
        if (calendar.before(datePickerDate)) {
            navigateCalendarButton = getDatePicker().findElement(By.className("datePickerNextButton"));
        } else {
            navigateCalendarButton = getDatePicker().findElement(By.className("datePickerPreviousButton"));
        }
        return navigateCalendarButton;
    }

    private void navigateToMonth(Date dateToSelect, SimpleDateFormat dateFormat, WebElement datePickerMonth,
            WebElement navigateButton) {
        String expectedDate = dateFormat.format(dateToSelect);
        while (!datePickerMonth.getText().equals(expectedDate)) {
            navigateButton.click();
        }
    }

    private void clickCalendarDay(int day) {
        WebElement dayElement = getDatePicker().findElement(By.xpath("//div[contains(@class,'datePickerDay')" +
                "and not(contains(@class,'datePickerDayIsFiller'))" +
                "and text()=" + day + "]"));
        dayElement.click();
    }

    private WebElement getDatePicker() {
        return waitUntilElementIsClickable(ByDebugId.id(DBG_EXTRACT_YEAR_DATE_PICKER));
    }

    private WebElement getButton() {
        return waitUntilElementIsClickable(ByDebugId.id(DBG_EXTRACT_YEAR_BUTTON));
    }

    private WebElement getResult() {
        return waitUntilElementIsClickable(ByDebugId.id(DBG_EXTRACT_YEAR_RESULT));
    }
}
