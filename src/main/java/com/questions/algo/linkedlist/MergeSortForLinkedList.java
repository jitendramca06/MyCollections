package com.questions.algo.linkedlist;

/**
 * @author Jitendra Kumar : 30/1/19
 * Time Complexity: O(n Log n)
 */
public class MergeSortForLinkedList {
    private static Node middleElement(Node list) {
        if (list == null) return list;
        Node slow = list;
        Node fast = list.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    private static Node mergeSort(Node list1, Node list2) {
        Node result = null;

        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.data < list2.data) {
            result = list1;
            result.next = mergeSort(list1.next, list2);
        } else {
            result = list2;
            result.next = mergeSort(list1, list2.next);
        }
        return result;
    }

    private static Node mergeSort(Node list) {
        if (list == null || list.next == null) return list;
        Node middle = middleElement(list);
        Node rightNode = middle.next;
        middle.next = null;
        Node leftList = mergeSort(list);
        Node rightList = mergeSort(rightNode);
        return mergeSort(leftList, rightList);
    }

    public static void main(String[] args) {
        /**
         * Input : 7->4->3->12->9->8
         * Output : 3->4->7->8->9->12
         */

        Node list1 = new Node(7);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node node4 = new Node(12);
        Node node5 = new Node(9);
        Node node6 = new Node(8);
        list1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Node result = mergeSort(list1);

        while (result != null) {
            System.out.print(result.data + "  ");
            result = result.next;
        }
    }
}
