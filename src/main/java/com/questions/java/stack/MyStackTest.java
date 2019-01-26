package com.questions.java.stack;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        MyStack<String> myStack = new MyStack<String>();
        myStack.push(1 +"");
        myStack.push(2 +"");
        myStack.push(3 +"");
        myStack.push(3 +"");
        myStack.push(4 +"");

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
