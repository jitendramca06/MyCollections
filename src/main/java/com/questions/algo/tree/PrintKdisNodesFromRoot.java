package com.questions.algo.tree;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public class PrintKdisNodesFromRoot {
    private static void printKDisNodes(TreeNode root, int dis) {
        if (root == null) return;
        if (dis == 0) {
            System.out.print(root.data + " ");
            return;
        }
        printKDisNodes(root.left, dis - 1);
        printKDisNodes(root.right, dis - 1);
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
        printKDisNodes(root, 2);
    }
}
