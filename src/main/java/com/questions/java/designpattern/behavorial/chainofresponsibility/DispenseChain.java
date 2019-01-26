package com.questions.java.designpattern.behavorial.chainofresponsibility;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);

    void dispense(Currency cur);
}
