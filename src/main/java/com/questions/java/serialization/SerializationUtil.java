package com.questions.java.serialization;

import java.io.*;

/**
 * A simple class with generic serialize and deserialize method implementations
 * 
 * @author jitendra
 * 
 */

/*
Now suppose we want to write our objects to file and then deserialize it from the same file.
So we need utility methods that will use ObjectInputStream and ObjectOutputStream for serialization purposes.
 */
public class SerializationUtil {

	// deserialize to Object from given file
	public static Object deserialize(String fileName) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	// serialize the given object and save it to file
	public static void serialize(Object obj, String fileName)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);

		fos.close();
	}

}
