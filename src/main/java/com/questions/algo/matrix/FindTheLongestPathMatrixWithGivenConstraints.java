package com.questions.algo.matrix;

/**
 * @author Jitendra Kumar : 15/12/18
 *
 * Time complexity of the above solution is O(n2).
 */
public class FindTheLongestPathMatrixWithGivenConstraints {

    private static int longestPath(int[][] matrix, int[][] dp, int row, int col) {
        if (row < 0 || row > matrix.length || col < 0 || col > matrix[0].length)
            return 0;
        if (dp[row][col] != -1) return dp[row][col];

        if (row > 0 && matrix[row][col] + 1 == matrix[row - 1][col])
            return dp[row][col] = 1 + longestPath(matrix, dp, row - 1, col);
        if (row < matrix.length - 1 && matrix[row][col] +1 == matrix[row + 1][col])
            return dp[row][col] = 1 + longestPath(matrix, dp, row + 1, col);
        if (col > 0 && matrix[row][col] + 1 == matrix[row][col  - 1])
            return dp[row][col] = 1 + longestPath(matrix, dp, row, col - 1);
        if (col > matrix.length -1 && matrix[row][col] + 1 == matrix[row][col + 1])
            return dp[row][col] = 1 + longestPath(matrix, dp, row, col + 1);
        return dp[row][col] = 1;
    }

    private static int longestPath(int[][] matrix) {
        int result = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix.length ; j++) {
                if (dp[i][j] == -1)
                    longestPath(matrix, dp, i, j);
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int mat[][] = { {1, 2, 9},
                        {5, 3, 8},
                        {4, 6, 7}};
        System.out.println(longestPath(mat));
    }
}

/*
Given a n*n matrix where all numbers are distinct, find the maximum length path (starting from any cell) such that all cells along the path are in increasing order with a difference of 1.

We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the condition that the adjacent cells have a difference of 1.

Example:

Input:  mat[][] = {{1, 2, 9}
                   {5, 3, 8}
                   {4, 6, 7}}
Output: 4
The longest path is 6-7-8-9.
 */
