package com.dao;

import java.sql.SQLException;

import com.model.Orders;

public interface OrdersDao {
	    double calculateTotalAmount(int orderID) throws SQLException;
	    Orders getOrderDetails(int orderID) throws SQLException;

	    void cancelOrder(int orderID) throws SQLException;
}




