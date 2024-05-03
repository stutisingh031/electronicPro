package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.model.*;

import com.service.CustomerService;

public class CustomerController {
	  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
	  CustomerService cs=new CustomerService();
		while(true) {
			System.out.println("----------Customer Menu------------"); // MAIN MENU
			System.out.println("Press 1. Get all customer");
			System.out.println("Press 2. Calculate total orders of a particular customer");
			System.out.println("Press 3. Get Customer Details");
			System.out.println("Press 4. Update customer info");
			System.out.println("Press 0. EXIT");
			int input = sc.nextInt(); // INPUT FROM USER
			
			if(input == 0) { // FOR EXITING
				System.out.println("Logging out");
				break;
			}
			
			switch(input) {
			case 1:
	            try {
					List<Customer> list= cs.getAllCustomers();
					for(Customer c:list) {
						System.out.println(c.getFirstName());
						System.out.println(c.getLastName());
						System.out.println(c.getEmail());
						System.out.println(c.getPhone());
						System.out.println(c.getAddress());
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2:
				 try {
				        List<Customer> customers = cs.getAllCustomers();
				        if(customers.isEmpty()) {
				            System.out.println("No customers found.");
				        } else {
				            System.out.println("All Customers:");
				            for(Customer customer : customers) {
				                System.out.println(customer.getCustomerID() + ": " + customer.getFirstName() + " " + customer.getLastName());
				            }
				            System.out.println("Enter customer ID:");
				            int customerId = sc.nextInt();
				            int totalOrders = cs.calculateTotalOrders(customerId);
				            System.out.println("Total orders for customer " + customerId + ": " + totalOrders);
				        }
				    } catch (SQLException e) {
				        System.out.println(e.getMessage());
				    }
				    break;
	
				
			case 3:
				try {
			        System.out.println("Enter customer ID:");
			        int customerId = sc.nextInt();
			        Customer customer = cs.getCustomerDetails(customerId);
			        if (customer != null) {
			            System.out.println("Customer Details:");
			            System.out.println(customer);
			        } else {
			            System.out.println("Customer not found with ID: " + customerId);
			        }
			    } catch (SQLException e) {
			        System.out.println(e.getMessage());
			    }
			    break;
				
			case 4:
                 try { 
                	   System.out.println("Update your profile");
                	   System.out.println("Enter your customer id");
                	   int id=sc.nextInt();
                	   System.out.println("Enter your email");
                	   sc.nextLine();
                       String email=sc.nextLine();
          
                	   System.out.println("Enter your phone no");
                	   String phone=sc.nextLine();
                	   System.out.println("Enter your address");
                	   String address=sc.nextLine();
					   cs.updateCustomerInfo(id, email, phone, address);
					   System.out.println("updated");
				} catch (Exception e) {
					
				}
				break;
				
				
			default:
				System.out.println("Invalid Input");
				break;
			}			
		}
		sc.close();
    

	}
	public static void customerMenu() {
		String[] menu= {""};
		main(menu);
	}
		
	}

	



