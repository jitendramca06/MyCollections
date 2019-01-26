package com.questions.java.designpattern.behavorial.chainofresponsibility;

/**
 * Created by jitendra on 27 Feb, 2018
 */

/*
Chain of responsibility pattern is used to achieve loose coupling in software design where a
request from client is passed to a chain of objects to process them. Then the object in
the chain will decide themselves who will be processing the request and whether the request is
required to be sent to the next object in the chain or not.

Let’s see the stack of chain of responsibility pattern in JDK and then we will proceed to implement a
real life stack of this pattern. We know that we can have multiple catch blocks in a try-catch block code.
Here every catch block is kind of a processor to process that particular exception.

So when any exception occurs in the try block, its send to the first catch block to process.
If the catch block is not able to process it, it forwards the request to next object in chain
i.e next catch block. If even the last catch block is not able to process it, the exception is
thrown outside of the chain to the calling program.

One of the great stack of Chain of Responsibility pattern is ATM Dispense machine.
The user enters the amount to be dispensed and the machine dispense amount in terms
of defined currency bills such as 50$, 20$, 10$ etc.If the user enters an amount that is not multiples of 10,
it throws error. We will use Chain of Responsibility pattern to implement this solution.
 */
public class Currency {
    private int amount;

    public Currency(int amt){
        this.amount=amt;
    }

    public int getAmount(){
        return this.amount;
    }
}
