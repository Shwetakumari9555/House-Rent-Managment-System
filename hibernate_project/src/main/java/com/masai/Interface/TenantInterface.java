package com.masai.Interface;

import java.util.Scanner;

import com.masai.Exception.SomethingWentWrongException;

public class TenantInterface {
	
	public static void main(String[] args) throws SomethingWentWrongException {
		Scanner sc = new Scanner(System.in);
		
		
			System.out.println("1. Search Commercial Property");
			System.out.println("2. Search Residential Property");
			System.out.println("3. Delete Account");
			System.out.println("4. Change Password");
			System.out.println("5. Logout");
			
			
			System.out.println("0. Exit");
			System.out.println("Select an Option");
			
			
			while(true) {
				int choice = sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
				case 1: OwnerInterface.SearchCommercialProperty(sc);
//                System.out.println(ConsoleColours.GREEN_UNDERLINED+"Do you want to check more information about the property? (Y/N)"+ConsoleColours.RESET);
//                String viewMoreChoice = sc.next().toUpperCase();
//                if (viewMoreChoice.equals("Y")) {
//                	OwnerInterface.Add_Commercial_Description(sc, commercial);
//                }
                break;
					
				case 2: 
					break;
				case 3: //DeleteAccount
					break;
				case 4: //Password Chng	
					break;
				case 5: //Logout
					break;
				case 0: System.out.println("Thanks for Using our Services ! Bye- Bye");	
				System.exit(0);
				
				default:
					System.out.println("Invalid choice. Please select a valid option.");
                    break;
				}
			}
			
		
	}
	
	
	
	
	
}
