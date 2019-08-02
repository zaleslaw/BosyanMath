package primitives.dataset.impl;

import java.util.HashMap;
import java.util.Map;
import primitives.dataset.AbstractDataset;
import primitives.dataset.LabeledDatasetRow;

public class LocalLabeledDataset extends AbstractDataset<LabeledDatasetRow> {
    private Map<Integer, LabeledDatasetRow> data = new HashMap<>();

    @Override public void set(int rowKey, int featureIndex, double featureValue) {
        if (data.containsKey(rowKey)) data.get(rowKey).set(featureIndex, featureValue);
        else {
            LabeledDatasetRow row = new LabeledDatasetRow();
            row.set(featureIndex, featureValue);
            data.put(rowKey, row);
        }
        ;
    }

    @Override public void set(int rowKey, String featureName, double featureValue) {

    }

    @Override public double get(int rowKey, int featureIndex) {
        if (data.containsKey(rowKey)) {
            final double featureValue = data.get(rowKey).get(featureIndex);
            return featureValue;
        } else throw new NullPointerException("No key");
    }

    @Override public double get(int rowKey, String featureName) {
        return 0;
    }

    @Override public void setRow(int rowKey, LabeledDatasetRow datasetRow) {
        data.put(rowKey, datasetRow);
    }

    @Override public LabeledDatasetRow getRow(int rowKey) {
        if (data.containsKey(rowKey)) return data.get(rowKey);
        else throw new NullPointerException("No key");
    }

    /**
     * Returns label if label is attached or null if label is missed.
     *
     * @param index Index of observation.
     * @return Label.
     */
    public double label(int index) {
        LabeledDatasetRow labeledVector = data.get(index);

        if (labeledVector != null)
            return labeledVector.label();
        else
            return Double.NaN;
    }


    /**
     * Fill the label with given value.
     *
     * @param index Index of observation.
     * @param lb    The given label.
     */
    public void setLabel(int index, double lb) {
        LabeledDatasetRow labeledVector = data.get(index);

        if (labeledVector != null)
            labeledVector.setLabel(lb);
       /*else   // maybe create empty vector or log warning in debug mode
            throw new NoLabelVectorException(idx);*/
    }
}
