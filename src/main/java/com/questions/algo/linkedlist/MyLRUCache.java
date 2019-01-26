package com.questions.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jitendra Kumar : 5/9/18
 */
public class MyLRUCache {
    private DoublyLinkedList doublyLinkedList;
    private Map<Integer, DoublyNode> doublyNodeMap;

    MyLRUCache(int cacheSize) {
        this.doublyLinkedList = new DoublyLinkedList(cacheSize);
        this.doublyNodeMap = new HashMap<>();
    }

    private void acceptData(int data) {
        DoublyNode node = null;
        if (doublyNodeMap.containsKey(data)) {
            node = doublyNodeMap.get(data);
            doublyLinkedList.moveDataToHead(node);
        } else {
            if (doublyLinkedList.currentSize == doublyLinkedList.size) {
                doublyNodeMap.remove(doublyLinkedList.tail.data);
            }
            node = doublyLinkedList.addToList(data);
            doublyNodeMap.put(data, node);
        }
    }

    private void print() {
        doublyLinkedList.print();
    }

    public static void main(String[] args) {
        MyLRUCache myLRUCache = new MyLRUCache(4);
        myLRUCache.acceptData(4);
        myLRUCache.print();
        System.out.println();
        myLRUCache.acceptData(2);
        myLRUCache.print();
        System.out.println();
        myLRUCache.acceptData(1);
        myLRUCache.print();
        System.out.println();
        myLRUCache.acceptData(1);
        myLRUCache.print();
        myLRUCache.acceptData(4);
        myLRUCache.print();
        System.out.println();
    }


    private class DoublyLinkedList{
        private final int size;
        private int currentSize;
        DoublyNode head;
        DoublyNode tail;

        DoublyLinkedList(int size) {
            this.size = size;
            this.currentSize = 0;
        }

        private void moveDataToHead(DoublyNode node) {
            if (node == null || node == head) {
                return;
            }
            if (node == tail) {
                tail = node.previous;
                tail.next = null;
            }

            DoublyNode pre = node.previous;
            DoublyNode next = node.next;
            pre.next = next;
            if (next != null)
                next.previous = pre;
            node.next = head;
            head.previous = node;
            node.previous = null;
            head = node;
        }

        private DoublyNode addToList(int data) {
            DoublyNode node = new DoublyNode(data);
            if (head == null) {
                head = node;
                tail = node;
                currentSize++;
                return node;
            } else if (currentSize < size) {
                currentSize++;
            } else {
                tail = tail.previous;
                tail.next = null;
            }
            node.next = head;
            head.previous = node;
            head = node;
            return node;
        }

        private void print() {
            if (head == null) return;
            DoublyNode temp = head;
            while (temp != null) {
                System.out.print(temp.data + "  ");
                temp = temp.next;
            }

            System.out.println();
        }
    }
}
