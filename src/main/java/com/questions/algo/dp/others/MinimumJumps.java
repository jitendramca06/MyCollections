package com.questions.algo.dp.others;

/**
 * @author Jitendra Kumar : 17/1/19
 */
public class MinimumJumps {
    //Minimum Jumps to reach the end of array
    private static int minJump(int[] array, int[] result) {
        int[] dp = new int[array.length];
        for (int i = 1 ; i < array.length ; i++) dp[i] = 9999999;
        for (int i = 1 ; i < array.length ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (i <= j + array[j]) {
                    if (dp[j] +1 < dp[i]) {
                        dp[i] = dp[j] +1;
                        result[i] = j;
                    }
                }
            }
        }

        int index = 0;
        while (index <array.length) {
            System.out.print(array[index] + " ");
            index++;
        }
        System.out.println();
        return dp[array.length-1];
    }
    public static void main(String[] args) {
        int array[] = {1,3,5,3,2,2,6,1,6,8,9};
        int[] result = new int[array.length];
        System.out.println(minJump(array, result));
        System.out.println(result);
    }
}
