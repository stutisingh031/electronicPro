package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public int addCustomer(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO Customer( first_name, last_name, email, Phone, address) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		//attach the data
		pstmt.setString(1, customer.getFirstName());
        pstmt.setString(2, customer.getLastName());
        pstmt.setString(3, customer.getEmail());
        pstmt.setString(4, customer.getPhone());
        pstmt.setString(5, customer.getAddress());
		//execute the query 
		int status = pstmt.executeUpdate(); //1: if all good., 0 - if op fails 
		DBConnection.dbClose();
		return status;
		
		
	}


	@Override
	public void deleteCustomer(int customerID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="DELETE FROM Customer WHERE id=?";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerID);
		pstmt.executeUpdate();
		DBConnection.dbClose();
		
	}

	@Override
	public List<Customer> getAllCustomers() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT * FROM Customer";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Customer> list = new ArrayList<>();
		while(rst.next() == true) {
			int id  = rst.getInt("id");
			String firstName = rst.getString("first_name");
	        String lastName = rst.getString("last_name");
	        String email = rst.getString("email");
	        String phone = rst.getString("Phone");
	        String address = rst.getString("address");
	        Customer customer = new Customer(id, firstName, lastName, email, phone, address); //100X 200X 300X
			list.add(customer);
		}
		DBConnection.dbClose();		
		return list;
	}

	@Override
	public int calculateTotalOrders(int customerID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT COUNT(*) AS TotalOrders FROM Orders WHERE customer_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerID);
		ResultSet rst = pstmt.executeQuery();
		if(rst.next()) {
			return rst.getInt("TotalOrders");
		}
		DBConnection.dbClose();	
		return 0;

	}

	@Override
	public Customer getCustomerDetails(int customerID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT * FROM Customer WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerID);
		ResultSet rst  = pstmt.executeQuery();
		Customer c1=new Customer();
		if(rst.next()) {
			c1.setFirstName(rst.getString("first_name"));
			c1.setLastName(rst.getString("last_name"));
			c1.setEmail(rst.getString("email"));
			c1.setPhone(rst.getString("Phone"));
			c1.setAddress(rst.getString("address"));
		}
		
		DBConnection.dbClose();
		return c1;
	}
}
