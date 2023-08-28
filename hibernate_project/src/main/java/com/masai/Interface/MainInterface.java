package com.masai.Interface;

import java.util.Scanner;

import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;

public class MainInterface {
    public static void main(String[] args) throws SomethingWentWrongException, NoRecordFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ConsoleColours.PURPLE_ITALIC + "--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*");
        System.out.println("            Welcome to HOUSE RENT HUB");
        System.out.println("           \"Where Home Meets Heart: Your Ideal House, Just a Click Away.\"");
        System.out.println("--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*--*"+ ConsoleColours.RESET);

        int choice;

        do {
            System.out.println();
            System.out.println("House Rent Hub is a user-friendly online platform that simplifies house rental processes.");
            System.out.println("Property owners can list their properties, while tenants can explore listings, apply, and more.");
            System.out.println();
            System.out.println("Select an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    LoginInterface.loginInterface(); // Call the loginInterface method
                    break;
                case 2:
                	Register.registerInterface(); 
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
            
        } while (choice != 3);

        scanner.close();
    }
}
