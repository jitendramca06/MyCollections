package com.questions.java.designpattern.behavorial.memento;

/**
 * Created by jitendra on 28 Feb, 2018
 */
/*
One object stores another objects state.

 Memento design pattern is used when we want to save the state of an object so that we
 can restore later on. Memento pattern is used to implement this in such a way that
 the saved state data of the object is not accessible outside of the object, this protects the
 integrity of saved state data.

 One of the best real life stack is the text editors where we can save it’s data anytime and use undo
 to restore it to previous saved state.

We will implement the same feature and provide a utility where we can write and save contents to a
File anytime and we can restore it to last saved state. For simplicity, I will not use any IO operations
to write data into file.
 */
public class FileWriterUtil {
    private String fileName;
    private StringBuilder content;

    public FileWriterUtil(String file){
        this.fileName=file;
        this.content=new StringBuilder();
    }

    @Override
    public String toString(){
        return this.content.toString();
    }

    public void write(String str){
        content.append(str);
    }

    public Memento save(){
        return new Memento(this.fileName,this.content);
    }

    public void undoToLastSave(Object obj){
        Memento memento = (Memento) obj;
        this.fileName= memento.fileName;
        this.content=memento.content;
    }


    private class Memento{
        private String fileName;
        private StringBuilder content;

        public Memento(String file, StringBuilder content){
            this.fileName=file;
            //notice the deep copy so that Memento and FileWriterUtil content variables don't refer to same object
            this.content=new StringBuilder(content);
        }
    }
}
