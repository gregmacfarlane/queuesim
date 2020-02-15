package edu.byu.civil.queuesimulator;

import org.apache.log4j.Logger;

import java.util.Random;

public class Simulator {
    private static Logger log = Logger.getLogger(Simulator.class);

    private Random r = new Random(145);
    private PoissonArrival arrivalTime;
    private PoissonArrival serviceTime;

    private FutureEventList fel = new FutureEventList();

    /**
     * Instantiate an object of the simulator class with a given M/M/N (Inf, FIFO)
     * @param lambda Arrival rate
     * @param mu Service rate
     * @param N Number of service counters
     */
    public Simulator(double lambda, double mu, int N){
        log.info("Creating arrival distribution");
        arrivalTime = new PoissonArrival(lambda, r);
        log.info("Creating service distribution");
        serviceTime = new PoissonArrival(mu, r);

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
