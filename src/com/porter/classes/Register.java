package com.porter.classes;

public interface Register {
	
	public void addItem(String name, double price);
	
	public MenuItem getItemByName(String name);
	
	public void purchaseItem(String name);
	public String getTotalMessage();
	public double checkout();
	public double getTotal();
	public void setTotal(double t);
}
