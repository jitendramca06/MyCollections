package com.questions.java.designpattern.behavorial.command;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class FileInvoker {
    public Command command;

    public FileInvoker(Command c){
        this.command=c;
    }

    public void execute(){
        this.command.execute();
    }
}
