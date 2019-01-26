package com.questions.algo.linkedlist;

/**
 * @author Jitendra Kumar : 21/9/18
 */
public class ReverseTheLinkedList {
    public static Node reverse(Node root) {
        if (root == null) return root;

        Node prev = null;
        Node next = null;
        Node current = root;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        root = prev;
        return root;
    }

    public static void print(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.next;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Node temp = root;
        print(temp);
        System.out.println();
        Node temp1 = reverse(root);
        print(temp1);
    }
}
