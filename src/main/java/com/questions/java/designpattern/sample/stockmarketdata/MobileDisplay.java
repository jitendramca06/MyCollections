package com.questions.java.designpattern.sample.stockmarketdata;

import java.util.Calendar;

import com.sun.jmx.snmp.Timestamp;


public class MobileDisplay implements Observer,Display{

	
	public void update(Observable observable, Object arg) {
		 StockUpdate su = (StockUpdate)observable;
		 String message = "The stock details of ibm :"+su.getIbm()+" and microsoft :"+su.getMicrosoft()+" at "+Calendar.getInstance().getTime();
		 this.display(message);
	}


	public void display(String msg) {
	System.out.println(msg);
		
	}
	
}
