package com.questions.algo.arrays;

import java.util.*;

/**
 * @author Jitendra Kumar : 30/5/19
 */
public class ArrayManipulation {
    private static List<Integer> arrays = new ArrayList<>();
    private static Map<Integer, Integer> indexMap = new HashMap<>();

    public static void add(int data) {
        if(indexMap.containsKey(data)) return;

        int size = arrays.size();
        arrays.add(data);
        indexMap.put(data, size);
    }

    /**
     *
     *This method will help to remove data in O(1) time
     */
    public static int remove(int data) {
        if (!indexMap.containsKey(data)) return -1;
        int indexOfData = indexMap.get(data);
        int lastIndex = arrays.size() - 1;
        arrays.set(indexOfData, arrays.set(lastIndex, arrays.get(indexOfData)));
        int lastData = arrays.get(lastIndex);
        indexMap.put(lastData, indexOfData);
        arrays.remove(lastIndex);
        indexMap.remove(data);
        return indexOfData;
    }

    /**
     *
     * Will check given data is available in array or not
     */
    public static int search(int data) {
        if (indexMap.containsKey(data)) return indexMap.get(data);
        return -1;
    }

    public static void main(String[] args) {
        ArrayManipulation.add(12);
        ArrayManipulation.add(1);
        ArrayManipulation.add(5);
        ArrayManipulation.add(13);
        ArrayManipulation.add(8);
        ArrayManipulation.add(41);
        ArrayManipulation.add(22);
        ArrayManipulation.add(87);
        System.out.println();
        ArrayManipulation.remove(8);
        System.out.println();
    }
}
