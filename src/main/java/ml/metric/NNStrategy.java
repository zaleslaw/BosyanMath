package ml.metric;

/** This enum contains settings for kNN algorithm. */
public enum NNStrategy {
    /**
     * The default strategy. All k neighbors have the same weight which is independent
     * on their distance to the query point.
     */
    SIMPLE,

    /**
     * A refinement of the k-NN classification algorithm is to weigh the contribution of each of the k neighbors
     * according to their distance to the query point, giving greater weight to closer neighbors.
     */
    WEIGHTED
}
