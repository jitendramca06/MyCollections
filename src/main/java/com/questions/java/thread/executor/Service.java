package com.questions.java.thread.executor;

/**
 * Created by jitendra on 08 Mar, 2018
 */
public class Service {
    private String serviceName;

    public Service(String serviceName) {
        this.serviceName = serviceName;
    }

    public void sendHeartbeat() {
        System.out.println("Service " + serviceName + ", hearbeat at "
                + System.currentTimeMillis());
    }

    public String toString() {
        return "Service " + serviceName;
    }
}
