package com.model;


public class Inventory {
	private int inventoryID;
    private int productID;
    private int quantityInStock;
    private double lastStockUpdate;
	public Inventory(int inventoryID, int productID, int quantityInStock, double lastStockUpdate) {
		super();
		this.inventoryID = inventoryID;
		this.productID = productID;
		this.quantityInStock = quantityInStock;
		this.lastStockUpdate = lastStockUpdate;
	}
	public int getInventoryID() {
		return inventoryID;
	}
	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public double getLastStockUpdate() {
		return lastStockUpdate;
	}
	public void setLastStockUpdate(double lastStockUpdate) {
		this.lastStockUpdate = lastStockUpdate;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Inventory [inventoryID=" + inventoryID + ", productID=" + productID + ", quantityInStock="
				+ quantityInStock + "]";
	}
}
