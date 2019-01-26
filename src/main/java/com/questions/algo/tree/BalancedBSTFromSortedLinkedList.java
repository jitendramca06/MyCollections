package com.questions.algo.tree;

import com.questions.algo.linkedlist.Node;

import java.util.Stack;

/**
 * http://javabypatel.blogspot.com/2017/10/top-binary-tree-interview-questions.html
 *
 * This logic can be used to convert doubly inked list to BST
 * @author Jitendra Kumar : 6/9/18
 */
public class BalancedBSTFromSortedLinkedList {
    static Node head;
    private static int length(Node head) {
        if (head == null) return 0;
        int count = 0;
        while (head != null) {
            count++;
            System.out.println(head.getData() + " ");
            head = head.getNext();
        }
        return count;
    }

    private static TreeNode balancedBST(int length) {
        if (length <= 0) return null;
        TreeNode left = balancedBST(length/2);
        TreeNode root = new TreeNode(head.getData());
        root.left = left;
        head = head.getNext();
        root.right = balancedBST(length - length/2 - 1);
        return root;
    }

    private static void inOrderPrint(TreeNode root) {
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
        // creating first linked list
        head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        Node temp = head;
        TreeNode root = balancedBST(length(temp));
        inOrderPrint(root);
    }
}
