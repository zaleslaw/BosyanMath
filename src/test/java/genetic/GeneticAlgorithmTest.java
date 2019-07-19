package genetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link GeneticAlgorithm}.
 */
public class GeneticAlgorithmTest {
    /** Amount of genes in chromosome. */
    public static final int AMOUNT_OF_GENES_IN_CHROMOSOME = 8;

    /** Precision. */
    private static final double PRECISION = 0.00000001;

    /** Fitness function. */
    Function<Chromosome, Double> fitnessFunction = (Chromosome ch) -> {
        double fitness = 0;
        for (int i = 0; i < ch.size(); i += 2) fitness += ch.getGene(i);
        return fitness;
    };

    /** Random. */
    Random rnd = new Random(1234L);

    /** Genetic algorithm instance. */
    private GeneticAlgorithm ga;

    /**
     *
     */
    @Before
    public void setUp() {
        List<Double[]> rawData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Double[] chromosomeData = new Double[AMOUNT_OF_GENES_IN_CHROMOSOME];
            for (int j = 0; j < AMOUNT_OF_GENES_IN_CHROMOSOME; j++)
                chromosomeData[j] = rnd.nextDouble();
            rawData.add(i, chromosomeData);
        }


        ga = new GeneticAlgorithm(rawData);
        BiFunction<Integer, Double, Double> mutator = (integer, aDouble) -> rnd.nextDouble() > 0.5 ? aDouble + (rnd.nextDouble() / 100) : aDouble - (rnd.nextDouble() / 100);

        ga.withFitnessFunction(fitnessFunction)
            .withMutationOperator(mutator)
            .withAmountOfEliteChromosomes(10)
            .withCrossingoverProbability(0.01)
            .withCrossoverStgy(CrossoverStrategy.ONE_POINT)
            .withAmountOfGenerations(100)
            .withSelectionStgy(SelectionStrategy.ROULETTE_WHEEL)
            .withMutationProbability(0.05);
    }

    /**
     *
     */
    @Test
    public void runGeneticAlgorithm() {
        ga.run();
        double[] expBestSolution = {0.9227093559081438, 0.8716316379636383, 0.9393034992555963, 0.9264946442527818,
            0.8030164650964057, 0.41871505180713764, 1.0294056830181408, 0.5760945730781087};
        Assert.assertArrayEquals(ga.getTheBestSolution(), expBestSolution, PRECISION);
    }

    /**
     *
     */
    @Test
    public void runParallelGeneticAlgorithm() {
        ga.run();
        double[] expBestSolution = {0.9227093559081438, 0.8716316379636383, 0.9393034992555963, 0.9264946442527818,
            0.8030164650964057, 0.41871505180713764, 1.0294056830181408, 0.5760945730781087};
        Assert.assertArrayEquals(ga.getTheBestSolution(), expBestSolution, PRECISION);
    }
}