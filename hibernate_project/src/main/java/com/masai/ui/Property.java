package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;
import com.masai.Interface.ConsoleColours;
import com.masai.entity.AvailableStatus;
import com.masai.entity.Commercial;
import com.masai.entity.PropertyDescription;
import com.masai.entity.Residential;
import com.masai.service.ClassService;
import com.masai.service.ClassServiceImplementation;

public class Property {
	
	public static void main(String[] args) throws SomethingWentWrongException {
		Scanner sc = new Scanner(System.in);
		
		

	        while (true) {
	            System.out.println(ConsoleColours.CYAN_BOLD+"Choose an option:"+ConsoleColours.RESET);
	            System.out.println("C - Add Commercium Property"+ConsoleColours.RESET);
	            System.out.println("R - Add Residential Property"+ConsoleColours.RESET);
	            System.out.println("U - Update Property"+ConsoleColours.RESET);
	            System.out.println("P - Search Commercial Property"+ConsoleColours.RESET);
	            System.out.println("D - Search Residential Property"+ConsoleColours.RESET);
	            
	            
	            System.out.println(ConsoleColours.CYAN_BOLD+"Q - Quit"+ConsoleColours.RESET);
	            System.out.print(ConsoleColours.BLUE_BACKGROUND_BRIGHT+"Enter your choice: "+ConsoleColours.RESET);
	            String choice = sc.next().toUpperCase();

	            switch (choice) {
	                case "C":
//	                    Add_Commercium(sc);
	                    Commercial commercial = Add_Commercium(sc);
	                    System.out.println(ConsoleColours.GREEN_UNDERLINED+"Do you want to add more information about the property? (Y/N)"+ConsoleColours.RESET);
	                    String addMoreChoice = sc.next().toUpperCase();
	                    if (addMoreChoice.equals("Y")) {
	                    	Add_Commercial_Description(sc, commercial);
	                    }
	                    
	                    break;
	                case "R":
	                    Add_Residential(sc);
	                    break;
	                case "U":
	                	UpdatePropertyDetails(sc);
	                    break;
	                case "P":
	                    SearchCommercialProperty(sc);
	                    System.out.println(ConsoleColours.GREEN_UNDERLINED+"Do you want to check more information about the property? (Y/N)"+ConsoleColours.RESET);
	                    String viewMoreChoice = sc.next().toUpperCase();
	                    if (viewMoreChoice.equals("Y")) {
//	                        ViewCommercialDescription(sc);
	                    }
	                    break;
	                    
	                case "D":
	                	SearchResidentialProperty(sc);
	                	System.out.println(ConsoleColours.GREEN_UNDERLINED+"Do you want to check more information about the property? (Y/N)"+ConsoleColours.RESET);
	                    String viewMoreChoice1 = sc.next().toUpperCase();
	                    if (viewMoreChoice1.equals("Y")) {
                 
	                    }
	                	
	                    break;    
	                case "Q":
	                    System.out.println(ConsoleColours.YELLOW_BOLD_BRIGHT+"Thank you for using the system. Goodbye!"+ConsoleColours.RESET);
	                    sc.close();
	                    System.exit(0);
	                default:
	                    System.out.println(ConsoleColours.RED_BACKGROUND_BRIGHT+"Invalid choice. Please choose a valid option."+ConsoleColours.RESET);
	            
	            }
	        }
	    }
	
	public static Commercial Add_Commercium (Scanner sc) {
		System.out.println(ConsoleColours.BLUE_BOLD+"Adding a commercium Property"+ConsoleColours.RESET);
		sc.nextLine();
		System.out.print(ConsoleColours.BLUE+"Enter area: "+ConsoleColours.RESET);
        double area = sc.nextDouble();
        System.out.print(ConsoleColours.BLUE+"Enter rent: ");
        double rent = sc.nextDouble();
        System.out.print(ConsoleColours.BLUE+"Enter location: ");
        String location = sc.next();
        System.out.print(ConsoleColours.BLUE+"Enter availability status (AVAILABLE/NOT_AVAILABLE): ");
        AvailableStatus status = AvailableStatus.valueOf(sc.next());
        sc.nextLine();
       
        
        Commercial commercium = new Commercial(area, rent, location, status);
        
        ClassService classService = new ClassServiceImplementation();
        
        try {
            classService.Add_Commercial(commercium);
            System.out.println("Commercium property added successfully!");
            
        } catch (SomethingWentWrongException e) {
            System.out.println("Error while adding Commercium: " + e.getMessage());
        }
		return commercium;
    }
	
