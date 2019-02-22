package com.questions.algo.arrays;

/**
 * @author Jitendra Kumar : 7/2/19
 *
 * O(nlong n),O(1)
 */
public class MaxMinProductInAArray {
    private static void maxMinProductPair(int[] arr) {
        MyQuickSort.sort(arr);
        int a = arr[0]*arr[1];
        int b = arr[arr.length-1]*arr[arr.length -2];
        if (a > b) {
            System.out.println("Max product-" + a + " numbers-{" + arr[0] + "," + arr[1] + "}");
            //TODO-may be incorrect value for min
            System.out.println("Min product-" + a + " numbers-{" + arr[arr.length-1] + "," + arr[arr.length-2] + "}");
        } else {
            System.out.println("Max product-" + a + " numbers-{" + arr[arr.length-1] + "," + arr[arr.length-2] + "}");
            //TODO-may be incorrect value for min
            System.out.println("Min product-" + a + " numbers-{" + arr[0] + "," + arr[1] + "}");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 6, 7, -10,-11,-12};
        maxMinProductPair(arr);
    }
}
