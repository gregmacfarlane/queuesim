package edu.byu.civil.queuesimulator;

public class Server {
    boolean serving = false;
    int id;
    
    public Server(int i) {
        id = i;
    }
    
    public void engage() {
        serving = true;
    }
    
    public void release() {
        serving = false;
    }

    public boolean isServing() {
        return serving;
    }

    public int getServerId() {
        return id;
    }
}
