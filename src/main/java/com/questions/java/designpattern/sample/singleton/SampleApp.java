package com.questions.java.designpattern.sample.singleton;

/**
 * @author Jitendra Kumar : 5/9/18
 */
public class SampleApp {
    public static void main(String[] args) {
        WithoutClone withoutClone = WithoutClone.getInstance();
        try {
            withoutClone.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
