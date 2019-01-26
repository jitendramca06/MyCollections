package com.questions.java.designpattern.behavorial.memento;

/**
 * Created by jitendra on 28 Feb, 2018
 */
public class FileWriterCaretaker {
    private Object obj;

    public void save(FileWriterUtil fileWriter){
        this.obj=fileWriter.save();
    }

    public void undo(FileWriterUtil fileWriter){
        fileWriter.undoToLastSave(obj);
    }
}
