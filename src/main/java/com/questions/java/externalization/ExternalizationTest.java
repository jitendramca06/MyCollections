package com.questions.java.externalization;

import java.io.*;

/*
Notice that I have changed the field values before converting it to Stream and then while
reading reversed the changes. In this way, we can maintain data integrity of some sorts.
We can throw exception if after reading the stream data, the integrity checks fail. Let’s
write a test program to see it in action.
 */

public class ExternalizationTest {

	public static void main(String[] args) {
		
		String fileName = "person.ser";
		Person person = new Person();
		person.setId(1);
		person.setName("Sample");
		person.setGender("Male");
		
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(person);
		    oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
		    Person p = (Person)ois.readObject();
		    ois.close();
		    System.out.println("Person Object Read="+p);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
	}

}
