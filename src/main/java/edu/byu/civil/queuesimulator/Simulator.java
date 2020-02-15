package edu.byu.civil.queuesimulator;

import org.apache.log4j.Logger;

public class Simulator {
    private static Logger log = Logger.getLogger(Simulator.class);


    /**
     * Instantiate an object of the simulator class with a given M/M/N (Inf, FIFO)
     * @param lambda Arrival rate
     * @param mu Service rate
     * @param N Number of service counters
     */
    public Simulator(double lambda, double mu, int N){

    }

    /**
     * Run the simulation
     */
    public void runSimulation() {

    }


    // When we run the class, this gets executed.
    public static void main(String[] args) {
        log.info("Beginning a new BYU Queuesim");
        Simulator simulator = new Simulator(5, 10, 1);
        simulator.runSimulation();
        log.info("Ending BYU Queuesim");

    }
}
