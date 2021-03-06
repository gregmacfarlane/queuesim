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
    private double endtime = 5;

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

        // Create an arrival event for the first customer
        Customer customer = new Customer(serviceTime.nextArrival());
        Event firstEvent = new Event(Event.ARRIVAL, t + arrivalTime.nextArrival());
        firstEvent.setCustomer(customer);
        fel.addEvent(firstEvent);


        // Run through event list
        while(t < endtime) {
            Event e = fel.nextEvent();
            t = e.getTime();

            switch (e.getType()) {
                case Event.ARRIVAL: {
                    // Create a customer and add them to the counter or the queue
                    fel.addEvent(sc.processArrival(e.getCustomer(), t));

                    // Schedule the next customer's arrival
                    Event nextArrivalEvent = new Event(Event.ARRIVAL, t + arrivalTime.nextArrival());
                    Customer nextCustomer = new Customer(serviceTime.nextArrival());
                    nextArrivalEvent.setCustomer(nextCustomer);
                    fel.addEvent(nextArrivalEvent);

                    break;
                }
                // Remove customer from counter, grab next customer in queue
                case Event.DEPARTURE: {
                    fel.addEvent(sc.processDeparture(e, t));
                    break;
                }
            }
        }
    }

    public void printStats() {
        log.info("====== SIMULATION STATS ==========");
        log.info("Total Arrived: " + sc.getCustomersArrived());
        log.info("Total Served: " + sc.getCustomersServed());
        log.info("Total Queued: " + sc.getCustomersQueued());
        log.info("Maximum queue size: " + sc.getMaxQueueLength());
        log.info("Average time in system: " + sc.getAverageSystemTime());
        log.info("Average time in queue for queued customers: " + sc.getAverageQueueTime());
        log.info("Time at queue length 0: " + sc.getTimeatQueueLength(0));
        log.info("Time at queue length 1: " + sc.getTimeatQueueLength(1));
        log.info("Time at queue length 2: " + sc.getTimeatQueueLength(2));
        log.info("Time at queue length 3: " + sc.getTimeatQueueLength(3));
        log.info("====== SIMULATION STATS ==========");
    }


    // When we run the class, this gets executed.
    public static void main(String[] args) {
        log.info("Beginning a new BYU Queuesim");
        Double lambda = Double.valueOf(args[0]);
        Double mu     = Double.valueOf(args[1]);
        Integer N     = Integer.valueOf(args[2]);


        Simulator simulator = new Simulator(lambda, mu, N);
        simulator.runSimulation();
        simulator.printStats();

        log.info("Ending BYU Queuesim");

    }
}
