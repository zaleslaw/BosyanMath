package primitives.vector;

import java.util.Arrays;

public class DenseVector extends AbstractVector {
    private double[] data;

    public DenseVector(double[] values) {
        super();
        data = Arrays.copyOf(values, values.length);
    }

    @Override public double get(int index) {
        return data[index];
    }

    @Override public void set(int index, double feature) {
        data[index] = feature;
    }


    @Override public int size() {
        return data.length;
    }
}
