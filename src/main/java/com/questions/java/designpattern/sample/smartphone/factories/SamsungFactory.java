package com.questions.java.designpattern.sample.smartphone.factories;

import com.questions.java.designpattern.sample.smartphone.MobileFactory;
import com.questions.java.designpattern.sample.smartphone.product.smartphone.SmartPhone;
import com.questions.java.designpattern.sample.smartphone.product.smartphone.SmartPhoneType;
import com.questions.java.designpattern.sample.smartphone.product.smartphone.impl.GalaxyJ7;
import com.questions.java.designpattern.sample.smartphone.product.smartphone.impl.GalaxyOn7;
import com.questions.java.designpattern.sample.smartphone.product.tablet.Tablet;
import com.questions.java.designpattern.sample.smartphone.product.tablet.TabletType;
import com.questions.java.designpattern.sample.smartphone.product.tablet.impl.GalaxyTabA;
import com.questions.java.designpattern.sample.smartphone.product.tablet.impl.GalaxyTabS2;

public class SamsungFactory implements MobileFactory {

	@Override
	public SmartPhone createSmartPhone(SmartPhoneType type) {
		SmartPhone phone = null;
		switch(type){
			case GalaxyJ7: 
				phone = new GalaxyJ7();
				break;
			case GalaxyOn7:
				phone = new GalaxyOn7();
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
			case GalaxyTabA:
				tablet = new GalaxyTabA();
				break;
			case GalaxyTabS2:
				tablet = new GalaxyTabS2();
				break;
			default:
				break;
		}
		return tablet;
	}

}
