package com.questions.algo.matrix;

/**
 * @author Jitendra Kumar : 30/12/18
 * <p>
 * Find the number of islands
 */
public class FindAPathInAMatrixWithDiagonalMoveAlso {
    // These arrays are used to get row and column
    // numbers of 8 neighbours of a given cell
    int rowNbr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int colNbr[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    // Driver method
    public static void main(String[] args) throws Exception {
        int M[][] = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        int matrix[][] = {
            {0, 0, 1, 1, 0},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1}};
        FindAPathInAMatrixWithDiagonalMoveAlso I = new FindAPathInAMatrixWithDiagonalMoveAlso();
        System.out.println("Number of islands is: " + I.countIslands(M));
        System.out.println("Longest Path: " + I.largestRegion(M));
        System.out.println("Number of islands is: " + I.countIslands(matrix));
        System.out.println("Longest Path: " + I.largestRegion(matrix));
    }

    // A function to check if a given cell (row, col) can
    // be included in DFS
    private boolean isSafe(int matrix[][], int row, int col,
                   boolean visited[][]) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < matrix.length) &&
                (col >= 0) && (col < matrix[0].length) &&
                (matrix[row][col] == 1 && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    private void DFS(int matrix[][], int row, int col, boolean visited[][]) {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(matrix, row + rowNbr[k], col + colNbr[k], visited))
                DFS(matrix, row + rowNbr[k], col + colNbr[k], visited);
    }

    // The main function that returns count of islands in a given
    //  boolean 2D matrix
    private int countIslands(int matrix[][]) {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];


        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int row = 0; row < matrix.length; ++row)
            for (int col = 0; col < matrix[0].length; ++col)
                if (matrix[row][col] == 1 && !visited[row][col]) // If a cell with
                {                                 // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(matrix, row, col, visited);
                    ++count;
                }

        return count;
    }

    private int largestRegion(int matrix[][]) {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        int[] count = new int[1];

        // Initialize result as 0 and travesle through the
        // all cells of given matrix
        int result  = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; ++row)
        {
            for (int col = 0; col < matrix[0].length; ++col)
            {
                // If a cell with value 1 is not
                if (matrix[row][col] == 1 && !visited[row][col])
                {
                    // visited yet, then new region found
                    count[0] = 1 ;
                    dfsForLargestRegion(matrix, row, col, visited , count);

                    // maximum region
                    result = Math.max(result , count[0]);
                }
            }
        }
        return result ;
    }

    private void dfsForLargestRegion(int matrix[][], int row, int col, boolean visited[][], int []count){
        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
        {
            if (isSafe(matrix, row + rowNbr[k], col + colNbr[k],
                    visited))
            {
                // increment region length by one
                count[0]++;
                dfsForLargestRegion(matrix, row + rowNbr[k], col + colNbr[k], visited, count);
            }
        }
    }
}
