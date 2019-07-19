package genetic;

import java.util.Arrays;
import java.util.BitSet;
import java.util.function.Function;

/**
 * Represents a populations of chromosomes.
 */
public class Population {
    /** Chromosomes. */
    private Chromosome[] chromosomes;

    /** Fitness calculated flags. */
    private BitSet fitnessCalculatedFlags;

    /**
     * @param size Size.
     */
    public Population(int size) {
        chromosomes = new Chromosome[size];
        fitnessCalculatedFlags = new BitSet(size);
    }

    /**
     * Returns an individual chromosome.
     *
     * @param idx Index of chromosome.
     */
    public Chromosome getChromosome(int idx){
        return chromosomes[idx];
    }

    /**
     * Calculates fitness for chromosome found by index with custom fitness function.
     *
     * @param idx Index.
     * @param fitnessFunction Fitness function.
     */
    public double calculateFitnessForChromosome(int idx, Function<Chromosome, Double> fitnessFunction){
        double fitness = fitnessFunction.apply(chromosomes[idx]);
        chromosomes[idx].setFitness(fitness);
        fitnessCalculatedFlags.set(idx);
        return fitness;
    }


    /**
     * Calculates fintness for all chromosomes with custom fitness function.
     *
     * @param fitnessFunction Fitness function.
     */
    public void calculateFitnessForAll(Function<Chromosome, Double> fitnessFunction) {
        for (int i = 0; i < chromosomes.length; i++)
            calculateFitnessForChromosome(i, fitnessFunction);
    }

    /**
     * Sets the chromsome for given index.
     *
     * @param idx Index.
     * @param chromosome Chromosome.
     */
    public void setChromosome(int idx, Chromosome chromosome) {
        chromosomes[idx] = chromosome;
        if (!Double.isNaN(chromosome.getFitness())) fitnessCalculatedFlags.set(idx);

    }


    /**
     * Returns the chromosome by given index.
     *
     * @param idx Index.
     */
    public Chromosome getChromosome(Integer idx) {
        return chromosomes[idx];
    }

    /**
     * Selects the top K chromosomes by fitness value from the smallest to the largest.
     *
     * @param k The amount of top chromosome with highest value of the fitness.
     *
     * Returns null if not all fitnesses are calculated for all chromosomes.
     */
    public Chromosome[] selectBestKChromosome(int k) {
        if (fitnessCalculatedFlags.cardinality() == chromosomes.length) {
            Chromosome[] cp = Arrays.copyOf(chromosomes, chromosomes.length);
            Arrays.sort(cp);
            return Arrays.copyOfRange(cp, cp.length - k, cp.length);
        }
        return null;
    }

    /**
     * Returns the total fitness value of population or Double.NaN if not all fitnesses are calculated for all chromosomes.
     */
    public double getTotalFitness() {
        if (fitnessCalculatedFlags.cardinality() == chromosomes.length) {
            double totalFitness = 0.0;

            for (int i = 0; i < chromosomes.length; i++)
                totalFitness += chromosomes[i].getFitness();

            return totalFitness;
        }
        return Double.NaN;
    }

    /**
     * Returns the average fitness of population or Double.NaN if not all fitnesses are calculated for all chromosomes.
     */
    public double getAverageFitness() {
        if (fitnessCalculatedFlags.cardinality() == chromosomes.length) {
            double totalFitness = 0.0;

            for (int i = 0; i < chromosomes.length; i++)
                totalFitness += chromosomes[i].getFitness();

            return totalFitness / chromosomes.length;
        }
        return Double.NaN;
    }


    /**
     * Returns the size of population.
     */
    public int size() {
        return chromosomes.length;
    }


    /**
     * Sets the fitness value for chromosome with the given index.
     *
     * @param idx Index.
     * @param fitness Fitness.
     */
    public void setFitness(Integer idx, Double fitness) {
        chromosomes[idx].setFitness(fitness);
        fitnessCalculatedFlags.set(idx);
    }
}
