package edu.byu.civil.queuesimulator;

import org.apache.log4j.Logger;

import java.util.Vector;

/***
 * The future event list is a sorted list of all planned events in the simulation.
 */
public class FutureEventList {
    final static Logger log = Logger.getLogger(FutureEventList.class);

    protected Vector<Event> eventVector;

    public FutureEventList() {
        eventVector = new Vector<>();
    }


    public void addEvent(Event event) {

    }

    /**
     * Get the next event
     * @return the next event in the list.
     */
    public Event nextEvent() {
        Event firstEvent = eventVector.elementAt(0);

        return firstEvent;
    }



}
