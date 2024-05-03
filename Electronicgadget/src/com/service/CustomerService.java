package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.Customer;

public class CustomerService {
	CustomerDao customerdao = new CustomerDaoImpl();
	public List<Customer> showCustomer(int cusId) throws SQLException{
		return customerdao.getAllCustomerByCustomerId(cusId);
	}
	

}
