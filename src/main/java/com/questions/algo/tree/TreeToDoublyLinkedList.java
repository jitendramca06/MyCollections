package com.questions.algo.tree;

/**
 * @author Jitendra Kumar : 31/12/18
 */
public class TreeToDoublyLinkedList {
    private static TreeNode head;
    private static void treeToDoublyLinkedList(TreeNode root) {
        if (root == null) return;

        treeToDoublyLinkedList(root.right);
        root.right = head;
        if (head != null)
            head.left = root;
        head = root;
        treeToDoublyLinkedList(root.left);
    }

    private static void print(TreeNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    public static void main(String[] args) {
        /* Constructing below tree
               5
             /   \
            3     6
           / \     \
          1   4     8
         / \       / \
        0   2     7   9  */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.left.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(0);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        treeToDoublyLinkedList(root);
        print(head);
    }
}
