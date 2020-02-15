package edu.byu.civil.queuesimulator;

import org.apache.log4j.Logger;

import java.util.Random;

public class Simulator {
    private static Logger log = Logger.getLogger(Simulator.class);

    private Random r = new Random(145);
    private PoissonArrival arrivalTime;
    private PoissonArrival serviceTime;

    private FutureEventList fel = new FutureEventList();
    private double t = 0;
    private double endtime = 300;

    private ServiceCenter sc;

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

        this.sc = new ServiceCenter(N);
    }

    /**
     * Run the simulation
     */
    public void runSimulation() {

        // kick off first arrival
        fel.addEvent(new Event(Event.ARRIVAL, t + arrivalTime.nextArrival()));

        // Run through event list
        while(t < endtime) {
            Event e = fel.nextEvent();
            t = e.getTime();

            switch (e.getType()) {
                case Event.ARRIVAL: {
                    // Create a customer and add them to the counter or the queue
                    Customer customer = new Customer(serviceTime.nextArrival());


                    // Schedule next arrival
                    fel.addEvent(new Event(Event.ARRIVAL, t + arrivalTime.nextArrival()));
                    break;
                }
                // Remove customer from counter, grab next customer in queue
                case Event.DEPARTURE: {

                    break;
                }

            }
        }


    }


    // When we run the class, this gets executed.
    public static void main(String[] args) {
        log.info("Beginning a new BYU Queuesim");
        Simulator simulator = new Simulator(75/3600., 150/3600., 1);
        simulator.runSimulation();
        log.info("Ending BYU Queuesim");

    }
}
