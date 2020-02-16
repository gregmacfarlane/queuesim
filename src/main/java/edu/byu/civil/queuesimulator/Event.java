package edu.byu.civil.queuesimulator;


import org.apache.log4j.Logger;

public class Event {
    private static final Logger log = Logger.getLogger(Event.class);

    public static final int ARRIVAL = 1;
    public static final int DEPARTURE = 2;

    protected int type;
    protected double time;
    protected Customer customer;

    public Event(int type, double time) {
        this.type = type;
        this.time = time;

        String etype = "Arrival";
        if (type == DEPARTURE) etype = "Departure";

        log.trace(etype + " event created" + " at time " + time);
    }

    public int getType() {
        return type;
    }

    public double getTime() {
        return time;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
