/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package primitives.dataset;

import primitives.vector.Vector;

/** Class to keep one observation in dataset. This is a base class for labeled and unlabeled rows. */
public class DatasetRow<V extends Vector> {
    /** Id. */
    protected Integer id;

    /** Vector. */
    protected V vector;

    /**
     * Default constructor (required by Externalizable).
     */
    public DatasetRow() {
    }

    /**
     *
     */
    public DatasetRow(V vector) {
        this.vector = vector;
    }

    /**
     * Get the vector.
     *
     * @return Vector.
     */
    public V features() {
        return vector;
    }


    /**
     * Gets cardinality of dataset row (maximum number of the elements).
     *
     * @return This dataset row's cardinality.
     */
    public int size() {
        return vector.size();
    }

    /**
     * Gets the value at specified index.
     *
     * @param idx DatasetRow index.
     * @return DatasetRow value.
     */
    public double get(int idx) {
        return vector.get(idx);
    }

    /**
     * Sets value.
     *
     * @param idx Dataset row index to set value at.
     * @param val Value to set.
     */
    public void set(int idx, double val) {
        vector.set(idx, val);
    }
}
