package com.questions.algo.tree;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public class PrintKDistanceNodesFromLeaf {
    private static void utilsMethod(TreeNode node, int k) {
        int[] result = new int[100];
        boolean[] visited = new boolean[100];
        printNodes(node, result, visited, 0, k);
    }

    private static void printNodes(TreeNode root, int[] result, boolean[] visited, int pathLen, int k) {
        if (root == null) return;
        result[pathLen] = root.data;
        visited[pathLen] = false;
        pathLen++;
        if (root.left == null && root.right == null && pathLen - k - 1 >= 0 && !visited[pathLen - k - 1]) {
            System.out.print(result[pathLen - k - 1] + " ");
            visited[pathLen - k - 1] = true;
        }

        printNodes(root.left, result, visited, pathLen, k);
        printNodes(root.right, result, visited, pathLen, k );
    }

    public static void main(String[] args) {
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        utilsMethod(root, 1);
    }
}
