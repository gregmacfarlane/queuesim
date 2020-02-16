package edu.byu.civil.queuesimulator;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ServiceCenter {
    private final static Logger log = Logger.getLogger(ServiceCenter.class);

    private Queue<Customer> queue = new LinkedList<>();
    private HashMap<Integer, Server> serverHashMap = new HashMap<>();

    public ServiceCenter(Integer servers) {
        for(int i = 0; i < servers; i++) {
            serverHashMap.put(i, new Server(i)) ;
        }
    }

    public Event processArrival(Customer customer, double time) {
        Event e = null;
        boolean served = false;

        // check servers to see if they are engaged
        for(Server s : serverHashMap.values()) {
            if(!s.isServing()) {
                s.engage();
                served = true;
                e = new Event(Event.DEPARTURE, time + customer.getJobLength());
                log.info("Customer " + customer.getCustomerID() + " handled by server " +
                        s.getServerId());
                break;
            }
        }

        if(!served) {
            addToQueue(customer);
        }
        return e;
    }

    private void addToQueue(Customer customer) {
        log.info("Customer " + customer.getCustomerID() + " added to queue");
        queue.add(customer);
    }

    public Event processDeparture() {
        Event e = null;

        return e;
    }

}
