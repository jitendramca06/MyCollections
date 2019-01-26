package com.questions.algo.tree;

import java.util.Stack;

/**
 * @author Jitendra Kumar : 3/9/18
 */
public class ConstructTreeWithInAndPostOrder {
    private static TreeNode constructTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (postStart > postEnd) return null;
        TreeNode node = new TreeNode(postOrder[postEnd]);

        int index = 0;
        for (int i = inStart ; i <= inEnd ; i++) {
            if (node.data == inOrder[i]) {
                index = i;
                break;
            }
        }

        int count = index - inStart;

        node.left = constructTree(inOrder, inStart , index - 1, postOrder, postStart, postStart + count - 1);
        node.right = constructTree(inOrder, index +1, inEnd, postOrder, postStart + count, postEnd -1);
        return node;
    }

    private static void printInorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
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

    private static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
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
        System.out.println();
        printInorder(root);
        System.out.println();
        postOrder(root);
        int[] inOrder = new int[] {20, 30, 40, 50, 60, 70, 80};
        int[] postOrder = {20, 40, 30, 60, 80, 70, 50};
        TreeNode head = constructTree(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1);
        System.out.println();
        printInorder(head);
        postOrder(head);
    }
}
