package com.service;

import java.sql.SQLException;

import com.dao.OrdersDao;
import com.dao.OrdersDaoImpl;
import com.model.Orders;

public class OrdersService {
   OrdersDao dao= new OrdersDaoImpl();
	public double calculateTotalAmount(int orderID) throws SQLException {
		return dao.calculateTotalAmount(orderID);
	}
	public Orders getOrderDetails(int orderID) throws SQLException {
		return dao.getOrderDetails(orderID);
	}
	public void cancelOrder(int orderID) throws SQLException {
		dao.cancelOrder(orderID);
	}
}