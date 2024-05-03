package com.controller;

import java.sql.SQLException;
import com.exception.*;
import java.util.List;
import java.util.Scanner;

import com.exception.ProductNotFoundException;
import com.model.Customer;
import com.model.Product;
import com.service.CustomerService;
import com.service.ProductService;

public class ProductController {
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 ProductService ps=new ProductService();
		while(true) {
			System.out.println("----------Products Menu------------"); // MAIN MENU
			 System.out.println("1. Add Product");
	            System.out.println("2. Delete Product");
	            System.out.println("3. Product Details");
	            System.out.println("4. Update Product Information");
	            System.out.println("5. Check Product Availability");
	            System.out.println("0. Exit");
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out");
				break;
			}
			
			switch(input) {
			case 1:
				 try {
			            System.out.println("Enter Product Name:");
			            String productName = sc.nextLine();
			            System.out.println("Enter Description:");
			            String description = sc.nextLine();
			            System.out.println("Enter Price:");
			            double price = sc.nextDouble();

			            Product product = new Product();
			            product.setProductName(productName);
			            product.setDescription(description);
			            product.setPrice(price);

			            int rowsAffected = ps.addProduct(product);
			            if (rowsAffected > 0) {
			                System.out.println("Product added successfully.");
			            } else {
			                System.out.println("Failed to add product.");
			            }
			        } catch (SQLException e) {
			            System.out.println("Error adding product: " + e.getMessage());
			        }
				 break;
				
			case 2:
				 try {
			            System.out.println("Enter Product ID to delete:");
			            int productID = sc.nextInt();

			            ps.deleteProduct(productID);
			            System.out.println("Product deleted successfully.");
			        } catch (SQLException e) {
			            System.out.println("Error deleting product: " + e.getMessage());
			        }
				    break;
	
				
			case 3:
				 try {
			            System.out.println("Enter Product ID:");
			            int productID = sc.nextInt();

			            Product product = ps.getProductDetails(productID);
			           
			                System.out.println("Product Details:");
			                System.out.println(product);
			           
			            }
			        catch (SQLException e) {
			            System.out.println("Error getting product details: " + e.getMessage());
			        }
				    catch(ProductNotFoundException e) {
				    	System.out.println("Product not found");
				    }
				 
			    break;
				
			case 4:
				 try {
			            System.out.println("Enter Product ID to update:");
			            int productID = sc.nextInt();
			            sc.nextLine();
			            System.out.println("Enter New Product Name:");
			            String productName = sc.nextLine();
			            System.out.println("Enter New Description:");
			            String description = sc.nextLine();
			            System.out.println("Enter New Price:");
			            double price = sc.nextDouble();

			            ps.updateProductInfo(productID, productName, description, price);
			            System.out.println("Product info updated successfully.");
			        } catch (SQLException e) {
			            System.out.println("Error updating product info: " + e.getMessage());
			        }
				
				break;
				
			case 5:
				 try {
			            System.out.println("Enter Product ID:");
			            int productID = sc.nextInt();

			            boolean available = ps.isProductInStock(productID);
			            if (available) {
			                System.out.println("Product is available.");
			            } else {
			                System.out.println("Product is out of stock.");
			            }
			        } catch (SQLException e) {
			            System.out.println("Error checking product availability: " + e.getMessage());
			        }
					break;
			default:
				System.out.println("Invalid Input");
				break;
			}			
		}

}


}

