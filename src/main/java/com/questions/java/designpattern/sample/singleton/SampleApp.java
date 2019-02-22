package com.questions.java.designpattern.sample.singleton;

/**
 * @author Jitendra Kumar : 5/9/18
 */
public class SampleApp {
    public static void main(String[] args) {
        WithoutClone withoutClone = WithoutClone.getInstance();
        System.out.println(withoutClone);
        try {
            WithoutClone withoutClone1 = (WithoutClone) withoutClone.clone();
            System.out.println(withoutClone1==withoutClone);
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
