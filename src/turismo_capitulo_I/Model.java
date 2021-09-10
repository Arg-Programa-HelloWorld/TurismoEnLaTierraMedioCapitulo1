package turismo_capitulo_I;

import java.io.IOException;
import java.util.Scanner;

public class Model {
	
	public static User user;
	public static int idUser;
		
	public static Attraction attraction;
	public static int idAttraction;
	
	public static Promotion promotion;
	public static int idPromotion;
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void menu() throws IOException {
		
		do{
			
			int idMenu;
			int idMenuPromotion;
			int idMenuAttraction;
			
			View.userMenu();	//
	
			System.out.println("[ Enter your user ID or type '0' to exit: ");
									
			idUser = scanner.nextInt();
			
			if (idUser != 0) {
			
				View.welcomeMenu();
				
				Functions.getUser(idUser);
							
				do{
										
					View.mainMenu();
											
					idMenu = scanner.nextInt();
					
					if (idMenu == 1) {	// #PROMOTIONS - PROMOTIONS - PROMOTIONS
						
						do{
						
							View.promotionsMenu();
							
							idMenuPromotion = scanner.nextInt();
							
							if (idMenuPromotion == 1) {	// 1 - See all promotions with your timeUser limit.-
								
								Functions.getPromotionTimeLimit(user.getTime());
								//View.line();
								
							}else if(idMenuPromotion == 2) { // 2 - See all promotions.-
								
								Functions.getAllPromotion();
								//View.line();
								
							}else if(idMenuPromotion == 3) { // 3 - To buy.-
								
								Functions.buyPromotion(); 			
								//View.line(); 
								
							}
						
						}while(idMenuPromotion != 0);	// 0 - Back.-
						
					} else if (idMenu == 2) {	// #ATTRACTIONS - ATTRACTIONS - ATTRACTIONS
						
						do { 
						
							View.attractionMenu();
							
							idMenuAttraction = scanner.nextInt();
							
							if (idMenuAttraction == 1) { // 1 - See all the attractions according to your preferences.-
								
								Functions.getAttractionsByPreferences(user.getPreferences());
								
								
							} else if (idMenuAttraction == 2) { // 2 - See all attractions.-
								
								Functions.getAllAttractions();
								
								
							} else if (idMenuAttraction == 3) { // 3 - To buy
								
								Functions.buyAttraction();
																
							}
						
						} while (idMenuAttraction != 0); // 0 - Back.-
						
						
					} else if (idMenu == 3) {	// Your Shopping.-
						
						Functions.myShopping(idUser);
						
					} else if (idMenu == 4) {	// 4 - Your current situation
						
						Functions.getUser(idUser);
												
						
					} else if (idMenu == 5) {	// Print your purchases
						
						Report.toPrint(user);						
												
					} else if (idMenu == 6) {	// Print the purchases of each User	
					
						for (User user : LoadUsers.getUserList()) {
							
							Report.toPrint(user);
							
						}
						
						
					}					
										
				}while(idMenu != 0); // 0 - Back.-
			
			}
			
				
		}while(idUser != 0); // 0 - Exit.-
			View.greetings();
			scanner.close();
	}
		
}
