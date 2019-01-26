package com.questions.java.concurrentmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jitendra on 14 Mar, 2018
 */
public class SimpleMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> syncMap = Collections.synchronizedMap(hashMap);
        MapHelper mapHelper1 = new MapHelper(syncMap, "mapHelper1");
        MapHelper mapHelper2 = new MapHelper(syncMap, "mapHelper2");
        MapHelper mapHelper3 = new MapHelper(syncMap, "mapHelper3");
        MapHelper mapHelper4 = new MapHelper(syncMap, "mapHelper4");
        MapHelper mapHelper5 = new MapHelper(syncMap, "mapHelper5");
        MapHelper mapHelper6 = new MapHelper(syncMap, "mapHelper6");
        MapHelper mapHelper7 = new MapHelper(syncMap, "mapHelper7");
        MapHelper mapHelper8 = new MapHelper(syncMap, "mapHelper8");

        for (Map.Entry<String, Integer> e : syncMap.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }
}
