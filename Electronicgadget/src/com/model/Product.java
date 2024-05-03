package com.model;

public class Product {
	private int productID;
    private String productName;
    private String description;
    private double price;
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product(int productID, String productName, String description, double price) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + "]";
	}
}
