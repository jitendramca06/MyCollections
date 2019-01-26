package com.questions.java.designpattern.anotherexample.stauctural.decorator;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class DecoratorPattern implements MediaPlayer{
    private MediaPlayer mediaPlayer;

    public DecoratorPattern(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void assemble() {
        mediaPlayer.assemble();
    }
}
