package com.service;

import java.sql.SQLException;

import com.dao.OrderDetailsDao;
import com.dao.OrderDetailsDaoImpl;

public class OrderDetailsService {
	OrderDetailsDao dao= new OrderDetailsDaoImpl();
	public double calculateSubtotal(int orderDetailID) throws SQLException {
		return dao.calculateSubtotal(orderDetailID);
	}
	public void updateQuantity(int orderDetailID, int quantity) throws SQLException{
         dao.updateQuantity(orderDetailID, quantity);
	}
	public  void deleteOrderDetailsByOrderId(int orderID)throws SQLException {
		// TODO Auto-generated method stub
		dao.deleteOrderDetailsByOrderId(orderID);
		
	}
	