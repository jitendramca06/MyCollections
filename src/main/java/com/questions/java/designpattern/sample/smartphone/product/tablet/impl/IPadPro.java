package com.questions.java.designpattern.sample.smartphone.product.tablet.impl;


import com.questions.java.designpattern.sample.smartphone.product.tablet.Tablet;

public class IPadPro implements Tablet {

	@Override
	public String info() {
		String msg = String.format("This is %s - %s."
								, "iPad Pro", "12.9-inches display");
		return msg;
	}
}
