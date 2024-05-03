package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Customer;
import com.model.Inventory;
import com.service.CustomerService;
import com.service.InventoryService;

public class InventoryController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InventoryService is=new InventoryService();
			while(true) {
				System.out.println("----------Inventory Menu------------"); // MAIN MENU
				System.out.println("Press 1. Add to Inventory");
				System.out.println("Press 2. List Low Stock Products");
				System.out.println("Press 3. List Out of Stock Products");
				System.out.println("Press 4. is product Available");
				System.out.println("Press 0. EXIT");
				int input = sc.nextInt(); // INPUT FROM USER
				
				if(input == 0) { // FOR EXITING
					System.out.println("Logging out");
					break;
				}
				
				switch(input) {
				case 1:
					 try {
				            System.out.println("Enter Inventory ID to Add Quantity:");
				            int inventoryID = sc.nextInt();
				            System.out.println("Enter Quantity to Add:");
				            int quantityToAdd = sc.nextInt();
				            sc.nextLine();

				            is.addToInventory(inventoryID, quantityToAdd);
				            System.out.println("Quantity added to inventory successfully.");
				        } catch (Exception e) {
				            System.out.println("Error adding quantity to inventory: " + e.getMessage());
				        }
				
					break;
					
				
		
					
				case 2:
					 try {
				            System.out.println("Enter Threshold for Low Stock:");
				            int threshold = sc.nextInt();
				            sc.nextLine(); // Consume newline character

				            List<Inventory> lowStockProducts = is.listLowStockProducts(threshold);
				            if (lowStockProducts.isEmpty()) {
				                System.out.println("No low stock products found.");
				            } else {
				                System.out.println("Low Stock Products:");
				                for (Inventory inventory : lowStockProducts) {
				                    System.out.println(inventory);
				                }
				            }
				        } catch (Exception e) {
				            System.out.println("Error listing low stock products: " + e.getMessage());
				        }
				    break;
					
				case 3:
					try {
			            List<Inventory> outOfStockProducts = is.listOutOfStockProducts();
			            if (outOfStockProducts.isEmpty()) {
			                System.out.println("No out of stock products found.");
			            } else {
			                System.out.println("Out of Stock Products:");
			                for (Inventory inventory : outOfStockProducts) {
			                    System.out.println(inventory);
			                }
			            }
			        } catch (Exception e) {
			            System.out.println("Error listing out of stock products: " + e.getMessage());
			        }
					break;
					
				case 4:
					try {
			            System.out.println("Enter Inventory ID:");
			            int inventoryID = sc.nextInt();
			            System.out.println("Enter Quantity to Check:");
			            int quantityToCheck = sc.nextInt();
			            sc.nextLine(); 

			            boolean available = is.isProductAvailable(inventoryID, quantityToCheck);
			            if (available) {
			                System.out.println("Product is available in the inventory.");
			            } else {
			                System.out.println("Product is not available in the inventory.");
			            }
			        } catch (Exception e) {
			            System.out.println("Error checking product availability: " + e.getMessage());
			        }
					break;
				default:
					System.out.println("Invalid Input");
					break;
				}			
			}
	    

	}

	public static void InventoryMenu() {
		String[] menu= {""};
		main(menu);
		
	}

}
