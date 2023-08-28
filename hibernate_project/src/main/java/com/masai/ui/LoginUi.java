package com.masai.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;
import com.masai.Interface.OwnerInterface;
import com.masai.service.ClassService;
import com.masai.service.ClassServiceImplementation;

public class LoginUi {
		public static void LoginAsOwner(Scanner sc) {
			System.out.println("------------------------------------------------------");
	        System.out.println("                    Landlord Login");
	        System.out.println("------------------------------------------------------");
	        
	        System.out.print("Username: ");
	        String username = sc.nextLine();

	        System.out.print("Password: ");
	        String password = sc.nextLine();
	        
	        try {
	        	ClassService classService = new ClassServiceImplementation();
	        	classService.LoginAsOwner(username,password);
	        	System.out.println("Login Successfully");
	        	//tenantMenu
	        	OwnerInterface.main(new String[0]);
	        }catch (SomethingWentWrongException | NoRecordFoundException e) {
				System.out.println(e.getMessage());
			}
	        
	        
	        
		}
		
		public static void LoginAsTenant(Scanner sc) {
			System.out.println("------------------------------------------------------");
	        System.out.println("                    Tenant Login");
	        System.out.println("------------------------------------------------------");
	        
	        System.out.print("Username: ");
	        String username = sc.nextLine();

	        System.out.print("Password: ");
	        String password = sc.nextLine();
	        
	        try {
	        	ClassService classService = new ClassServiceImplementation();
	        	classService.LoginAsTenant(username,password);
	        	System.out.println("Login Successfully");
	        	
	        	
	        }catch (SomethingWentWrongException | NoRecordFoundException e) {
				System.out.println(e.getMessage());
			}
	        
		}
		
		public static void ChangePassword(Scanner sc) {
			System.out.println("Enter Old - Password");
			String oldpassword = sc.next();
			System.out.println("Enter New- Password");
			String newPassword = sc.next();
			System.out.println("Re-Enter New-Password");
			String reEnterPassword = sc.next();
			
			if(!newPassword.equals(reEnterPassword)) {
				System.out.println("Enter Correct Password . Password Mis-Match");
				
			}else if(newPassword.equals(oldpassword)) {
				System.out.println("Old Password and New Password Must Be Different");
				return;
			}
			try {
				ClassService classService = new ClassServiceImplementation();
				classService.changePassword(oldpassword, reEnterPassword);
				System.out.println("Password Updated Successfully");
				
			}catch (SomethingWentWrongException | NoRecordFoundException e) {
				System.out.println(e.getMessage());
			}
		}
		
		public static void DeleteAccount(Scanner sc) {
		    System.out.println("Are you sure you want to delete your account? [Y/N] ");
		    char choice = sc.next().toLowerCase().charAt(0);

		    if (choice == 'y') {
		        try {
		            System.out.println("Proceeding to delete your account...");
		            System.out.print("Enter your account ID: ");
		            int id = sc.nextInt();

		            
		            if (id > 0) {
		                ClassService classService = new ClassServiceImplementation();
		                classService.DeleteAccount(id);
		                System.out.println("Your account has been deleted successfully.");
		            } else {
		                System.out.println("Invalid account ID.");
		            }
		        } catch (InputMismatchException e) {
		            System.out.println("Invalid input. Please enter a valid account ID.");
		            sc.nextLine();
		        } catch (SomethingWentWrongException e) {
		            System.out.println(e.getMessage());
		        }
		    } else if (choice == 'n') {
		        System.out.println("Account deletion cancelled.");
		    } else {
		        System.out.println("Invalid choice. Please enter 'Y' or 'N'.");
		    }
		}
		
	public static void DeletPropertyById(Scanner sc) {
		System.out.println("Enter id of the Property");
		int id = sc.nextInt();
		
		ClassService classService= new ClassServiceImplementation();
		try {
			classService.DeletPropertyById(id);
			System.out.println("Property Deleted Successfully");
			
		}catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}

			
			
			
		}
		
		


