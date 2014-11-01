package com.porter.classes;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RegisterImp implements Register {
	private Map menuItems;
	private double total;
	
	public double getTotal(){
		return total;
	}
	public void setTotal(double t){
		this.total = t;
	}
	public RegisterImp(){
		menuItems = new HashMap();
		total = 0;
	}
	public void addItem(String name, double price){
		MenuItem item = new MenuItemImp(name, price);
		menuItems.put(name, item);
	}
	
	public MenuItem getItemByName(String name){
		return (MenuItem) menuItems.get(name);
	}
	
	public void purchaseItem(String name){
		MenuItem item = getItemByName(name);
		total = (item.getPrice() + total);
		item.setCount(item.getCount()+1);
	}
	
	public double checkout(){
		double t = total;
		menuItems = new HashMap();
		total = 0;
		return t;
		
		
	}
	public String getTotalMessage(){
		String totalMessage = new String();
		
		Iterator it = menuItems.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry item = (Map.Entry)it.next();
			String name = (String) item.getKey();
			MenuItem items = (MenuItem) item.getValue();
			if(items.getCount() > 0){
				 
				totalMessage = totalMessage + name + " X " + items.getCount() + " $"+(items.getCount() * items.getPrice()) + "\n";
			}
			
		}
		
		return totalMessage;
	}
	
	
}
