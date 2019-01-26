package com.questions.java.comparablecomparator;

/**
 * @author Jitendra Kumar : 31/8/18
 */
public class Car implements Comparable<Car>{
    private String name;
    private double price;

    @Override
    public int compareTo(Car o) {
        if (price > o.price) return 1;
        else if (price < o.price) return -1;
        else return 0;
    }
}
