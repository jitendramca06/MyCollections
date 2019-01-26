package com.questions.java.designpattern.sample.smartphone.product.tablet.impl;


import com.questions.java.designpattern.sample.smartphone.product.tablet.Tablet;

public class GalaxyTabA implements Tablet {
	
	@Override
	public String info() {
		String msg = String.format("This is %s - %s."
								, "Galaxy Tab A", "9.7-inches display");
		return msg;
	}
}
