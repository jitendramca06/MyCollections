package com.questions.java.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class MyMapTest {
    public static void main(String[] args) {
        // Standard Map
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Lars", 1);
        map.put("Lars", 2);
        map.put("Lars", 1);
        System.out.println(map.get("Lars"));

        MyMap<Integer, Integer> hashMapCustom = new MyMap<Integer, Integer>();
        hashMapCustom.put(21, 12);
        hashMapCustom.put(25, 121);
        hashMapCustom.put(30, 151);
        hashMapCustom.put(33, 15);
        hashMapCustom.put(35, 89);

        System.out.println("value corresponding to key 21="
                + hashMapCustom.get(21));
        System.out.println("value corresponding to key 51="
                + hashMapCustom.get(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();

        System.out.println("\n\nvalue corresponding to key 21 removed: "
                + hashMapCustom.remove(21));
        System.out.println("value corresponding to key 51 removed: "
                + hashMapCustom.remove(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();
    }
}
