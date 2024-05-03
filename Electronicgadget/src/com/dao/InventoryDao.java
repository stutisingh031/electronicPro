package com.dao;

import java.sql.SQLException;
import java.util.List;
import com.model.Inventory;
public interface InventoryDao {
	int addToInventory(int inventoryID, int quantityToAdd) throws SQLException;
   
    int updateStockQuantity(int inventoryID, int newQuantity)throws SQLException;
    boolean isProductAvailable(int inventoryID, int quantityToCheck)throws SQLException;
    List<Inventory> listLowStockProducts(int threshold)throws SQLException;
    List<Inventory> listOutOfStockProducts()throws SQLException;
}
