/*
 * Copyright 2019 GridGain Systems, Inc. and Contributors.
 *
 * Licensed under the GridGain Community Edition License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.gridgain.com/products/software/community-edition/gridgain-community-edition-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package genetic;

import java.util.function.Function;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link Population}.
 */
public class PopulationTest {
    /** Amount of the best chromosomes. */
    public static final int K = 10;

    /** Test population. */
    Population population;

    /** Precision. */
    private static final double PRECISION = 0.00000001;

    /** Fitness function. */
    Function<Chromosome, Double> fitnessFunction = (Chromosome ch) -> ch.getGene(0) + ch.getGene(1);

    /**
     *
     */
    @Before
    public void setUp() {
        population = new Population(100);
        Double[] chromosomeData = new Double[2];
        for (int i = 0; i < population.size(); i++) {
            chromosomeData[0] = (double) i;
            chromosomeData[1] = (double) i;
            population.setChromosome(i, new Chromosome(chromosomeData));
        }
    }

    /**
     *
     */
    @Test
    public void calculateFitnessForChromosome() {
        population.calculateFitnessForChromosome(0, fitnessFunction);
        Assert.assertEquals(population.getChromosome(0).getFitness(), 0, PRECISION);
    }

    /**
     *
     */
    @Test
    public void calculateFitnessForAll() {
        population.calculateFitnessForAll(fitnessFunction);
        Assert.assertEquals(population.getChromosome(0).getFitness(), 0, PRECISION);
    }

    /**
     *
     */
    @Test
    public void selectBestKChromosomeWithoutFitnessCalculation() {
        Assert.assertNull(population.selectBestKChromosome(K));
    }

    /**
     *
     */
    @Test
    public void selectBestKChromosomeWithPartiallyFitnessCalculation() {
        population.calculateFitnessForChromosome(0, fitnessFunction);
        population.calculateFitnessForChromosome(1, fitnessFunction);
        Assert.assertNull(population.selectBestKChromosome(K));
    }

    /**
     *
     */
    @Test
    public void selectBestKChromosome() {
        population.calculateFitnessForAll(fitnessFunction);
        Chromosome[] res = population.selectBestKChromosome(K);
        Assert.assertEquals(res[0].getFitness(), 180, PRECISION);
    }

    /**
     *
     */
    @Test
    public void getTotalFitness() {
        double res = population.getTotalFitness();
        Assert.assertEquals(res, Double.NaN, PRECISION);

        population.calculateFitnessForAll(fitnessFunction);
        res = population.getTotalFitness();
        Assert.assertEquals(res, 9900.0, PRECISION);
    }

    /**
     *
     */
    @Test
    public void getAverageFitness() {
        double res = population.getAverageFitness();
        Assert.assertEquals(res, Double.NaN, PRECISION);

        population.calculateFitnessForAll(fitnessFunction);
        res = population.getAverageFitness();
        Assert.assertEquals(res, 99.0, PRECISION);
    }
}