package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.InventoryDao;
import com.dao.InventoryDaoImpl;
import com.model.Inventory;

public class InventoryService {
   InventoryDao dao=new InventoryDaoImpl();
   public int addToInventory(int inventoryID, int quantityToAdd) throws SQLException{
	   return dao.addToInventory(inventoryID, quantityToAdd);
   }
   

   public int updateStockQuantity(int inventoryID, int newQuantity)throws SQLException{
	   return dao.updateStockQuantity(inventoryID, newQuantity);
   }
   public boolean isProductAvailable(int inventoryID, int quantityToCheck)throws SQLException{
	   return dao.isProductAvailable(inventoryID, quantityToCheck);
   }
   public List<Inventory> listLowStockProducts(int threshold)throws SQLException{
	   return dao.listLowStockProducts(threshold);
   }
   public List<Inventory> listOutOfStockProducts()throws SQLException{
	   return dao.listOutOfStockProducts();
   }
}