	public static void Add_Residential (Scanner sc) {
		System.out.println("Adding a Residential property");
        System.out.print(ConsoleColours.BLUE+"Enter area: "+ConsoleColours.RESET);
        String area = sc.next();
        System.out.print(ConsoleColours.BLUE+"Enter rent: "+ConsoleColours.RESET);
        double rent = sc.nextDouble();
        System.out.print(ConsoleColours.BLUE+"Enter location: "+ConsoleColours.RESET);
        String location = sc.next();
        System.out.print(ConsoleColours.BLUE+"Enter number of rooms: "+ConsoleColours.RESET);
        int rooms = sc.nextInt();
        System.out.print("Enter availability status (AVAILABLE/NOT_AVAILABLE): "+ConsoleColours.RESET);
        AvailableStatus status = AvailableStatus.valueOf(sc.next());
        
        Residential residential = new Residential( area, rent, location, rooms, status);
        
        ClassService classService = new ClassServiceImplementation();
        
        try {
            classService.Add_Residential (residential);
            System.out.println(ConsoleColours.PURPLE_UNDERLINED+"Residential property added successfully!"+ConsoleColours.RESET);
        } catch (SomethingWentWrongException e) {
            System.out.println(ConsoleColours.RED_BACKGROUND_BRIGHT+"Error while adding Residential: " + e.getMessage()+ConsoleColours.RESET);
        }
    }
	
	public static void UpdatePropertyDetails(Scanner sc) {
		
		System.out.println(ConsoleColours.LIGHT_PINK+"Enter property ID: "+ConsoleColours.RESET);
		long propertyId = sc.nextLong();
		System.out.println(ConsoleColours.LIGHT_PINK+"Enter New Rent :");
		double rent = sc.nextDouble();
		System.out.print(ConsoleColours.LIGHT_PINK+"Enter Updated availability status (AVAILABLE/NOT_AVAILABLE): "+ConsoleColours.RESET);
        AvailableStatus status = AvailableStatus.valueOf(sc.next());
        
        ClassService classService = new ClassServiceImplementation();
        try {
        	classService.UpdateProperty(propertyId, rent, status);
        	System.out.println(ConsoleColours.GREEN+"Property has been Updated Successfully"+ConsoleColours.RESET);
        	
        }catch (NoRecordFoundException | SomethingWentWrongException e) {
        	System.out.println("Error While Updating Property Details" +e.getMessage());
			
		}
		
	}
	
	public static void SearchCommercialProperty(Scanner sc) throws SomethingWentWrongException {
	    System.out.println(ConsoleColours.ORANGE+"Search Commercial Properties"+ConsoleColours.RESET );
	    System.out.print(ConsoleColours.PURPLE+"Enter location: "+ConsoleColours.RESET );
	    String location = sc.next();
	    System.out.print(ConsoleColours.PURPLE+"Enter minimum rent amount: "+ConsoleColours.RESET );
	    double minRentAmount = sc.nextDouble();
	    System.out.print(ConsoleColours.PURPLE+"Enter maximum rent amount: "+ConsoleColours.RESET );
	    double maxRentAmount = sc.nextDouble();

	    ClassService classService = new ClassServiceImplementation();

	    try {
	        List<Commercial> commercialProperties = classService.searchCommercialProperties(location, minRentAmount, maxRentAmount);
	        System.out.println(ConsoleColours.GREEN+"Matching Commercial Properties:"+ConsoleColours.RESET);
	        for (Commercial property : commercialProperties) {
	            System.out.println(property);
	        }
	        
	        System.out.println("Submit ");
	        
	        System.out.println("do you want to offer [Y]/[N]");
	        String st = sc.next();
	        if(st.equals("Y"))
	        {
	        	System.out.println("Enter Property Id");
	        	int id = sc.nextInt();
	        	System.out.println("Enter Offer amount");
	        	double amount = sc.nextDouble();
	        	
	        	classService.submitOffer(id, amount,"Commercial");
//	        	classService.submitOffer(id, amount,"Residential");  //repeat
	        	
	        }
	        
	    } catch (NoRecordFoundException e) {
	        System.out.println("No commercial properties found matching the criteria.");
	    }
	    
	    
	}
	
	
	
//	public static void offer(Scanner sc)
//	{
//		   System.out.println("Enter Amount");
//		   int amount  = sc.nextInt();
//		   
//				   
//		   
//
//		    ClassService classService = new ClassServiceImplementation();
//
//		    try {
//		        List<Commercial> commercialProperties = classService.searchCommercialProperties(location, minRentAmount, maxRentAmount);
//		        System.out.println("Matching Commercial Properties:");
//		        for (Commercial property : commercialProperties) {
//		            System.out.println(property);
//		        }
//		        
//		        System.out.println("Submit ");
//		        
//		        System.out.println("do you want to offer [Y]/[N]");
//		        String st = sc.next();
//		        if(st.equals("Y"))
//		        {
//		        	offer(sc);
//		        }
//		        
//		    } catch (NoRecordFoundException e) {
//		        System.out.println("No commercial properties found matching the criteria.");
//		    }
//		
//		
//	}
	

