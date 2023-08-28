package com.masai.ui;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Scanner;

import com.masai.Exception.SomethingWentWrongException;
import com.masai.Interface.ConsoleColours;
import com.masai.dao.ClassDao;
import com.masai.dao.DaoIMplementation;
import com.masai.entity.Commercial;
import com.masai.entity.Residential;
import com.masai.service.ClassService;
import com.masai.service.ClassServiceImplementation;

public class RegisterUI extends ConsoleColours{

    public static void main(String[] args) throws SomethingWentWrongException {
        Scanner scanner = new Scanner(System.in);

    }

    public static void RegsiterAsOwner(Scanner sc) throws SomethingWentWrongException {
        System.out.println(ConsoleColours.FOREST_GREEN+"------------------------------------------------------");
        System.out.println("                   Owner Register Menu");
        System.out.println("------------------------------------------------------"+ConsoleColours.RESET);

        System.out.println(ConsoleColours.ROSY_PINK_BACKGROUND+"Enter Your Full Name"+ConsoleColours.RESET);
        String name = sc.next();
        System.out.println(ConsoleColours.ROSY_PINK_BACKGROUND+"Enter Email"+ConsoleColours.RESET);
        String email = sc.next();
        
        System.out.println(ConsoleColours.ROSY_PINK_BACKGROUND+"Enter Password"+ConsoleColours.RESET);
        String password = sc.next();
        ClassService classService = new ClassServiceImplementation();
        
        System.out.print(ConsoleColours.ROSY_PINK_BACKGROUND+"Enter your date of birth (YYYY-MM-DD): "+ConsoleColours.RESET);
        String dobString = sc.next();

        LocalDate dob = LocalDate.parse(dobString);
        LocalDate currentDate = LocalDate.now();
        Period ageDifference = Period.between(dob, currentDate);
        int age = ageDifference.getYears();
        
        if (age > 18) {
            System.out.println(ConsoleColours.TEAL+"\nRegistering..."+ConsoleColours.RESET);
            // Simulate a delay
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            Owner owner = new Owner(name, dob, email, password, new HashSet<>(), new HashSet<>(), new HashSet<>());
            
            try {
                classService.Add_Owner(owner);
                System.out.println(ConsoleColours.BROWN+"Owner Added Successfully"+ConsoleColours.RESET);
            } catch (SomethingWentWrongException e) {
                System.out.println(e.getMessage());
            }
            
//            // Create and associate Commercial and Residential properties
//            Commercial commercialProperty = new Commercial(area, rent, location, status, owner); // Create Commercial instance
//            Residential residentialProperty = new Residential(area, rent, location, rooms, status, owner); // Create Residential instance
//
//            
//            // Set associations
//            commercialProperty.setOwner(owner);
//            residentialProperty.setOwner(owner);
//            
//            // Add to owner's property sets
//            owner.getCommercialProperties().add(commercialProperty);
//            owner.getResidentialProperties().add(residentialProperty);
//
//        } else {
//            System.out.println("You are " + age + " years old and not eligible to register as an owner.");
        }
    }


    
    
    public static void RegsiterAsTenant(Scanner sc) {
        System.out.println(ConsoleColours.CYAN_BACKGROUND_BRIGHT+"------------------------------------------------------");
        System.out.println("              	Tenant Register Menu");
        System.out.println("------------------------------------------------------"+ConsoleColours.RESET);

        System.out.println(ConsoleColours.ROSY_PINK_BACKGROUND+"Enter Your Full Name"+ConsoleColours.RESET);
        String name = sc.next();
        System.out.println("Enter Email");
        String email = sc.next();
        ClassDao classdao = new DaoIMplementation();
        
        
        System.out.println(ConsoleColours.ROSY_PINK_BACKGROUND+"Enter Password"+ConsoleColours.RESET);
        String password = sc.next();
        System.out.print(ConsoleColours.ROSY_PINK_BACKGROUND+"Enter your date of birth (YYYY-MM-DD): "+ConsoleColours.RESET);
        String dobString = sc.next();

        LocalDate dob = LocalDate.parse(dobString);
        LocalDate currentDate = LocalDate.now();
        Period ageDifference = Period.between(dob, currentDate);
        int age = ageDifference.getYears();

        if (age > 18) {
            
            
            System.out.println(ConsoleColours.TEAL+"\nRegistering..."+ConsoleColours.RESET);
            // Simulate a delay
            try {
                Thread.sleep(1000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            ClassService classService = new ClassServiceImplementation();
            Tenant tenant = new Tenant(name, dob, email, password);
            try {
            	classService.Add_Tenant(tenant);
            	System.out.println(ConsoleColours.BROWN+"Added tenant Successfully"+ConsoleColours.RESET);
            }catch (SomethingWentWrongException e) {
				System.out.println(e.getMessage());
			}
            
            
        } else {
            System.out.println(ConsoleColours.RED_BOLD+"You are " + age + " years old and not eligible to register as an owner."+ConsoleColours.RESET);
          
        }
    }
    
    
//    try {
//        classService.AlreadyRegisterOwner(email, password); 
//        System.out.println("User with email " + email + " is already registered.");
//        return false; // Not registered
//    } catch (NoRecordFoundException e) {
//        // Email is not already registered, continue with the registration process
//    }
    
}
