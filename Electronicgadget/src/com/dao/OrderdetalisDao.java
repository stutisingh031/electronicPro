package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Product;

public interface  OrderdetalisDao {
	double calculateSubtotal(int orderDetailID) throws SQLException;
    String getOrderDetailInfo(int orderDetailID) throws SQLException;
    void updateQuantity(int orderDetailID, int quantity) throws SQLException;
    void addDiscount(int orderDetailID, Double discount) throws SQLException;
    public void deleteOrderDetailsByOrderId(int orderID) throws SQLException;
	
}