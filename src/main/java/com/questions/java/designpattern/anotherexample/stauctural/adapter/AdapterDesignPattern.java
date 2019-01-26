package com.questions.java.designpattern.anotherexample.stauctural.adapter;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class AdapterDesignPattern implements MediaPlayer{
    AdvancedMediaPlayer advancedMediaPlayer;
    public AdapterDesignPattern(AdvancedMediaPlayer advancedMediaPlayer) {
        this.advancedMediaPlayer = advancedMediaPlayer;
    }
    @Override
    public void play(String fileName) {
        advancedMediaPlayer.play(fileName);
    }
}
