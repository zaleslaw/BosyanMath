package primitives.dataset.impl;

import primitives.dataset.AbstractDataset;
import primitives.dataset.DatasetRow;

public class IgniteDataset extends AbstractDataset {
    @Override public void set(int rowKey, int featureIndex, double featureValue) {

    }

    @Override public void set(int rowKey, String featureName, double featureValue) {

    }

    @Override public double get(int rowKey, int featureIndex) {
        return 0;
    }

    @Override public double get(int rowKey, String featureName) {
        return 0;
    }

    @Override public void appendRow(DatasetRow datasetRow) {

    }

    @Override public void setRow(int rowKey, DatasetRow datasetRow) {

    }

    @Override public DatasetRow getRow(int rowKey) {
        return null;
    }
}
