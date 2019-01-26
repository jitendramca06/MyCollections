package com.questions.java.serialization.inheritance;

/*
Java Serialization Methods

We have seen that serialization in java is automatic and all we need is implementing Serializable interface.
The implementation is present in the ObjectInputStream and ObjectOutputStream classes. But what
if we want to change the way we are saving data, for stack we have some sensitive information in
the object and before saving/retrieving we want to encrypt/decrypt it. That’s why there are four methods
that we can provide in the class to change the serialization behavior.

If these methods are present in the class, they are used for serialization purposes.

readObject(ObjectInputStream ois): If this method is present in the class, ObjectInputStream readObject()
method will use this method for reading the object from stream.
writeObject(ObjectOutputStream oos): If this method is present in the class, ObjectOutputStream writeObject()
method will use this method for writing the object to stream. One of the common usage is to obscure the object
variables to maintain data integrity.
Object writeReplace(): If this method is present, then after serialization process this method is called and
the object returned is serialized to the stream.
Object readResolve(): If this method is present, then after deserialization process, this method is called
to return the final object to the caller program. One of the usage of this method is to implement Singleton
pattern with Serialized classes. Read more at Serialization and Singleton.
Usually while implementing above methods, it’s kept as private so that subclasses can’t override them.
They are meant for serialization purpose only and keeping them private avoids any security issue.


Serialization with Inheritance

Sometimes we need to extend a class that doesn’t implement Serializable interface. If we rely on the
automatic serialization behavior and the superclass has some state, then they will not be converted to
stream and hence not retrieved later on.

This is one place, where readObject() and writeObject() methods really help. By providing their implementation,
we can save the super class state to the stream and then retrieve it later on. Let’s see this in action.
 */
public class SuperClass {

	SuperClass() {
		System.out.println("Supper Class");
	}

	private int id;
	private String value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
