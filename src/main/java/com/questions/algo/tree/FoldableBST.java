package com.questions.algo.tree;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public class FoldableBST {
    private static boolean checkFoldable(TreeNode root) {
        if (root == null) return true;
        return isFoldable(root.left, root.right);
    }

    private static boolean isFoldable(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null &&  rightTree == null) return true;
        if (leftTree == null || rightTree == null) return false;
        boolean leftT = isFoldable(leftTree.left, rightTree.right);
        boolean rightT = isFoldable(leftTree.right, rightTree.left);
        return leftT && rightT;
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
        System.out.println(checkFoldable(root));
        root.right.right.right = new TreeNode(100);
        System.out.println(checkFoldable(root));
    }
}
