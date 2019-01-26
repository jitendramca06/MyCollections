package com.questions.java.designpattern.anotherexample.stauctural.decorator;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class SampleApp {
    public static void main(String[] args) {
        MediaPlayer player = new BasicMediaPlayer();
        player.assemble();
        System.out.println();
        player = new VLCPlayer(new Mp4MediaPlayer(new BasicMediaPlayer()));
        player.assemble();
    }
}
