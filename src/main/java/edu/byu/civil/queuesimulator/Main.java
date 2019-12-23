package edu.byu.civil.queuesimulator;

import org.apache.log4j.Logger;

public class Main {
    private static Logger log = Logger.getLogger(Main.class);

    private static String myString = "Hello World";

    // When we run the class, this gets executed.
    public static void main(String[] args) {
        log.info("The message to print is `" + myString + "`");
    }
}
