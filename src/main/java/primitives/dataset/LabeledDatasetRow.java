package primitives.dataset;

import primitives.vector.Vector;

public class LabeledDatasetRow extends DatasetRow<Vector> {
    /** Label. */
    private double lb;

    /**
     * Default constructor.
     */
    public LabeledDatasetRow() {
        super();
    }

    /**
     * Construct labeled vector.
     *
     * @param vector Vector.
     * @param lb     Label.
     */
    public LabeledDatasetRow(Vector vector, double lb) {
        super(vector);
        this.lb = lb;
    }

    /**
     * Get the label.
     *
     * @return Label.
     */
    public double label() {
        return lb;
    }

    /**
     * Set the label
     *
     * @param lb Label.
     */
    public void setLabel(double lb) {
        this.lb = lb;
    }
}

