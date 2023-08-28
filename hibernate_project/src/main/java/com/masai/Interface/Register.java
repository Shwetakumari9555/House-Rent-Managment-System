package com.masai.Interface;

import java.util.Scanner;

import com.masai.Exception.SomethingWentWrongException;
import com.masai.ui.RegisterUI;

public class Register {
    public static void registerInterface() throws SomethingWentWrongException {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println();
            System.out.println();

            System.out.println(ConsoleColours.BLUE + "1. Owner Register" + ConsoleColours.RESET);
            System.out.println(ConsoleColours.BLUE + "2. Tenant Register" + ConsoleColours.RESET);
            System.out.println(ConsoleColours.BLUE + "3. Back to Main Menu" + ConsoleColours.RESET);

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                	RegisterUI.RegsiterAsOwner(scanner);
                    break;
                case 2:
                	RegisterUI.RegsiterAsTenant(scanner);
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
