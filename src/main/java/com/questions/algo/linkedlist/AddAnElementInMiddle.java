package com.questions.algo.linkedlist;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class AddAnElementInMiddle {
    private static void insertAtMid(Node root, int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        } else {
            int len = 0;
            Node temp = root;
            while (temp != null) {
                temp = temp.next;
                len++;
            }

            int mid  = (len%2 == 0) ? len/2 : (len +1)/2;
            temp = root;
            while (mid-- > 1) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    private static void print(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node insertAtMid1(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        if (head.next == null) {
            head.next = newNode;
            return head;
        }
        if (head.next.next == null) {
            newNode.next = head.next;
            head.next = newNode;
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow= slow.next;
            fast = fast.next.next;
        }
        newNode.next = slow.next;
        slow.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);

        /*print(head1);
        insertAtMid(head1, 5);
        print(head1);*/
        Node node = insertAtMid1(null, 3);
        print(node);
        System.out.println("==========================");
        node.next = new Node(4);
        Node node1 = insertAtMid1(node, 5);
        print(node1);
        System.out.println("==========================");
        Node node2 = insertAtMid1(node1, 6);
        print(node2);
        Node node3 = insertAtMid1(node2, 7);
        print(node3);
    }
}
