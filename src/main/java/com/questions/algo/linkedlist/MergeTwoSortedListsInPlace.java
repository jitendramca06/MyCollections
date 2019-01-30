package com.questions.algo.linkedlist;

/**
 * @author Jitendra Kumar : 29/1/19
 */
public class MergeTwoSortedListsInPlace {
    private static Node inPlaceMerge(Node list1, Node list2) {
        if (list2.next == null) {
            list1.next = list2;
            return list1;
        }

        Node current1 = list1;
        Node current2 = list2;

        while (current1 != null && current2 != null) {
            if (current1.next != null) {
                if (current1.data < current2.data && current2.data < current1.next.data) {
                    Node temp = current2;
                    current2 = current2.next;
                    temp.next = current1.next;
                    current1.next = temp;
                    current1 = current1.next;
                }  else {
                    current1 = current1.next;
                }
            } else {
                current1.next = current2;
                return list1;
            }
        }
        return list1;
    }

    public static void main(String[] args) {
        /**
         * Input : head1: 3->7->12->16
         *         head2: 2->8->9->15->17
         * Output : 3->4->7->8->9->12
         */

        Node list1 = new Node(3);
        Node node1 = new Node(7);
        Node node2 = new Node(12);
        Node node8 = new Node(16);
        list1.next = node1;
        node1.next = node2;
        node2.next = node8;

        Node list2 = new Node(2);
        Node node4 = new Node(8);
        Node node5 = new Node(9);
        Node node6 = new Node(15);
        Node node7 = new Node(17);
        list2.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Node result = null;
        if (list1.data < list2.data) result = inPlaceMerge(list1, list2);
        else result = inPlaceMerge(list2, list1);
        while (result != null) {
            System.out.print(result.data + "  ");
            result = result.next;
        }
    }
}
