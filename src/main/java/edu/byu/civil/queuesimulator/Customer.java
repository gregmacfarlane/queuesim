package edu.byu.civil.queuesimulator;

import org.apache.log4j.Logger;

public class Customer {
    private static final Logger log = Logger.getLogger(Customer.class);

    double jobLength;
    private static int nextID = 1;
    private int customerID;
    private int serverId;

    private double arrivalTime;
    private double queuedTime;

    public Customer(double jobLength){
        this.customerID = nextID;
        nextID++;

        this.jobLength = jobLength;
        log.info("Customer " + customerID + " created with job length " + jobLength);
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getJobLength() {
        return jobLength;
    }

    public int getCustomerID() {
       return customerID;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public int getServerId() {
        return serverId;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setQueuedTime(double queuedTime) {
        this.queuedTime = queuedTime;
    }

    public double getQueuedTime() {
        return queuedTime;
    }
}

