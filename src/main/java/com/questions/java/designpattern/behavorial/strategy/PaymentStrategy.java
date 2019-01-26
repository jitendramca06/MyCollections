package com.questions.java.designpattern.behavorial.strategy;

/**
 * Created by jitendra on 28 Feb, 2018
 */

/*
An object controls which of a family of methods is called. Each method is in its' own
class that extends a common base class.
Strategy pattern is used when we have multiple algorithm for a specific task and client decides the
actual implementation to be used at runtime.
Strategy pattern is also known as Policy Pattern. We define multiple algorithms and let client application
pass the algorithm to be used as a parameter.

For our stack, we will try to implement a simple Shopping Cart where we have two payment strategies

– using Credit Card or using PayPal.

First of all we will create the interface for our strategy pattern stack, in our case to pay the
amount passed as argument.


 */
public interface PaymentStrategy {
    public void pay(int amount);
}
