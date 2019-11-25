package com.questions.java.customclassLoader;

/**
 * @author Jitendra Kumar : 10/5/19
 */
public class ClassToBeLoaded {
    private String name;
    private String address;
    private int id;

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
