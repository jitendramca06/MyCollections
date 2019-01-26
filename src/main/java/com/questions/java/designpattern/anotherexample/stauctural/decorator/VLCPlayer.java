package com.questions.java.designpattern.anotherexample.stauctural.decorator;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class VLCPlayer extends DecoratorPattern{
    public VLCPlayer(MediaPlayer mediaPlayer) {
        super(mediaPlayer);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding VLC Player....");
    }
}
