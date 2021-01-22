package com.questions.algo.gfg.amazon;

/**
 * @author Jitendra Kumar : 11/12/19
 */
public class BooleanMatrix {

    private static void print(int[][] matrix) {
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                System.out.print(matrix[i][j] + "     ");
            }
            System.out.print("\n");
        }
    }

    private static void finalMatrix(int[][] matrix) {
        boolean fRow = false;
        boolean fCol = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && matrix[i][j] == 1) fRow = true;
                if (j == 0 && matrix[i][j] == 1) fCol = true;
                if (matrix[i][j] == 1) {
                    matrix[0][j] = 1;
                    matrix[i][0] = 1;
                }
            }
        }

        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                if (matrix[0][j] == 1 || matrix[i][0] == 1) matrix[i][j] = 1;
            }
        }

        if (fRow) {
            for (int j = 0 ; j < matrix[0].length ; j++) matrix[0][j] = 1;
        }

        if (fCol) {
            for (int i = 0 ; i < matrix.length ; i++) matrix[i][0] = 1;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        print(matrix);
        finalMatrix(matrix);
        System.out.println("=========Result===============");
        print(matrix);
    }
}
