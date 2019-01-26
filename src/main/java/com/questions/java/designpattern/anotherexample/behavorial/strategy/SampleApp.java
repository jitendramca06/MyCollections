package com.questions.java.designpattern.anotherexample.behavorial.strategy;

/**
 * @author Jitendra Kumar : 15/10/18
 */
public class SampleApp {
    public static void main(String[] args) {
        Strategy strategy = new Strategy(new StrCompare());
        System.out.println(strategy.isEquals("Jitendra", "Jitendra"));
        strategy = new Strategy(new StringComByEquals());
        System.out.println(strategy.isEquals("Jitendra", "Jitendra"));
        strategy = new Strategy(new StringComByComparator());
        System.out.println(strategy.isEquals("Jitendra", "Jitendra"));

    }
}
