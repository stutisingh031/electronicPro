package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utility.DBConnection;

public class OrderDetailsDaoImpl implements OrderDetailsDao {

	@Override
	public double calculateSubtotal(int orderDetailID) throws SQLException {
		Connection con = DBConnection.dbConnect();
        String sql="SELECT quantity, Product.price FROM OrderDetails JOIN Products ON OrderDetails.Product_id = Product.id WHERE OrderDetails.id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, orderDetailID);
        ResultSet rst  = pstmt.executeQuery();
        if(rst.next()) {
        	 int quantity = rst.getInt("quantity");
             double productPrice = rst.getDouble("price");
             return productPrice * quantity;
        }
		DBConnection.dbClose();
        return 0.0;
	}

	@Override
	public String getOrderDetailInfo(int orderDetailID) throws SQLException {
		
		return null;
	}

	@Override
	public void updateQuantity(int orderDetailID, int quantity) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="UPDATE Orderdetails SET quantity=? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, quantity);
		pstmt.setInt(2, orderDetailID);
       
        pstmt.executeUpdate();
		DBConnection.dbClose();	
		
	}

	@Override
	public void addDiscount(int orderDetailID, Double discount) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderDetailsByOrderId(int orderID) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
        String sql="DELETE FROM OrderDetails WHERE orders_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, orderID);
        pstmt.executeQuery();
       
		DBConnection.dbClose();
   
		
	}

}

