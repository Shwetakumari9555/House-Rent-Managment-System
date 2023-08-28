package com.masai.ui;

import java.util.Scanner;

import com.masai.Exception.SomethingWentWrongException;
import com.masai.Interface.ConsoleColours;
import com.masaischool.util.EMUtil;


import jakarta.persistence.EntityManager;

public class MainUi {
	

	
public static void main(String[] args) throws SomethingWentWrongException {
	Scanner sc = new Scanner(System.in);
	EntityManager em = EMUtil.getConnection();
	
	
	
	
	
			
	
	 System.out.println(ConsoleColours.PURPLE_ITALIC+"--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*");
     System.out.println("           	Welcome to HOUSE RENT HUB");
     System.out.println("           \"Where Home Meets Heart: Your Ideal House, Just a Click Away.\"");
     System.out.println("--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*"+ConsoleColours.RESET);
     
     System.out.println();
     System.out.println();
     System.out.println("House Rent Hub is a user-friendly online platform that simplifies house rental processes. Property owners can list their properties, while tenants can explore listings, apply,");
     
     int choice = 0;
     do {
    	 
    	
     System.out.println();
     System.out.println();
     
     	
     
     System.out.println(ConsoleColours.BLUE+"1. OwnerLogin"+ConsoleColours.RESET);
     System.out.println(ConsoleColours.BLUE+"2. TenantLogin"+ConsoleColours.RESET);
     System.out.println(ConsoleColours.BLUE+"3. OwnerRegister"+ConsoleColours.RESET);
     System.out.println(ConsoleColours.BLUE+"4. TenantRegister"+ConsoleColours.RESET);
     System.out.println(ConsoleColours.RED+"0. Exit \n"+ConsoleColours.RESET);
     
     System.out.println(ConsoleColours.BLUE_BACKGROUND_BRIGHT+"Select the key"+ConsoleColours.RESET);
	
     	choice = sc.nextInt();
     	switch(choice){
     		case 1:LoginUi.LoginAsOwner(sc);
     			break;
     		case 2: LoginUi.LoginAsTenant(sc);
     			break;
     		case 3: RegisterUI.RegsiterAsOwner(sc);
     			break;
     		case 4: RegisterUI.RegsiterAsTenant(sc);
     			break;	
     		case 0: System.out.println(ConsoleColours.BANANA_YELLOW+"Thanks for using the services"+ConsoleColours.RESET);
			break;
     		default:
				System.out.println(ConsoleColours.RED_BACKGROUND_BRIGHT+"Invalid Selection, try again"+ConsoleColours.RESET);
     	}
     	
     	
    	 
     
     }while(choice!=0);
     sc.close();
}





	}
	

