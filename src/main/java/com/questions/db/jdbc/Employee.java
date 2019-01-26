package com.questions.db.jdbc;

/**
 * @author Jitendra Kumar : 26/1/19
 */
public class Employee {
    private int id;
    private String name;
    private int managerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerId=" + managerId +
                '}';
    }
}
