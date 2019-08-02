package primitives.etl;

import java.util.List;

public interface RawRow {
    int key();

    Object value(int index);

    List<Object> values();
}
