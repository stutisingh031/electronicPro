package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.ProductNotFoundException;
import com.model.Product;
import com.utility.DBConnection;

public class ProductDaoImpl implements ProductDao{

	@Override
	public int addProduct(Product product) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO Product (product_name, description, price) VALUES (?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		//attach the data
		pstmt.setString(1, product.getProductName());
        pstmt.setString(2, product.getDescription());
        pstmt.setDouble(3, product.getPrice());
       
		int status = pstmt.executeUpdate(); //1: if all good., 0 - if op fails 
		DBConnection.dbClose();
		return status;
	}

	@Override
	public void deleteProduct(int productID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="DELETE FROM Product WHERE id=?";
		//prepare the statement 
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productID);
		pstmt.executeUpdate();
		DBConnection.dbClose();
		
	}

	@Override
	public Product getProductDetails(int productID) throws SQLException,ProductNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT * FROM Product WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productID);
		ResultSet rst  = pstmt.executeQuery();
		Product p1 =new Product();
		if(rst.next()) {
			p1.setProductID(rst.getInt("id"));
			p1.setProductName(rst.getString("product_name"));
			p1.setPrice(rst.getDouble("price"));
			p1.setDescription(rst.getString("description"));
		}
		
		DBConnection.dbClose();
		return p1;
		
	}

	@Override
	public void updateProductInfo(int productID, String productName, String description, double price)
			throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="UPDATE Product SET product_name=?, description=?, price=? WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, productName);
        pstmt.setString(2, description);
        pstmt.setDouble(3, price);
        pstmt.setInt(4, productID);
        pstmt.executeUpdate();
		DBConnection.dbClose();	
		
	}

	@Override
	public boolean isProductInStock(int productID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql= "SELECT COUNT(*) AS StockCount FROM inventory WHERE Product_id=? AND quantity_in_stock > 0";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,productID);
		ResultSet rst  = pstmt.executeQuery();
		boolean status =rst.next();
		return status;
	}

}



