package com.lcpan.bean;

public class OrderBean {
	private String bookno;
	private double price;
	private int quantity;
	public String getBookno() {
		return bookno;
	}
	public void setBookno(String bookno) {
		this.bookno = bookno;
	}
	public double getPrice() {
		return price;
	}
	public double getSubTotal() {
		return price*quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
