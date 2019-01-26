package com.questions.java.designpattern.behavorial.state;

/**
 * Created by jitendra on 28 Feb, 2018
 */

/*
An object appears to change its' class when the class it passes calls through to switches itself for a related class.

State design pattern is used when an Object change its behavior based on its internal state.
If we have to change the behavior of an object based on its state, we can have a state variable
in the Object. Then use if-else condition block to perform different actions based on the state.
State design pattern is used to provide a systematic and loosely coupled way to achieve this
through Context and State implementations.

State Pattern Context is the class that has a State reference to one of the concrete implementations of the State.
Context forwards the request to the state object for processing. Let’s understand this with a simple stack.

Suppose we want to implement a TV Remote with a simple button to perform action. If the State is ON,
it will turn on the TV and if state is OFF, it will turn off the TV.
 */
public class TVRemoteBasic {
    private String state="";

    public void setState(String state){
        this.state=state;
    }

    public void doAction(){
        if(state.equalsIgnoreCase("ON")){
            System.out.println("TV is turned ON");
        }else if(state.equalsIgnoreCase("OFF")){
            System.out.println("TV is turned OFF");
        }
    }

    public static void main(String args[]){
        TVRemoteBasic remote = new TVRemoteBasic();

        remote.setState("ON");
        remote.doAction();

        remote.setState("OFF");
        remote.doAction();
    }
}
