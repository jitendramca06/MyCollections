package com.questions.algo.arrays;

/**
 * @author Jitendra Kumar : 31/1/19
 */
public class BalancePointIndex {
    private static int findIndex(int[] array) {
        int sum = 0;
        int leftSum = 0;
        for (int i = 0 ; i < array.length ; i++) {
            sum = sum + array[i];
        }

        for (int i = 0 ; i < array.length ; i++) {
            sum = sum - array[i];
            if (leftSum == sum) return i;
            leftSum = leftSum + array[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = { 1, 2, 1, 2, 1, 1, 2 };
        System.out.println(findIndex(array));
    }
}
