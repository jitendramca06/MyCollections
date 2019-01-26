package com.questions.java.designpattern.anotherexample.stauctural.adapter;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class SampleExample {
    public static void main(String[] args) {
        MediaPlayer mp3Player = new Mp3Player();
        mp3Player.play("songs.MP3");
        MediaPlayer mp4 = new AdapterDesignPattern(new MP4Player());
        mp4.play("songs.MP4");
        MediaPlayer player = new AdapterDesignPattern(new VLCPlayer());
        player.play("vlc file");
    }
}
