package com.questions.java.designpattern.sample.smartphone.product.tablet.impl;

import com.questions.java.designpattern.sample.smartphone.product.tablet.Tablet;

public class IPadMini4 implements Tablet {

	@Override
	public String info() {
		String msg = String.format("This is %s - %s."
								, "iPad mini 4", "7.9-inches display");
		return msg;
	}
}
