package com.questions.java.designpattern.sample.atm;

/**
 * @author Jitendra Kumar : 5/9/18
 */
public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);

    void dispense(Currency cur);
}
