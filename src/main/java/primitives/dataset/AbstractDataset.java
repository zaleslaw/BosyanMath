package primitives.dataset;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDataset<Row extends DatasetRow> implements Dataset<Row> {
    protected Map<String, Integer> featureNamesToIndexes = new HashMap<>();
}
