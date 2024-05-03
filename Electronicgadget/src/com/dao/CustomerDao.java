package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Customer;

public interface   CustomerDao {
	   int addCustomer(Customer customer) throws SQLException;
	    void deleteCustomer(int customerID) throws SQLException;
	    List<Customer> getAllCustomers() throws SQLException;
	    int calculateTotalOrders(int customerID) throws SQLException;
	    Customer getCustomerDetails(int customerID) throws SQLException;
	}

