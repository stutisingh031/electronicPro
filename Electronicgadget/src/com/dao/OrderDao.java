package com.dao;

import java.sql.SQLException;

import com.model.Orders;

public interface OrderDao {
	double calculateTotalAmount(int orderId)throws SQLException;
	Orders getOrderDetails(int orderId)throws SQLException;
	boolean updateOrderStatus(Orders updatedOrder)throws SQLException;
	boolean cancelOrder(int orderId)throws SQLException;
}