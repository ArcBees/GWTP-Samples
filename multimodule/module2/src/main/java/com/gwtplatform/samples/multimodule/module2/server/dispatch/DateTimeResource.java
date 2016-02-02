/*
 * Copyright 2016 ArcBees Inc.
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

package com.gwtplatform.samples.multimodule.module2.server.dispatch;

import java.util.Date;

import javax.inject.Singleton;

import com.gwtplatform.samples.multimodule.module2.shared.DateTimeEndPoint;

@Singleton
public class DateTimeResource implements DateTimeEndPoint {
    DateTimeResource() {
    }

    @Override
    public String currentDateTime() {
        return new Date().toString();
    }
}
