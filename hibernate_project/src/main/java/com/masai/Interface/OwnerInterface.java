package com.masai.Interface;

import java.util.List;
import java.util.Scanner;

import com.masai.Exception.NoRecordFoundException;
import com.masai.Exception.SomethingWentWrongException;
import com.masai.entity.AvailableStatus;
import com.masai.entity.Commercial;
import com.masai.entity.PropertyDescription;
import com.masai.entity.Residential;
import com.masai.service.ClassService;
import com.masai.service.ClassServiceImplementation;
import com.masai.ui.Offer;

public class OwnerInterface {
		public static void main(String[] args) throws SomethingWentWrongException, NoRecordFoundException {
			Scanner sc = new Scanner(System.in);
			boolean loggedIN = true;
			
			while(loggedIN) {
			System.out.println("1. Add Commercial Property");
			System.out.println("2. Add Residential Property");
			System.out.println("3. Update Property");
			System.out.println("4. View Commercial Property");
			System.out.println("5. View Residentail Property");
			System.out.println("6. Change Password");
			System.out.println("7. Logout");
			System.out.println("8. View All Offers");
			//offer
			
			System.out.println("0. Exit");
			System.out.println("Select an Option");
			
			
			while(true) {
				int choice = sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
				case 1: Commercial commercial = Add_Commercium(sc);
                System.out.println(ConsoleColours.GREEN_UNDERLINED+"Do you want to add more information about the property? (Y/N)"+ConsoleColours.RESET);
                String addMoreChoice = sc.next().toUpperCase();
                if (addMoreChoice.equals("Y")) {
                boolean t =	Add_Commercial_Description(sc, commercial);
                if(!t) {
                	break;
                }
                
                }
           
				
				case 2: Residential residential = Add_Residential(sc);
				System.out.println(ConsoleColours.GREEN_UNDERLINED+"Do you want to add more information about the property? (Y/N)"+ConsoleColours.RESET);
                String addMoreChoice1 = sc.next().toUpperCase();
                if (addMoreChoice1.equals("Y")) {
                	Add_Residential_Description(sc, residential);
                	break;
                }
                OwnerInterface.main(args);
				
					break;
				case 3:UpdatePropertyDetails(sc);
					break;
				case 4: ViewCommercialPropertyById(sc);
					break;
				case 5: ViewResidentialPropertyById(sc);
					break;
				case 6: ChangePassword(sc);
                    break;
				case 7: System.out.println("Logged out successfully.");
                loggedIN = false;
					break;
//				case 8: viewOffers(sc);
//					break;	
					
				case 0: System.out.println("Thanks for Using our Services ! Bye- Bye");	
				System.exit(0);
				
				default:
					System.out.println("Invalid choice. Please select a valid option.");
                    break;
				}
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
		
		public static Residential Add_Residential (Scanner sc) {
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
			return residential;
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
//		        	offer(sc);
		        }
		        
		    } catch (NoRecordFoundException e) {
		        System.out.println("No commercial properties found matching the criteria.");
		    }
		    
		    
		}
		
		
		
//		public static void offer(Scanner sc)
//		{
//			   System.out.println("Enter Amount");
//			   int amount  = sc.nextInt();
//			   
//					   
//			   
	//
//			    ClassService classService = new ClassServiceImplementation();
	//
//			    try {
//			        List<Commercial> commercialProperties = classService.searchCommercialProperties(location, minRentAmount, maxRentAmount);
//			        System.out.println("Matching Commercial Properties:");
//			        for (Commercial property : commercialProperties) {
//			            System.out.println(property);
//			        }
//			        
//			        System.out.println("Submit ");
//			        
//			        System.out.println("do you want to offer [Y]/[N]");
//			        String st = sc.next();
//			        if(st.equals("Y"))
//			        {
//			        	offer(sc);
//			        }
//			        
//			    } catch (NoRecordFoundException e) {
//			        System.out.println("No commercial properties found matching the criteria.");
//			    }
//			
//			
//		}
		

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
		
