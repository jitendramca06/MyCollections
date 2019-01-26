package com.questions.java.designpattern.behavorial.command;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class WriteFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public WriteFileCommand(FileSystemReceiver fs){
        this.fileSystem=fs;
    }
    @Override
    public void execute() {
        this.fileSystem.writeFile();
    }
}
