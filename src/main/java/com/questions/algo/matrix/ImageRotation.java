package com.questions.algo.matrix;

/**
 * @author Jitendra Kumar : 31/8/18
 */
public class ImageRotation {
    private static void imageRotation(int[][] matrix) {
        int size = matrix.length - 1;
        int row = 0;
        while (row < matrix.length/2) {
            for (int column = row ; column < size - row ; column++) {
                int temp = matrix[row][column];
                matrix[row][column] = matrix[size-column][row];
                matrix[size-column][row] = matrix[size-row][size-column];
                matrix[size-row][size-column] = matrix[column][size-row];
                matrix[column][size-row] = temp;
            }
            row++;
        }

        for (int i = 0 ; i < matrix.length ; i++) {
            for (int t = 0 ; t < matrix[0].length ; t++) {
                System.out.print(matrix[i][t] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {2, 4, 5, 7, 5},
                {4, 2, 6, 9, 0},
                {0, 8, 8, 3, 7},
                {0, 1, 0, 2, 1}
        };
        imageRotation(matrix);
    }
}
