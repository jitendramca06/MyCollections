package com.questions.algo.dp;

/**
 * @author Jitendra Kumar : 15/12/18
 *
 * O(n^2)
 */
public class LongestIncreasingSubsequence {
    private static void lSS(int[] array) {
        int[] n = new int[array.length];
        for (int i = 0 ; i < array.length ; i++)
            n[i] =1;

        for (int i = 1 ; i < array.length ; i++) {
            for (int j = 0 ; j < array.length ; j++) {
                if (array[j] < array[i] && n[i] < n[j] + 1) {
                    n[i] = n[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0 ; i < n.length ; i++) {
            if (n[i] > max) max = n[i];
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        int [] array = {10,22,9,33,21,50,41,60};
        lSS(array);
    }
}
