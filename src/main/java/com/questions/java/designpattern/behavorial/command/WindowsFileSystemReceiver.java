package com.questions.java.designpattern.behavorial.command;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class WindowsFileSystemReceiver implements FileSystemReceiver {

    @Override
    public void openFile() {
        System.out.println("Opening file in Windows OS");

    }

    @Override
    public void writeFile() {
        System.out.println("Writing file in Windows OS");
    }

    @Override
    public void closeFile() {
        System.out.println("Closing file in Windows OS");
    }
}
