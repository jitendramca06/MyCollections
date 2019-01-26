package com.questions.java.concurrentmap;

import java.util.Map;

/**
 * Created by jitendra on 14 Mar, 2018
 */
public class MapHelper implements Runnable {
    Map<String, Integer> map;
    String name;

    public MapHelper(Map<String, Integer> map, String name) {
        this.name = name;
        this.map = map;
        new Thread(this, name).start();
    }

    public void run() {
        map.put(name, 1);
        try {
            System.out.println(name + " sleeping");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
