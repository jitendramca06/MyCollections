package com.questions.java.designpattern.sample.smartphone.product.smartphone.impl;


import com.questions.java.designpattern.sample.smartphone.product.smartphone.SmartPhone;

public class GalaxyOn7 implements SmartPhone {
	
	@Override
	public String info() {
		String msg = String.format("This is %s - %s."
								, "Samsung Galary On7", "5.5-inches display");
		return msg;
	}
}
