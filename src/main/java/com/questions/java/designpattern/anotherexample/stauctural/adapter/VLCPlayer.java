package com.questions.java.designpattern.anotherexample.stauctural.adapter;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class VLCPlayer implements AdvancedMediaPlayer{
    @Override
    public void play(String fileName) {
        System.out.println("Play " + fileName + "......");
    }
}
