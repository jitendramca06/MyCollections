package com.questions.algo.matrix;

import java.util.ArrayList;

/**
 * @author Jitendra Kumar : 30/12/18
 */
public class FindAPathInAMatrix {
    public static void main(String[] args) {
        int[][] matrix = {/*{1, 0, 0, 0, 0},*/
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1}};
        int[][] result = findPath(matrix);

        for (int i = 0 ; i< result.length ; i++) {
            for (int j = 0 ; j < result[0].length ; j++) {
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int[][] findPath(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        int[][] result = new int[rowSize][colSize];

        ArrayList<int[]> temp = new ArrayList<int[]>();
        ArrayList<int[]> list = new ArrayList<int[]>();

        dfs(matrix, 0, 0, temp, list);


        for (int i = 0; i < list.size(); i++) {
            result[list.get(i)[0]][list.get(i)[1]] = 1;
        }

        result[0][0] = 1;

        return result;
    }

    public static void dfs(int[][] matrix, int row, int col,
                    ArrayList<int[]> temp, ArrayList<int[]> list) {

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        if (row == rowSize - 1 && col == colSize - 1) {
            list.addAll(temp);
            return;
        }

        /*
                               |
                               |(0,1)
                               |
                               |
        ------------(-1,0)---------------(1,0)-------------------------
                               |
                                |(0,-1)



         */
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int x = row + dx[k];
            int y = col + dy[k];

            if (x >= 0 && y >= 0 && x < rowSize && y < colSize && matrix[x][y] == 1) {
                temp.add(new int[]{x, y});
                int prev = matrix[x][y];
                matrix[x][y] = 0;

                dfs(matrix, x, y, temp, list);

                matrix[x][y] = prev;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
