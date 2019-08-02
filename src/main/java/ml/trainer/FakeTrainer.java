package ml.trainer;

import ml.Trainer;
import primitives.dataset.impl.LocalLabeledDataset;

public class FakeTrainer implements Trainer<FakeModel, LocalLabeledDataset> {
    @Override public FakeModel fit(LocalLabeledDataset dataset) {
        return new FakeModel();
    }
}
