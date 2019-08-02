package ml.trainer;

import ml.Model;
import primitives.vector.Vector;

public class FakeModel implements Model<Vector, Double> {
    @Override public Double predict(Vector input) {
        return 1.0;
    }
}
