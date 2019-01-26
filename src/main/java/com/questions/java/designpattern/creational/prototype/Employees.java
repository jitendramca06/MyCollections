package com.questions.java.designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jitendra on 26 Feb, 2018
 */

/*
Make new objects by cloning the objects which you set as prototypes



prototype design pattern is used when the Object creation
is a costly affair and requires a lot of time and resources and
you have a similar object already existing.

prototype pattern provides a mechanism to copy the original object to a new object and
then modify it according to our needs. prototype design pattern uses java cloning to copy the object.
 */
public class Employees implements Cloneable{
    private List<String> empList;

    public Employees(){
        empList = new ArrayList<String>();
    }

    public Employees(List<String> list){
        this.empList=list;
    }
    public void loadData(){
        //read all employees from database and put into the list
        empList.add("Jitendra");
        empList.add("Raj");
        empList.add("David");
        empList.add("Lisa");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<String> temp = new ArrayList<String>();
        for(String s : this.getEmpList()){
            temp.add(s);
        }
        return new Employees(temp);
    }
}
