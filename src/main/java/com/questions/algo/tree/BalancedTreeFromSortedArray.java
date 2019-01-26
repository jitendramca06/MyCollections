package com.questions.algo.tree;

import java.util.Stack;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public class BalancedTreeFromSortedArray {
    private static TreeNode balanceTree(int[] array, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = balanceTree(array, start, mid -1);
        root.right = balanceTree(array, mid + 1, end);
        return root;
    }

    private static void printInorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = balanceTree(array, 0, array.length - 1);
        printInorder(root);
    }
}
