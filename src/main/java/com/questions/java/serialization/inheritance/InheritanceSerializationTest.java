package com.questions.java.serialization.inheritance;

import com.questions.java.serialization.SerializationUtil;

import java.io.IOException;

public class InheritanceSerializationTest {

	public static void main(String[] args) {
		String fileName = "subclass.ser";
		
		SubClass subClass = new SubClass();
		subClass.setId(10);
		subClass.setValue("Data");
		subClass.setName("Sample");
		
		try {
			System.out.println("==========================");
			SerializationUtil.serialize(subClass, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			System.out.println("==========================");
			SubClass subNew = (SubClass) SerializationUtil.deserialize(fileName);
			System.out.println("SubClass read = "+subNew);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