		private static boolean Add_Commercial_Description(Scanner sc, Commercial commercial) throws SomethingWentWrongException {
		    PropertyDescription description = new PropertyDescription();
		    
		    System.out.print(ConsoleColours.LIGHT_PINK+"Enter title Of Property: "+ConsoleColours.RESET);
		    sc.nextLine();
		    description.setTitle(sc.nextLine());
		    System.out.print(ConsoleColours.LIGHT_PINK+"Enter details of the Property: "+ConsoleColours.RESET);
		    description.setDetails(sc.nextLine());
		    
//		    commercial.setDescription(description); // Link the description to the commercial
		    
		   
		    
		    ClassService classService = new ClassServiceImplementation();
		    
		    try {
		        classService.Add_Commercial_Description(commercial,description); // This will save both the commercial and its description
		        System.out.println(ConsoleColours.LIGHT_PURPLE+" Description Of Property added successfully!"+ConsoleColours.RESET);
		        
		        return false;
		    } catch (SomethingWentWrongException e) {
		        System.out.println("Error while adding commercial property and description: " + e.getMessage());
		        return false;
		    }
		}
		
		private static void Add_Residential_Description(Scanner sc, Residential residential) throws SomethingWentWrongException {
		    PropertyDescription description = new PropertyDescription();
		    
		    System.out.print(ConsoleColours.LIGHT_PINK+"Enter title Of Property: "+ConsoleColours.RESET);
		    sc.nextLine();
		    description.setTitle(sc.nextLine());
		    System.out.print(ConsoleColours.LIGHT_PINK+"Enter details of the Property: "+ConsoleColours.RESET);
		    description.setDetails(sc.nextLine());
		    
//		    commercial.setDescription(description); // Link the description to the commercial
		    
		   
		    
		    ClassService classService = new ClassServiceImplementation();
		    
		    try {
		        classService.Add_Residential_Description(residential,description); // This will save both the commercial and its description
		        System.out.println(ConsoleColours.LIGHT_PURPLE+" Description Of Property added successfully!"+ConsoleColours.RESET);
		    } catch (SomethingWentWrongException e) {
		        System.out.println("Error while adding residential property  description: " + e.getMessage());
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
		
		
		    public static void viewOffers(Scanner sc, int propertyId) {
		        
		        ClassService classService = new ClassServiceImplementation();
		        List<Offer> offers = classService.getOffersForProperty(propertyId);
		        
		        if (offers.isEmpty()) {
		            System.out.println("No offers available for this property.");
		        } else {
		            System.out.println("Offers for Property ID " + propertyId + ":");
		            for (Offer offer : offers) {
		                System.out.println("Offer ID: " + offer.getId());
		                System.out.println("Offer Amount: " + offer.getAmount());
		            }
		        }
		    }
		    
		    public static void acceptOrRejectOffer(Scanner sc, int offerId, boolean accept) {
		        
		        ClassService classService = new ClassServiceImplementation();
		        boolean result = classService.acceptOrRejectOffer(offerId, accept);
		        
		        if (result) {
		            System.out.println("Offer " + (accept ? "accepted" : "rejected") + " successfully.");
		        } else {
		            System.out.println("Error occurred while processing the offer.");
		        }
		    }
		    
//		    public static void submitOffer(Scanner sc, int propertyId) {
//		        System.out.println("Submit Offer:");
//		        System.out.print("Offer Amount: ");
//		        double offerAmount = sc.nextDouble();
//		        
//		        
//		        ClassService classService = new ClassServiceImplementation();
//		        classService.submitOffer(propertyId, offerAmount);
//		        
//		        System.out.println("Offer submitted successfully.");
//		    }
		    
		    
		    public static void ViewCommercialPropertyById(Scanner sc) throws NoRecordFoundException, SomethingWentWrongException {
		        System.out.println("Enter property ID:");
		        long propertyId = sc.nextLong();

		        ClassService classService = new ClassServiceImplementation();

		        Commercial commercial = classService.ViewCommercialPropertyById(propertyId);

				if (commercial != null) {
				    System.out.println("Property details:");
				    System.out.println(commercial); // Use 'commercial' instead of 'property'
				} else {
				    System.out.println("No property found with ID: " + propertyId);
				}
		    }
		    
		    public static void ViewResidentialPropertyById(Scanner sc) throws NoRecordFoundException, SomethingWentWrongException {
		        System.out.println("Enter property ID:");
		        long propertyId = sc.nextLong();

		        ClassService classService = new ClassServiceImplementation();

		        Residential residential = classService.ViewResidentialPropertyById(propertyId);

				if (residential != null) {
				    System.out.println("Property details:");
				    System.out.println(residential); // Use 'commercial' instead of 'property'
				} else {
				    System.out.println("No property found with ID: " + propertyId);
				}
		    }


		    
		
}

		
		

	        
	    



		

		
		

		

