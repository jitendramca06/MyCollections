package com.questions.java.designpattern.behavorial.observer;

/**
 * Created by jitendra on 28 Feb, 2018
 */
public interface Observer {
    //method to update the observer, used by subject
    public void getUpdate();

    //attach with subject to observe
    public void setSubject(Subject sub);
}
