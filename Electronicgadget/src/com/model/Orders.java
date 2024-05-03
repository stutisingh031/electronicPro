package com.model;


public class Orders {
	private int orderID;
    private int customerID;
    private String orderDate;
    private double totalAmount;
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderID=" + orderID + ", customerID=" + customerID + ", orderDate=" + orderDate
				+ ", totalAmount=" + totalAmount + "]";
	}
	public Orders(int orderID, int customerID, String orderDate, double totalAmount) {
		super();
		this.orderID = orderID;
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}

