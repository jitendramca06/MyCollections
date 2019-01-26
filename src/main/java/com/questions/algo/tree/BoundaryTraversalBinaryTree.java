package com.questions.algo.tree;

/**
 * @author Jitendra Kumar : 28/8/18
 */
public class BoundaryTraversalBinaryTree {
    private static void printBoundary(TreeNode root) {
        if (root != null) System.out.print(root.data + " ");
        printLeft(root.left);
        printLeaf(root);
        printRight(root.right);
    }

    private static void printLeft(TreeNode root) {
       /* if (root == null) return;
        if (root.left == null && root.right == null) return;

        System.out.print(root.data + " ");
        if (root.left == null) {
            printLeaf(root.right);
        } else {
            printLeaf(root.left);
        }*/

        if (root != null) {
            if (root.left != null) {

                // to ensure top down order, print the node
                // before calling itself for left subtree
                System.out.print(root.data + " ");
                printLeft(root.left);
            } else if (root.right != null) {
                System.out.print(root.data + " ");
                printLeft(root.right);
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    private static void printRight(TreeNode root) {
        /*if (root == null) return;
        if (root.left == null && root.right == null) return;
        if (root.right == null) {
            printRight(root.left);
            System.out.print(root.data + " ");
        } else {
            printRight(root.right);
            System.out.print(root.data + " ");
        }*/

        if (root != null) {
            if (root.right != null) {
                // to ensure bottom up order, first call for right
                //  subtree, then print this node
                System.out.print(root.data + " ");
                printRight(root.right);
            } else if (root.left != null) {
                System.out.print(root.data + " ");
                printRight(root.left);
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    private static void printLeaf(TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
            return;
        }
        printLeaf(root.left);
        printLeaf(root.right);
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
        root.left.left.left = new TreeNode(10);
        root.left.left.right = new TreeNode(15);
        root.left.right = new TreeNode(40);
        root.left.right.left = new TreeNode(35);
        root.left.right.right = new TreeNode(45);
        root.right.left = new TreeNode(60);
        root.right.left.left = new TreeNode(55);
        root.right.left.left = new TreeNode(65);
        root.right.right = new TreeNode(80);
        root.right.right.left = new TreeNode(75);
        root.right.right.right = new TreeNode(85);
        printBoundary(root);
    }
}
