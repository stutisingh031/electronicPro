package com.model;

public class OrderDetails {
	private int orderDetailID;
    private int orderID;
    private int productID;
    private int quantity;
	public int getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderDetailID=" + orderDetailID + ", orderID=" + orderID + ", productID=" + productID
				+ ", quantity=" + quantity + "]";
	}
	public OrderDetails(int orderDetailID, int orderID, int productID, int quantity) {
		super();
		this.orderDetailID = orderDetailID;
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
	}
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
}
