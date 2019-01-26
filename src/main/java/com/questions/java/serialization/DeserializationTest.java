package com.questions.java.serialization;

import java.io.IOException;

/*
Class Refactoring with Serialization and serialVersionUID

Serialization in java permits some changes in the java class if they can be ignored. Some of the
changes in class that will not affect the deserialization process are:

Adding new variables to the class
Changing the variables from transient to non-transient, for serialization it’s like having a new field.
Changing the variable from static to non-static, for serialization it’s like having a new field.
But for all these changes to work, the java class should have serialVersionUID defined for the class.
Let’s write a test class just for deserialization of the already serialized file from previous test class.

The reason is clear that serialVersionUID of the previous class and new class are different.
Actually if the class doesn’t define serialVersionUID, it’s getting calculated automatically and
assigned to the class. Java uses class variables, methods, class name, package etc to generate this
unique long number. If you are working with any IDE, you will automatically get a warning that
“The serializable class Employee does not declare a static final serialVersionUID field of type long”.
 */
public class DeserializationTest {

	public static void main(String[] args) {

		String fileName="employee.ser";
		Employee empNew = null;
		
		try {
			empNew = (Employee) SerializationUtil.deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("empNew Object::"+empNew);
		
	}

}
