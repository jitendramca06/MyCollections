package com.questions.java.designpattern.anotherexample.stauctural.decorator;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class Mp4MediaPlayer extends DecoratorPattern{
    public Mp4MediaPlayer(MediaPlayer mediaPlayer) {
        super(mediaPlayer);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding MP4 Player....");
    }
}
