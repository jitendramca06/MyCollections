package com.questions.algo.tree;

/**
 * @author Jitendra Kumar : 15/12/18
 */
public class LeftView {
    private static int maxLvel = 0;
    private static void printLeft(TreeNode root, int level) {
        if (root == null) return;
        if (maxLvel < level) {
            System.out.print(root.data + " ");
            maxLvel = level;
        }
        printLeft(root.left, level +  1);
        printLeft(root.right, level + 1);
    }

    public static void main(String[] args) {
        /* Let us create following BST
              50
           /    \
          30     17
         /  \   /  \
       20   40 18   19
       /     \        \
      12      13       20
               \
                14
                 \
                  15
                   \
                    16*/
        TreeNode root1 = new TreeNode(50);
        root1.left = new TreeNode(30);
        root1.left.left = new TreeNode(20);
        root1.left.left.left = new TreeNode(12);
        root1.left.right = new TreeNode(40);
        root1.left.right.right = new TreeNode(13);
        root1.left.right.right.right = new TreeNode(14);
        root1.left.right.right.right.right = new TreeNode(15);
        root1.left.right.right.right.right.right = new TreeNode(16);
        root1.right = new TreeNode(17);
        root1.right.left = new TreeNode(18);
        root1.right.right = new TreeNode(19);
        root1.right.right.right = new TreeNode(20);
        printLeft(root1, 1);
    }
}
