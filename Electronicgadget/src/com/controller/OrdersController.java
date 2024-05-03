package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Customer;
import com.model.Orders;
import com.service.CustomerService;
import com.service.OrderDetailsService;
import com.service.OrdersService;

public class OrdersController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  OrdersService os=new OrdersService();
		  OrderDetailsService ods= new OrderDetailsService();
			while(true) {
				System.out.println("----------Orders Menu------------"); 
				    System.out.println("1. Calculate Total Amount");
		            System.out.println("2. Get Order Details");
		            System.out.println("3. Cancel Order");
		            System.out.println("4. Calculate Subtotal");
		            System.out.println("5. Update Quantity");
		            System.out.println("0. Exit");
				int input = sc.nextInt(); // INPUT FROM USER
				
				if(input == 0) { // FOR EXITING
					System.out.println("Logging out");
					break;
				}
				
				switch(input) {
				case 1:
					 try {
				            System.out.println("Enter Order ID:");
				            int orderID = sc.nextInt();
				            double totalAmount = os.calculateTotalAmount(orderID);
				            System.out.println("Total Amount for Order ID " + orderID + ": " + totalAmount);
				        } catch (SQLException e) {
				            System.out.println("Error calculating total amount: " + e.getMessage());
				        }
					break;
					
				case 2:
					 try {
				            System.out.println("Enter Order ID:");
				            int orderID = sc.nextInt();
				            Orders order = os.getOrderDetails(orderID);
				            System.out.println("Order Details:");
				            System.out.println(order);
				        } catch (SQLException e) {
				            System.out.println("Error getting order details: " + e.getMessage());
				        }
					    break;
		
					
				case 3:
					 try {
				            System.out.println("Enter Order ID to cancel:");
				            int orderID = sc.nextInt();
				            os.cancelOrder(orderID);
				            System.out.println("Order cancelled successfully.");
				        } catch (SQLException e) {
				            System.out.println("Error cancelling order: " + e.getMessage());
				        }
				    break;
					
				case 4:
					 try {
				            System.out.println("Enter Order Detail ID:");
				            int orderDetailID = sc.nextInt();
				            double subtotal = ods.calculateSubtotal(orderDetailID);
				            System.out.println("Subtotal for Order Detail ID " + orderDetailID + ": " + subtotal);
				        } catch (SQLException e) {
				            System.out.println("Error calculating subtotal: " + e.getMessage());
				        }
					break;
					
				case 5:
					try {
			            System.out.println("Enter Order Detail ID to update quantity:");
			            int orderDetailID = sc.nextInt();
			            System.out.println("Enter New Quantity:");
			            int quantity = sc.nextInt();
			            ods.updateQuantity(orderDetailID, quantity);
			            System.out.println("Quantity updated successfully.");
			        } catch (SQLException e) {
			            System.out.println("Error updating quantity: " + e.getMessage());
			        }
					break;
				default:
					System.out.println("Invalid Input");
					break;
				}			
			}
			sc.close();

	}



}
