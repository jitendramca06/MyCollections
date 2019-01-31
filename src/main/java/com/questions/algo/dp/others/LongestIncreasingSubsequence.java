package com.questions.algo.dp.others;

/**
 * @author Jitendra Kumar : 17/1/19
 *
 * Example:- {3,1,5,2,6,4,9}
 *
 * Answer:- {1,2,4,9}
 */
public class LongestIncreasingSubsequence {
    public static void LIS(int array[]) {
        int[] dp = new int[array.length];
        int[] indexes = new int[array.length];
        for (int i = 0 ; i < array.length ; i++) {
            dp[i] = 1;
            indexes[i] = i;
        }

        for (int i = 1 ; i < array.length ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (array[j] < array[i]) {
                    if (dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        indexes[i] = j;
                    }
                }
            }
        }

        int maxIndex = 0;
        for (int i = 0 ; i < dp.length ; i++) {
            if (dp[i] > dp[maxIndex]) maxIndex = i;
        }

        int oldIndex = maxIndex;
        int newIndex = maxIndex;
        do{
            oldIndex = newIndex;
            System.out.print(array[oldIndex] + " ");
            newIndex = indexes[oldIndex];
        }while(oldIndex != newIndex);

    }

    public static void main(String args[]) {
        int array[] = {3, 1, 5, 0, 6, 4, 9};
        LIS(array);
    }

}
