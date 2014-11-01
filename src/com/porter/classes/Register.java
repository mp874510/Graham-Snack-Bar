package com.porter.classes;

public interface Register {
	
	public void addItem(String name, double price);
	
	public MenuItemImp getItemByName(String name);
	
	public void purchaseItem(String name);
	
	public double checkout();
	public double getTotal();
	public void setTotal(double t);
}
