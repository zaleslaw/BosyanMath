package ml.trainer;

import org.junit.Before;
import org.junit.Test;
import primitives.dataset.Dataset;

public class FakeTrainerTest {
    Dataset ds;


    @Before
    public void setUp() throws Exception {
        ds = DatasetLoader.loadFromTxt();
    }

    @Test
    public void fit() {

    }
}