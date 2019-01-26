package com.questions.java.designpattern.behavorial.mediator;

/**
 * Created by jitendra on 28 Feb, 2018
 */

/*
Passes communication between two or more objects.


Mediator design pattern is very helpful in an enterprise application where multiple objects are interacting
with each other. If the objects interact with each other directly, the system components are tightly-coupled
with each other that makes higher maintainability cost and not hard to extend. Mediator pattern focuses on provide
a mediator between objects for communication and help in implementing lose-coupling between objects.

Air traffic controller is a great stack of mediator pattern where the airport control room works as
a mediator for communication between different flights. Mediator works as a router between objects and it
can have it’s own logic to provide way of communication.
 */
public interface ChatMediator {
    public void sendMessage(String msg, User user);

    void addUser(User user);
}
