package com.questions.algo.matrix;

/**
 * @author Jitendra Kumar : 12/3/19
 */
public class FindTheFirstTargetInIncreasingMatrix {

    private static int[] findTarget(int[][] matrix, int target) {
        int[] result = new int[2];
        if (matrix[0][0] == target) {
            return result;
        }
        int row = 0;
        while (row < matrix .length) {
            /**
             * Check first cell of a row for a given target
             */
            if (matrix[row][0] == target) {
                result[0] = row;
                return result;
            }
            /**
             * Check last cell of a row for a given target
             */
            if (matrix[row][matrix[0].length-1] == target) {
                result[0] = row;
                result[1] = matrix[0].length-1;
                return result;
            }
            /**
             * If target if grater than the first cell of a row and less than the last cell of same row then
             * we have to traversal the same row to check the given target
             */
            if (matrix[row][0] < target && matrix[row][matrix[0].length-1] > target) {
                for (int i = 0 ; i < matrix[1].length ; i++) {
                    if (matrix[row][i] == target) {
                        result[0] = row;
                        result[1] = i;
                        return result;
                    }
                }
            }
            row++;
        }
        return null;
    }

    public static void main(String[] args) {
        /**
         * Row - In increasing order
         * Col - In increasing order
         * Note- Number can be repeated
         */
        int[][] matrix = {
                {1,2,3},
                {2,3,3},
                {4,4,5}};
        int[] result = findTarget(matrix, 5);
        if (result != null)
            System.out.println("Row-"+result[0] + ",Col-"+result[1]);
        System.out.println("Target is not available..");
    }
}
