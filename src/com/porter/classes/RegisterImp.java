package com.porter.classes;

import java.util.HashMap;
import java.util.Map;

public class RegisterImp implements Register {
	private Map menuItems;
	private double total;
	
	public RegisterImp(){
		menuItems = new HashMap();
		total = 0;
	}
	public void addItem(String name, double price){
		MenuItem item = new MenuItemImp(name, price);
		menuItems.put(name, item);
	}
	
	public MenuItemImp getItemByName(String name){
		return (MenuItemImp) menuItems.get(name);
	}
	
	public void purchaseItem(String name){
		MenuItemImp item = getItemByName(name);
		total += item.getPrice();
	}
	
	public double checkout(){
		double t = total;
		menuItems = new HashMap();
		total = 0;
		return t;
		
		
	}
	
	
}
