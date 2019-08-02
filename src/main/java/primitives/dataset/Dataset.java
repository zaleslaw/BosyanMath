package primitives.dataset;

public interface Dataset<Row extends DatasetRow> {
    void set(int rowKey, int featureIndex, double featureValue);

    void set(int rowKey, String featureName, double featureValue);

    double get(int rowKey, int featureIndex);

    double get(int rowKey, String featureName);

    void setRow(int rowKey, Row datasetRow);

    Row getRow(int rowKey);
}
