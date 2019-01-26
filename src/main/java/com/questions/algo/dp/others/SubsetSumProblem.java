package com.questions.algo.dp.others;

/**
 * @author Jitendra Kumar : 15/12/18
 */
public class SubsetSumProblem {

    private static boolean isSubset(int[] set, int sum) {
        boolean[][] matrix = new boolean[set.length + 1][sum + 1];
        for (int i = 0 ; i <= sum ; i++)
            matrix[0][i] = false;
        for (int j = 0 ; j <= set.length ; j++)
            matrix[j][0] = true;
        for (int i = 1 ; i <= set.length ; i++) {
            for (int j = 1 ; j <= sum ; j++) {
                matrix[i][j] = matrix[i-1][j];
                if (j >= set[i- 1]) {
                    matrix[i][j] = matrix[i][j] || matrix[i - 1][j - set[i - 1]];
                }
            }
        }
        return matrix[set.length][sum];
    }

    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(isSubset(set, sum));
    }
}
