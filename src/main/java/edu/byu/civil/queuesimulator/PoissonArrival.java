package edu.byu.civil.queuesimulator;

import org.apache.log4j.Logger;

import java.util.Random;

public class PoissonArrival {
    private static Logger log = Logger.getLogger(PoissonArrival.class);
    Double lambda;
    Random r;

    /**
     * Create a random Poisson arrival grabber
     * @param lambda
     * @param r
     */
    public PoissonArrival(Double lambda, Random r) {
        log.info("Creating new random event distribution with rate " + lambda);
        this.lambda = lambda;
    }

    /**
     * Get the time until the next arrival from an exponential distribution
     * @return time until next arrival
     */
    public Double nextArrival(){
        Double x = r.nextDouble();
        return -Math.log(x) / lambda;
    }


}
