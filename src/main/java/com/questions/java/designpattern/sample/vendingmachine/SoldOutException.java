package com.questions.java.designpattern.sample.vendingmachine;

/**
 * @author Jitendra Kumar : 5/9/18
 */
public class SoldOutException extends RuntimeException {
    private String message;

    public SoldOutException(String string) {
        this.message = string;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
