package com.porter.classes;

public class MenuItemImp implements MenuItem{
	
	private String name;
	private double price;
	
	MenuItemImp(){}
	MenuItemImp(String n, double p){
		setName(n);
		setPrice(p);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
