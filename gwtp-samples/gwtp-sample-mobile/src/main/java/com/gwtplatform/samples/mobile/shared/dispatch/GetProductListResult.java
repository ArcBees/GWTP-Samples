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

package com.gwtplatform.samples.mobile.shared.dispatch;

import java.util.ArrayList;

import com.gwtplatform.dispatch.rpc.shared.Result;

public class GetProductListResult implements Result {
    private ArrayList<Product> products;

    public GetProductListResult(ArrayList<Product> products) {
        this.products = products;
    }

    protected GetProductListResult() {
        // Possibly for serialization.
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GetProductListResult other = (GetProductListResult) obj;
        if (products == null) {
            if (other.products != null) {
                return false;
            }
        } else if (!products.equals(other.products)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 23;
        hashCode = (hashCode * 37) + (products == null ? 1 : products.hashCode());
        return hashCode;
    }

    @Override
    public String toString() {
        return "GetProductListResult[" + products + "]";
    }
}
