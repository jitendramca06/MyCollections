package com.questions.algo.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Jitendra Kumar : 3/12/18
 */
public class AllNodesWithoutSiblings {
    private static void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root !=null || !stack.isEmpty()) {
            while (root !=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    private static void nodeWithoutSiblings(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null && current.right == null) {
                System.out.print(current.left.data + " ");
                queue.add(current.left);
            }else if (current.right != null && current.left == null) {
                System.out.print(current.right.data + " ");
                queue.add(current.right);
            } else if (current.left != null && current.right != null) {
                queue.add(current.left);
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        /* Let us create following BST
              50
           /
          30
         /  \
       20   40
       /
      10             */
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        //root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        //root.right.left = new TreeNode(60);
        //root.right.right = new TreeNode(80);
        //root.right.right.right = new TreeNode(100);
        root.left.left.left = new TreeNode(10);
        inorder(root);
        System.out.println();
        nodeWithoutSiblings(root);
    }
}
