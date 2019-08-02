package ml;

/**
 * Inference model that can be used to make predictions.
 *
 * @param <I> Type of model input.
 * @param <O> Type of model output.
 */
public interface Model<I, O> {
    /**
     * Make a prediction for the specified input arguments.
     *
     * @param input Input arguments.
     * @return Prediction result.
     */
    public O predict(I input);
}
