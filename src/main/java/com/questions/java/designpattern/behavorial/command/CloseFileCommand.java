package com.questions.java.designpattern.behavorial.command;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class CloseFileCommand implements Command {

    private FileSystemReceiver fileSystem;

    public CloseFileCommand(FileSystemReceiver fs){
        this.fileSystem=fs;
    }
    @Override
    public void execute() {
        this.fileSystem.closeFile();
    }
}
