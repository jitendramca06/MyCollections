package com.questions.java.designpattern.behavorial.command;

/**
 * Created by jitendra on 27 Feb, 2018
 */

/*
Command object passes the request to the appropriate method of Receiver to perform the specific action.

The client program create the receiver object and then attach it to the Command. Then it creates the
invoker object and attach the command object to perform an action.

Now when client program executes the action, it’s processed based on the command and receiver object.

We will look at a real life scenario where we can implement Command pattern. Let’s say we want to
provide a File System utility with methods to open, write and close file. This file system utility
should support multiple operating systems such as Windows and Unix.
 */
public interface FileSystemReceiver {
    void openFile();
    void writeFile();
    void closeFile();
}
