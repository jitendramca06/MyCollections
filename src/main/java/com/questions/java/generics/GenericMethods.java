package com.questions.java.generics;

import java.util.ArrayList;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class GenericMethods {
    // Get the maximum of two objects
    public <T extends Comparable<T>> T max(T x, T y) {
        if (x.compareTo(y) > 0)
            return x;
        else
            return y;
    }
    // Get the minimum of two objects
   public <T extends Comparable<T>> T min(T x, T y) {
        if (y.compareTo(x) > 0)
            return x;
        else
            return y;
    }

    public <T extends Comparable<T>> T max(ArrayList<? extends T> list) {
        T m = list.get(0);
        for (T t : list) {
            if (t.compareTo(m) > 0) {
                m = t;
            }
        }
        return m;
    }

    public <T extends Comparable<T>> T min(ArrayList<? extends T> list) {
        T m = list.get(0);
        for (T t : list) {
            if (m.compareTo(t) > 0) {
                m = t;
            }
        }
        return m;
    }

    public <T> void check(T a, T b) {
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        ArrayList<String> sArray = new ArrayList<>();
        sArray.add("A");
        sArray.add("T");
        sArray.add("B");
        System.out.println(genericMethods.max(3,5));
        System.out.println(genericMethods.min(3,5));
        System.out.println(genericMethods.max(sArray));
        System.out.println(genericMethods.min(sArray));

        ArrayList<Double> dArray = new ArrayList<>();
        dArray.add(0.4);
        dArray.add(0.34);
        dArray.add(0.6);
        System.out.println(genericMethods.max(dArray));
        System.out.println(genericMethods.min(dArray));
        genericMethods.check(12, 14);
    }
}
