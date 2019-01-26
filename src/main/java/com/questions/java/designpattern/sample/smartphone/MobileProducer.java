package com.questions.java.designpattern.sample.smartphone;


import com.questions.java.designpattern.sample.smartphone.factories.AppleFactory;
import com.questions.java.designpattern.sample.smartphone.factories.SamsungFactory;

public class MobileProducer {
	public static MobileFactory getMobileFactory(MobileFactoryType type){
		MobileFactory factory = null;
		switch(type){
			case AppleFactory: 
				factory = new AppleFactory();
				break;
			case SamsungFactory:
				factory = new SamsungFactory();
				break;
			default:
				break;
		}
		return factory;
	}
}
