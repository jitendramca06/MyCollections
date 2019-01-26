package com.questions.algo.matrix;

/**
 * @author Jitendra Kumar : 30/12/18
 */
public class FindLongestPossibleRouteInAMatrix {
    // check if it is possible to go to position (x, y) from
    // current position. The function returns false if the cell
    // has value 0 or it is already visited.
    private static boolean isSafe(int mat[][], int visited[][], int row, int col) {
        if (mat[row][col] == 0 || visited[row][col] != 0)
            return false;

        return true;
    }

    // if not a valid position, return false
    private static boolean isValid(int mat[][], int row, int col) {
        if (row < mat.length && col < mat[0].length && row >= 0 && col >= 0)
            return true;

        return false;
    }

    // Find Longest Possible Route in a Matrix mat from source
    // cell (0, 0) to destination cell (x, y)
    // 'max_dist' stores length of longest path from source to
    // destination found so far and 'dist' maintains length of path from
    // source cell to the current cell (i, j)
    public static int findLongestPath(int mat[][], int visited[][], int row,
                                      int col, int targetRow, int targetCol, int max_dist, int dist) {
        // if destination is found, update max_dist
        if (row == targetRow && col == targetCol) {
            return Integer.max(dist, max_dist);
        }

        // set (i, j) cell as visited
        visited[row][col] = 1;

        // go to bottom cell
        if (isValid(mat, row + 1, col) && isSafe(mat, visited, row + 1, col)) {
            max_dist = findLongestPath(mat, visited, row + 1, col, targetRow, targetCol,
                    max_dist, dist + 1);
        }

        // go to right cell
        if (isValid(mat, row, col + 1) && isSafe(mat, visited, row, col + 1)) {
            max_dist = findLongestPath(mat, visited, row, col + 1, targetRow, targetCol,
                    max_dist, dist + 1);
        }

        // go to top cell
        if (isValid(mat, row - 1, col) && isSafe(mat, visited, row - 1, col)) {
            max_dist = findLongestPath(mat, visited, row - 1, col, targetRow, targetCol,
                    max_dist, dist + 1);
        }

        // go to left cell
        if (isValid(mat, row, col - 1) && isSafe(mat, visited, row, col - 1)) {
            max_dist = findLongestPath(mat, visited, row, col - 1, targetRow, targetCol,
                    max_dist, dist + 1);
        }

        // Backtrack - Remove (i, j) from visited matrix
        visited[row][col] = 0;

        return max_dist;
    }

    public static void main(String[] args) {
        // input matrix
        int mat[][] =
                {
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
                        {1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 0, 1, 1},
                        {1, 1, 0, 0, 1, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0}
                };

        // construct a matrix to keep track of visited cells
        int[][] visited = new int[mat.length][mat[0].length];

        int max_dist = findLongestPath(mat, visited, 0, 0, 5, 7, 0, 0);

        System.out.println("Maximum length path is " + max_dist);
    }
}
