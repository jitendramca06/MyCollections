package com.questions.java.comparablecomparator;

import java.util.List;

/**
 * @author Jitendra Kumar : 31/8/18
 */
public class FourWheeler implements Comparable<FourWheeler>{
    private String name;
    private double price;
    private List<Car> carList;

    @Override
    public int compareTo(FourWheeler o) {
        return 0;
    }
}
