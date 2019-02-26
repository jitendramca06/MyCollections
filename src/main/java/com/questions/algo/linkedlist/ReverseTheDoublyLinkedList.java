package com.questions.algo.linkedlist;

/**
 * @author Jitendra Kumar : 25/2/19
 */
public class ReverseTheDoublyLinkedList {
    private static DoublyNode reverse(DoublyNode head) {
        DoublyNode temp = null;
        DoublyNode current = head;

        while (current != null) {
            temp = current.previous;
            current.previous = current.next;
            current.next = temp;
            current = current.previous;
        }

        if (temp != null) head = temp.previous;
        return head;
    }

    private static void print(DoublyNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        DoublyNode head = new DoublyNode(1);
        DoublyNode node1 = new DoublyNode(2);
        DoublyNode node2 = new DoublyNode(3);
        DoublyNode node3 = new DoublyNode(4);
        DoublyNode node4 = new DoublyNode(5);

        head.next= node1;
        node1.previous = head;

        node1.next = node2;
        node2.previous = node1;

        node2.next = node3;
        node3.previous = node2;

        node3.next = node4;
        node4.previous = node3;
        print(head);
        System.out.println();
        print(reverse(head));
    }
}
