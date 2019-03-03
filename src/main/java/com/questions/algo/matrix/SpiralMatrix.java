package com.questions.algo.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jitendra Kumar : 2/3/19
 */
public class SpiralMatrix {
    private static List<Integer> spiral(int[][] matrix, int currRow, int currCol, int row, int col) {
        List<Integer> output = new ArrayList<>();
        if (row <= 0 || col<= 0) return output;
        if (row == 1 && col == 1) {
            output.add(matrix[currRow][currCol]);
            return output;
        }

        //Move top from left to right
        for (int i = 0 ; i< col -1 ;i++) {
            output.add(matrix[currRow][currCol++]);
        }

        //Move right from top to down
        for (int j = 0 ; j < row -1 ; j++) {
            output.add(matrix[currRow++][currCol]);
        }

        //Move bottom from right to left
        if (col > 1) {
            for (int i = 0 ; i < col -1 ; i++) {
                output.add(matrix[currRow][currCol--]);
            }
        }

        //Move left from bottom to top
        if (row > 1) {
            for (int j = 0 ; j < row -1 ; j++) {
                output.add(matrix[currRow--][currCol]);
            }
        }

        if (row == 1 || col ==1) output.addAll(spiral(matrix, currRow, currCol, 1, 1));
        else output.addAll(spiral(matrix, currRow + 1, currCol + 1, row - 2, col - 2));
        return output;
    }

    public static void main(String[] args) {
        int[][] matric = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
                {21, 22, 23, 24}
        };
        System.out.println(spiral(matric, 0, 0, matric.length, matric[0].length));
    }
}
