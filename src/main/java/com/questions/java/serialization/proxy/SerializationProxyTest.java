package com.questions.java.serialization.proxy;


import com.questions.java.serialization.SerializationUtil;

import java.io.IOException;


public class SerializationProxyTest {

	public static void main(String[] args) {
		String fileName = "data.ser";
		
		Data data = new Data("Sample");
		
		try {
			SerializationUtil.serialize(data, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Data newData = (Data) SerializationUtil.deserialize(fileName);
			System.out.println(newData);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
