package com.questions.java.serialization;

import java.io.Serializable;

/*
If you want a class object to be serializable, all you need to do it implement the java.io.Serializable interface.
Serializable in java is a marker interface and has no fields or methods to implement. It’s like an Opt-In
process through which we make our classes serializable.

Serialization in java is implemented by ObjectInputStream and ObjectOutputStream, so all we need is a
wrapper over them to either save it to file or send it over the network. Let’s see a simple Serialization
in java program stack.

Notice that it’s a simple java bean with some properties and getter-setter methods. If you want an object
property to be not serialized to stream, you can use transient keyword like I have done with salary variable.
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = -6470090944414208496L;
	private String name;
	private int id;
	transient private int salary;
	private String password;
	
	@Override
	public String toString(){
		return "Employee{name="+name+",id="+id+",salary="+salary+"}";
	}
	
	//getter and setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