	public static void SearchResidentialProperty(Scanner sc) throws SomethingWentWrongException {
	    System.out.println(ConsoleColours.ORANGE+"Search Residential Properties"+ConsoleColours.RESET);
	    sc.nextLine(); // Consume newline character
	    System.out.print(ConsoleColours.PURPLE+"Enter location: "+ConsoleColours.RESET);
	    String location = sc.nextLine();
	    System.out.print(ConsoleColours.PURPLE+"Enter minimum rent amount: "+ConsoleColours.RESET);
	    double minRentAmount = sc.nextDouble();
	    System.out.print(ConsoleColours.PURPLE+"Enter maximum rent amount: "+ConsoleColours.RESET);
	    double maxRentAmount = sc.nextDouble();

	    ClassService classService = new ClassServiceImplementation();

	    try {
	        List<Residential> residentialProperties = classService.searchResidentialProperties(location, minRentAmount, maxRentAmount);
	        System.out.println("Matching Residential Properties:"+ConsoleColours.RESET);
	        for (Residential property : residentialProperties) {
	            System.out.println(property);
	        }
	    } catch (NoRecordFoundException e) {
	        System.out.println(ConsoleColours.GREEN+"No Residential properties found matching the criteria."+ConsoleColours.RESET);
	    }
	}
	
	private static void Add_Commercial_Description(Scanner sc, Commercial commercial) throws SomethingWentWrongException {
	    PropertyDescription description = new PropertyDescription();
	    
	    System.out.print(ConsoleColours.LIGHT_PINK+"Enter title Of Property: "+ConsoleColours.RESET);
	    sc.nextLine();
	    description.setTitle(sc.nextLine());
	    System.out.print(ConsoleColours.LIGHT_PINK+"Enter details of the Property: "+ConsoleColours.RESET);
	    description.setDetails(sc.nextLine());
	    
//	    commercial.setDescription(description); // Link the description to the commercial
	    
	   
	    
	    ClassService classService = new ClassServiceImplementation();
	    
	    try {
	        classService.Add_Commercial_Description(commercial,description); // This will save both the commercial and its description
	        System.out.println(ConsoleColours.LIGHT_PURPLE+" Description Of Property added successfully!"+ConsoleColours.RESET);
	    } catch (SomethingWentWrongException e) {
	        System.out.println("Error while adding commercial property and description: " + e.getMessage());
	    }
	}
	
	private static void Add_Residential_Description(Scanner sc, Residential residential) throws SomethingWentWrongException {
	    PropertyDescription description = new PropertyDescription();
	    
	    System.out.print(ConsoleColours.LIGHT_PINK+"Enter title Of Property: "+ConsoleColours.RESET);
	    sc.nextLine();
	    description.setTitle(sc.nextLine());
	    System.out.print(ConsoleColours.LIGHT_PINK+"Enter details of the Property: "+ConsoleColours.RESET);
	    description.setDetails(sc.nextLine());
	    
//	    commercial.setDescription(description); // Link the description to the commercial
	    
	   
	    
	    ClassService classService = new ClassServiceImplementation();
	    
	    try {
	        classService.Add_Residential_Description(residential,description); // This will save both the commercial and its description
	        System.out.println(ConsoleColours.LIGHT_PURPLE+" Description Of Property added successfully!"+ConsoleColours.RESET);
	    } catch (SomethingWentWrongException e) {
	        System.out.println("Error while adding residential property  description: " + e.getMessage());
	    }
	}
	
	private static void View_Residential_Description(Scanner sc, Residential residential) throws SomethingWentWrongException {
	    ClassService classService = new ClassServiceImplementation();

	    try {
	        PropertyDescription description = classService.getPropertyDescriptionForResidential(residential); // Use a method from ClassServiceImplementation
	        if (description != null) {
	            System.out.println(ConsoleColours.LIGHT_PINK + "Title of Property: " + description.getTitle() + ConsoleColours.RESET);
	            System.out.println(ConsoleColours.LIGHT_PINK + "Details of the Property: " + description.getDetails() + ConsoleColours.RESET);
	        } else {
	            System.out.println(ConsoleColours.LIGHT_PINK + "No description available for this residential property." + ConsoleColours.RESET);
	        }
	    } catch (SomethingWentWrongException e) {
	        System.out.println("Error while viewing residential property description: " + e.getMessage());
	    }
	}


	
	
	
	

        
    }

	
	
	
        
	


	
