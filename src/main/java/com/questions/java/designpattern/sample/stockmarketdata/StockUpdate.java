package com.questions.java.designpattern.sample.stockmarketdata;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class StockUpdate implements Observable{
	private Set<Observer> observers;
	private boolean stockIndexChanged;
	
	private float ibm;
	private float microsoft;
	
	public StockUpdate(){
		observers = new HashSet<Observer>();
		
	}
	
	

	public void notifyObservers() {
	Iterator<Observer> observerIterator = this.observers.iterator();
	while(observerIterator.hasNext()){
		Observer observer = observerIterator.next();
		observer.update(this, null);
	}
		
	}

	
	public void registerObserver(Observer observer) {
		if(observer != null && observer instanceof Observer){
			this.observers.add(observer);
		}
		
	}

	
	public void removeObserver(Observer observer) {
		if(observer != null && observer instanceof Observer){
			this.observers.remove(observer);
		}
		
	}


	public float getIbm() {
		return ibm;
	}


	public void setIbm(float ibm) {
		if(this.ibm != ibm){
			this.stockIndexChanged = true;
			this.ibm = ibm;
		}
		this.setStockChanged();
	}


	public float getMicrosoft() {
		return microsoft;
	}


	public void setMicrosoft(float microsoft) {
		if(this.microsoft != microsoft){
			this.stockIndexChanged = true;
			this.microsoft = microsoft;
		}
		this.setStockChanged();
	}

    public void setStockChanged(){
    	this.notifyObservers();
    }
	


	
	
	
}
