package com.questions.java.methodreferences;

/**
 * Created by jitendra on 13 Mar, 2018
 */
interface Messageable {
    Message getMessage(String msg);
}

class Message {
    Message(String msg) {
        System.out.print(msg);
    }
}

public class ConstructorReference {
    public static void main(String[] args) {
        Messageable hello = Message::new;
        hello.getMessage("Hello");
    }
}
