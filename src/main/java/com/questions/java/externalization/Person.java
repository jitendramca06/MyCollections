package com.questions.java.externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/*
If you notice the java serialization process, it’s done automatically. Sometimes we want to obscure
the object data to maintain it’s integrity. We can do this by implementing java.io.Externalizable
interface and provide implementation of writeExternal() and readExternal() methods to be used in
serialization process.


However, the implemention of the Externalizable interface must take place with caution, since there are some fundamental characteristics:

First of all, if a class implements the Serializable interface, then the Java Virtual Machine (JVM) is responsible for its automatic serialization. Otherwise, if a class implements the Externalizable interface, the developer and maintainer of a class is responsible for its serialization.
Second, the Externalizable interface poses the challenge of how to serialize the super type state, default values in case of transient variables and finally, static variables.
Third, in case a class implements the Externalizable inteface and a single field is changed, both the writeExternal and readExternal methods must be upgraded.
*/

public class Person implements Externalizable{

	private int id;
	private String name;
	private String gender;
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeObject(name+"xyz");
		out.writeObject("abc"+gender);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		id=in.readInt();
		//read in the same order as written
		name=(String) in.readObject();
		if(!name.endsWith("xyz")) throw new IOException("corrupted data");
		name=name.substring(0, name.length()-3);
		gender=(String) in.readObject();
		if(!gender.startsWith("abc")) throw new IOException("corrupted data");
		gender=gender.substring(3);
	}

	@Override
	public String toString(){
		return "Person{id="+id+",name="+name+",gender="+gender+"}";
	}
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
