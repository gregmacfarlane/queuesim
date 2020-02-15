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

    /**
     * Add a new event to the proper place in the vector
     * @param event
     */
    public void addEvent(Event event) {
        int insertIndex = 0;

        // Find the right place to add the event
        while(insertIndex < eventVector.size()) {
            Event e = eventVector.elementAt(insertIndex);
            if (e.getTime() > event.getTime()) break;
            insertIndex++;
        }
        eventVector.insertElementAt(event, insertIndex);
    }

    /**
     * Get the next event
     * @return the next event in the list.
     */
    public Event nextEvent() {
        Event firstEvent = eventVector.elementAt(0);
        eventVector.remove(0);
        return firstEvent;
    }



}
