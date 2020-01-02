package edu.byu.civil.queuesimulator;

import java.util.Random;

public class PoissonArrival {

    private Random random;
    private double lambda;

    public PoissonArrival(double lambda, int seed) {
        this.lambda = lambda;
        this.random = new Random(seed);
    }

    public double nextRandom() {
        double u = random.nextDouble();
        return -Math.log(u) / lambda;
    }

}
