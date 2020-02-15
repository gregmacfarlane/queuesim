package edu.byu.civil.queuesimulator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ServiceCenter {

    private Queue<Customer> queue = new LinkedList<>();
    private HashMap<Integer, Server> serverHashMap = new HashMap<>();

    public ServiceCenter(Integer servers) {
        for(int i = 0; i < servers; i++) {
            serverHashMap.put(i, new Server(i)) ;
        }
    }

    public Event processArrival() {
        Event e = null;

        return e;
    }

    public Event processDeparture() {
        Event e = null;

        return e;
    }

}
