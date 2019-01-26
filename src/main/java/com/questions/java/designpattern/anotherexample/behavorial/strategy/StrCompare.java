package com.questions.java.designpattern.anotherexample.behavorial.strategy;

/**
 * @author Jitendra Kumar : 15/10/18
 */
public class StrCompare implements StringCom{
    @Override
    public boolean compareString(String s1, String s2) {
        return s1 == s2;
    }
}
