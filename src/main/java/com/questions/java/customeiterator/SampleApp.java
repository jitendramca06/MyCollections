package com.questions.java.customeiterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Jitendra Kumar : 23/2/19
 */
public class SampleApp {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        map.put(8, 8);
        map.put(9, 9);
        map.put(10, 10);
        map.put(11, 11);
        Iterator<Integer> integerIterator = map.keySet().iterator();
        SkipEverySecondElement<Integer> skipEverySecondElement = new SkipEverySecondElement<>(integerIterator, map.size(), 0);

        while (skipEverySecondElement.hasNext()) {
            Integer val = skipEverySecondElement.next();
            if (val != null) System.out.println(val);
        }
    }
}
