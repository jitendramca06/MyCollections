package com.questions.algo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jitendra Kumar : 3/2/19
 */
public class ListAMinusListB {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(7);
        list2.add(8);
        list2.add(9);
        list1.removeAll(list2);
        System.out.println(list1);
    }
}
