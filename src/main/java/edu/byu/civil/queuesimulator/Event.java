package edu.byu.civil.queuesimulator;


import org.apache.log4j.Logger;

public class Event {
    private static final Logger log = Logger.getLogger(Event.class);

    public static final int ARRIVAL = 1;
    public static final int DEPARTURE = 2;

    protected int type;
    protected double time;
    protected int customerId;

    public Event(int type, double time) {
        this.type = type;
        this.time = time;

        String etype = "Arrival";
        if (type == DEPARTURE) etype = "Departure";

        log.info(etype + " event created" + " at time " + time);
    }

    public int getType() {
        return type;
    }

    public double getTime() {
        return time;
    }
}
