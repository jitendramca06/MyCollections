package com.questions.java.designpattern.behavorial.observer;

/**
 * Created by jitendra on 28 Feb, 2018
 */
/*
An object notifies other object(s) if it changes.

Observer design pattern is useful when you are interested in the state of an
object and want to get notified whenever there is any change. In observer pattern,
 the object that watch on the state of another object are called Observer and the object
 that is being watched is called Subject.

 Define a one-to-many dependency between objects so that when one object changes state,
 all its dependents are notified and updated automatically.

Subject contains a list of observers to notify of any change in it’s state, so it should provide
methods using which observers can register and unregister themselves. Subject also contain a method
to notify all the observers of any change and either it can send the update while notifying the observer
or it can provide another method to get the update.

Observer should have a method to set the object to watch and another method that will be used by Subject to
notify them of any updates.

Java provides inbuilt platform for implementing Observer pattern through java.util.Observable class and
java.util.Observer interface. However it’s not widely used because the implementation is really simple
and most of the times we don’t want to end up extending a class just for implementing Observer pattern as
java doesn’t provide multiple inheritance in classes.

 */
public interface Subject {
    //methods to register and unregister observers
    public void register(Observer obj);
    public void unregister(Observer obj);

    //method to notify observers of change
    public void notifyObservers();

    //method to get updates from subject
    public Object update();
}
