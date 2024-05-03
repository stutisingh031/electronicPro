package com.service;
import java.sql.SQLException;
import java.util.List;

import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.model.Product;



public class ProductService {
	ProductDao  productDao = new ProductDaoImpl();
	
	public List<Product> showProduct(int productId) throws SQLException {
		// TODO Auto-generated method stub
		return productDao.getAllProductByProductId(productId);	
}
}
