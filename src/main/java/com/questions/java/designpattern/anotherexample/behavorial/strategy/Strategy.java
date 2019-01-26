package com.questions.java.designpattern.anotherexample.behavorial.strategy;

/**
 * @author Jitendra Kumar : 15/10/18
 */
public class Strategy {
    StringCom stringCom;

    public Strategy(StringCom stringCom) {
        this.stringCom = stringCom;
    }

    public boolean isEquals(String s1, String s2) {
        return stringCom.compareString(s1, s2);
    }
}
