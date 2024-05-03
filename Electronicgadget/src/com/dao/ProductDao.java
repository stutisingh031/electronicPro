package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Customer;
import com.model.Product;


public interface   ProductDao {
	int addProduct(Product product) throws SQLException;
    void deleteProduct(int productID) throws SQLException;
    Product getProductDetails(int productID) throws SQLException,ProductNotFoundException;
    void updateProductInfo(int productID, String productName, String description, double price) throws SQLException;
    boolean isProductInStock(int productID) throws SQLException;
	}
