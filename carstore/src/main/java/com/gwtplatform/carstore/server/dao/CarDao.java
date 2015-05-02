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

package com.gwtplatform.carstore.server.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import com.gwtplatform.carstore.server.dao.domain.Car;
import com.gwtplatform.carstore.server.dao.domain.Rating;
import com.gwtplatform.carstore.shared.dto.ManufacturerRatingDto;

public class CarDao extends BaseDao<Car> {
    private final CarPropertiesDao carPropertiesDao;
    private final RatingDao ratingDao;

    @Inject
    public CarDao(
            CarPropertiesDao carPropertiesDao,
            RatingDao ratingDao) {
        super(Car.class);

        this.carPropertiesDao = carPropertiesDao;
        this.ratingDao = ratingDao;
    }

    // TODO overwrite other delete methods
    // TODO test that associated ratings and carProperties get deleted
    @Override
    public void delete(Long id) {
        Car car = get(id);
        carPropertiesDao.delete(car.getCarProperties());

        Key<Car> carKey = Key.create(Car.class, id);
        Query<Rating> ratings = ratingDao.query().filter("car", carKey);
        ratingDao.delete(ratings.list());

        super.delete(id);
    }

    public List<ManufacturerRatingDto> getAverageCarRatingByManufacturer() {
        // TODO: Not implemented yet
        return new ArrayList<>();
    }
}
