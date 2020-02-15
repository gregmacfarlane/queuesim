package edu.byu.civil.queuesimulator;

import org.apache.log4j.Logger;

public class Customer {
    private static final Logger log = Logger.getLogger(Customer.class);

    double jobLength;
    private static int nextID = 1;
    private int customerID;

    public Customer(double jobLength){
        this.customerID = nextID;
        nextID++;

        this.jobLength = jobLength;
        log.info("Customer " + customerID + " created with job length " + jobLength);
    }
}

