package edu.byu.civil.queuesimulator;

import org.apache.log4j.Logger;

public class Main {
    private static Logger log = Logger.getLogger(Main.class);

    private static String myString = "Hello World";

    // When we run the class, this gets executed.
    public static void main(String[] args) {

        // Create two new random arrival distribution
        PoissonArrival pa1 = new PoissonArrival(0.5, 1);
        PoissonArrival pa2 = new PoissonArrival(0.1, 1);
        for(int i = 0; i < 10; i++) {
            log.info("The " + i + "th random number is: " + pa1.nextRandom());
            log.info("The " + i + "th random number is: " + pa2.nextRandom());
        }

    }
}
