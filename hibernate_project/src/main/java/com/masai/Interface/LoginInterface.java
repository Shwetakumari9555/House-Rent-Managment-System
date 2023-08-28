package com.masai.Interface;

import java.util.Scanner;

import com.masai.ui.LoginUi;

public class LoginInterface {
    public static void loginInterface() {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println();
            System.out.println();

            System.out.println(ConsoleColours.BLUE + "1. Owner Login" + ConsoleColours.RESET);
            System.out.println(ConsoleColours.BLUE + "2. Tenant Login" + ConsoleColours.RESET);
            System.out.println(ConsoleColours.BLUE + "3. Back to Main Menu" + ConsoleColours.RESET);

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                	LoginUi.LoginAsOwner(scanner);
                	
                    break;
                case 2:
                	LoginUi.LoginAsTenant(scanner);
                    break;
                case 3:
                    System.out.println("Returning to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }

        } while (choice != 3);

        scanner.close();
    }

	
}
