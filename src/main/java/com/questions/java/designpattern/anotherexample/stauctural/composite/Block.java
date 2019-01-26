package com.questions.java.designpattern.anotherexample.stauctural.composite;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class Block implements Group{
    @Override
    public void assemble() {
        System.out.println("Block");
    }
}
