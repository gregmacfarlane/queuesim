package edu.byu.civil.queuesimulator;

import org.apache.log4j.Logger;

public class Main {
    private static Logger log = Logger.getLogger(Main.class);

    private static String myString = "Hello World";

    // When we run the class, this gets executed.
    public static void main(String[] args) {

        // Create a new random arrival distribution
        PoissonArrival pa1 = new PoissonArrival(1, 1);
        log.info("The next random number is: " + pa1.nextRandom());

    }
}
