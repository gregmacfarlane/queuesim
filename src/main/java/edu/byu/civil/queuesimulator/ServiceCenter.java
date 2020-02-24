package edu.byu.civil.queuesimulator;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ServiceCenter {
    private final static Logger log = Logger.getLogger(ServiceCenter.class);

    private Queue<Customer> queue = new LinkedList<>();
    private HashMap<Integer, Server> serverHashMap = new HashMap<>();

    private int maxQueueLength = 0;
    private int customersServed = 0;
    private int customersArrived = 0;
    private int customersQueued = 0;
    private double totalTimeInSytem = 0;
    private double totalQueueTime = 0;

    public ServiceCenter(Integer servers) {
        for(int i = 0; i < servers; i++) {
            serverHashMap.put(i, new Server(i)) ;
        }
    }

    public Event processArrival(Customer customer, double time) {
        customersArrived++;
        Event e = null;
        boolean served = false;
        customer.setArrivalTime(time);

        // check servers to see if they are engaged
        for(Server s : serverHashMap.values()) {
            if(!s.isServing()) {
                log.info("Customer " + customer.getCustomerID() + " handled by server " +
                        s.getServerId());
                s.engage();
                served = true;
                e = new Event(Event.DEPARTURE, time + customer.getJobLength());
                customer.setServerId(s.getServerId());
                e.setCustomer(customer);
                break;
            }
        }

        if(!served) {
            addToQueue(customer, time);
        }
        return e;
    }

    private void addToQueue(Customer customer, double time) {
        log.info("Customer " + customer.getCustomerID() + " added to queue");
        customer.setQueuedTime(time);
        queue.add(customer);
        log.info("Queue length: " + queue.size());
        customersQueued++;
        if(queue.size() > maxQueueLength) maxQueueLength = queue.size();
    }

    public Event processDeparture(Event e, double time) {
        Customer customer = e.getCustomer();

        log.info("Customer " + customer.getCustomerID() + " departs server " + customer.getServerId() + " at " + time);
        Server s = serverHashMap.get(customer.getServerId());
        s.release();

        // update stats
        customersServed++;
        totalTimeInSytem = totalTimeInSytem + (time - customer.getArrivalTime());


        // check to see if there is a customer waiting in the queue
        Event nextDeparture = null;
        if(queue.size() != 0) {
            Customer nextCustomer = queue.poll();
            totalQueueTime = totalQueueTime + (time - nextCustomer.getQueuedTime());
            s.engage();
            nextDeparture = new Event(Event.DEPARTURE, time + nextCustomer.getJobLength());
            nextDeparture.setCustomer(nextCustomer);
        }

        return nextDeparture;
    }

    public int getMaxQueueLength() {
        return maxQueueLength;
    }

    public double getAverageSystemTime() {
       return totalTimeInSytem / customersServed;
    }

    public double getAverageQueueTime() {
        return totalQueueTime / customersQueued;
    }

    public int getCustomersArrived() {
        return customersArrived;
    }

    public int getCustomersQueued() {
        return customersQueued;
    }

    public int getCustomersServed() {
        return customersServed;
    }
}
