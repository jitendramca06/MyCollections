package com.questions.java.designpattern.sample.smartphone;

import com.questions.java.designpattern.sample.smartphone.product.smartphone.SmartPhone;
import com.questions.java.designpattern.sample.smartphone.product.smartphone.SmartPhoneType;
import com.questions.java.designpattern.sample.smartphone.product.tablet.Tablet;
import com.questions.java.designpattern.sample.smartphone.product.tablet.TabletType;

public interface MobileFactory {
	public SmartPhone createSmartPhone(SmartPhoneType type);
	public Tablet createTablet(TabletType type);
}
