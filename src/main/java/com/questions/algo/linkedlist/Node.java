package com.questions.algo.linkedlist;

/**
 * @author Jitendra Kumar : 24/8/18
 */
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.next = null;
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
