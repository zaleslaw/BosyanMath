package ml;

import primitives.dataset.Dataset;

public interface Trainer<M extends Model, D extends Dataset> {
    M fit(D dataset);
}