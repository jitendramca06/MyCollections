package com.questions.java.thread.executor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jitendra on 08 Mar, 2018
 */
public class HeartbeatTask implements Runnable{
    private List<Service> services = new ArrayList<Service>();

    public void addService(Service service) {
        services.add(service);
    }

    public void run() {
        try {
            for (Service service : services) {
                service.sendHeartbeat();
            }
        } catch (Exception e) {
        }
    }

    void shutdown() {
        for (final Service service : services) {
            System.out.println("Shutting down service " + service);
        }
    }
}
