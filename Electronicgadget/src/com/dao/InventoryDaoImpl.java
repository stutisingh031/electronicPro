package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Customer;
import com.model.Inventory;
import com.utility.DBConnection;

public class InventoryDaoImpl implements InventoryDao{

	@Override
	public int addToInventory(int inventoryID, int quantityToAdd) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql="Update inventory set quantity_in_stock =quantity_in_stock + ? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, quantityToAdd);
		pstmt.setInt(2, inventoryID);
		int status= pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
		
		
	}



	@Override
	public int updateStockQuantity(int inventoryID, int newQuantity)throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="Update inventory set quantity_in_stock = ? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, newQuantity);
		pstmt.setInt(2, inventoryID);
		int status= pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
		
	}

	@Override
	public boolean isProductAvailable(int inventoryID, int quantityToCheck)throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql= "SELECT quantity_in_stock FROM inventory WHERE id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,inventoryID);
		ResultSet rst  = pstmt.executeQuery();
		boolean isAvailable = false;
		 if (rst.next()) {
             int quantityInStock = rst.getInt("quantity_in_stock");
             isAvailable = quantityInStock >= quantityToCheck;
         }
			DBConnection.dbClose();
		return isAvailable;
	}

	@Override
	public List<Inventory> listLowStockProducts(int threshold)throws SQLException {
		Connection con = DBConnection.dbConnect();
		String query = "SELECT * FROM inventory WHERE quantity_in_stock < ?";
        PreparedStatement pstmt= con.prepareStatement(query);
        pstmt.setInt(1, threshold);
        ResultSet rst = pstmt.executeQuery();
        List<Inventory> list = new ArrayList<>();
        while(rst.next() == true) {
			int id  = rst.getInt("id");
			int StockQuantity = rst.getInt("quantity_in_stock");
			double lastUpdate = rst.getDouble("last_stock_update");
			int Productid = rst.getInt("Product_id");
	        Inventory inventory= new Inventory(id, StockQuantity, Productid,lastUpdate);
			list.add(inventory);
		}
		DBConnection.dbClose();		
		return list;
	}

	@Override
	public List<Inventory> listOutOfStockProducts()throws SQLException {
		Connection con = DBConnection.dbConnect();
		String query = "SELECT * FROM inventory WHERE quantity_in_stock =0";
        PreparedStatement pstmt= con.prepareStatement(query);
        ResultSet rst = pstmt.executeQuery();
        List<Inventory> list = new ArrayList<>();
        while(rst.next() == true) {
			int id  = rst.getInt("id");
			int StockQuantity = rst.getInt("quantity_in_stock");
			double lastUpdate = rst.getDouble("last_stock_update");
			int Productid = rst.getInt("Product_id");
	        Inventory inventory= new Inventory(id, StockQuantity, Productid,lastUpdate);
			list.add(inventory);
		}
		DBConnection.dbClose();		
		return list;
	}

}
