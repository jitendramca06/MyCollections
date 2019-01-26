package com.questions.algo.tree;

import java.util.Stack;

/**
 * @author Jitendra Kumar : 3/9/18
 */
public class CheckIfGivenArrayIsPreorder {
    private static boolean isPreOrder(int[] preOrder) {
        if (preOrder == null) return true;
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int i = 0 ; i < preOrder.length ; i++) {
            if (root > preOrder[i]) return false;
            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while (!stack.isEmpty() && stack.peek() < preOrder[i]) {
                root = stack.pop();
            }
            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            stack.push(preOrder[i]);
        }
        return true;
    }

    private static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
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
        preOrder(root);
        System.out.println();
        int[] array = new int[]{50, 30, 20, 40, 70, 60, 80};
        System.out.println(isPreOrder(array));
        int[] array1 = new int[]{50, 30, 100, 40, 70, 60, 80};
        System.out.println(isPreOrder(array1));

    }
}
