package com.questions.java.designpattern.sample.smartphone.factories;

import com.questions.java.designpattern.sample.smartphone.MobileFactory;
import com.questions.java.designpattern.sample.smartphone.product.smartphone.SmartPhone;
import com.questions.java.designpattern.sample.smartphone.product.smartphone.SmartPhoneType;
import com.questions.java.designpattern.sample.smartphone.product.smartphone.impl.Iphone6;
import com.questions.java.designpattern.sample.smartphone.product.smartphone.impl.Iphone6Plus;
import com.questions.java.designpattern.sample.smartphone.product.tablet.Tablet;
import com.questions.java.designpattern.sample.smartphone.product.tablet.TabletType;
import com.questions.java.designpattern.sample.smartphone.product.tablet.impl.IPadMini4;
import com.questions.java.designpattern.sample.smartphone.product.tablet.impl.IPadPro;

public class AppleFactory implements MobileFactory {
	@Override
	public SmartPhone createSmartPhone(SmartPhoneType type) {
		SmartPhone phone = null;
		switch(type){
			case Iphone6: 
				phone = new Iphone6();
				break;
			case Iphone6Plus:
				phone = new Iphone6Plus();
				break;
			default:
				break;
		}
		return phone;
	}

	@Override
	public Tablet createTablet(TabletType type) {
		Tablet tablet = null;
		switch(type){
			case IPadMini4:
				tablet = new IPadMini4();
				break;
			case IPadPro:
				tablet = new IPadPro();
				break;
			default:
				break;
		}
		return tablet;
	}

}
