package com.questions.java.designpattern.sample.smartphone.product.smartphone.impl;

import com.questions.java.designpattern.sample.smartphone.product.smartphone.SmartPhone;

public class Iphone6 implements SmartPhone {
	
	@Override
	public String info() {
		String msg = String.format("This is %s - %s."
								,"iPhone 6s", "4.7-inch display");
		return msg;
	}
}
