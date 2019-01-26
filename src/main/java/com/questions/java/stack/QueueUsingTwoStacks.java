package com.questions.java.stack;

import java.util.Stack;

/**
 * Created by jitendra on 14 Mar, 2018
 */
public class QueueUsingTwoStacks<E> {
    Stack<E> stack;
    Stack<E> temp;

    QueueUsingTwoStacks() {
        this.stack = new Stack<>();
        this.temp = new Stack<>();
    }

    public void push(E e) {
        if (stack.empty()) {
            stack.push(e);
            return;
        }
        while (!stack.empty()) temp.push(stack.pop());
        stack.push(e);
        while (!temp.empty()) stack.push(temp.pop());
    }

    public E pop() {
        if (isEmpty()) return null;
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public int size() {
        return stack.size();
    }

    public E peek() {
        if (isEmpty()) return null;
        return stack.peek();
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks<String> stacks = new QueueUsingTwoStacks<>();
        System.out.println(stacks.size());
        System.out.println(stacks.pop());
        stacks.push("A");
        stacks.push("B");
        stacks.push("C");
        stacks.push("D");
        stacks.push("E");
        stacks.push("F");
        stacks.push("G");
        System.out.println(stacks.size());
        System.out.println(stacks.pop());
        System.out.println(stacks.size());
    }
}
