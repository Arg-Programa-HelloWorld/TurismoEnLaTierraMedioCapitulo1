package turismo_capitulo_I;

import java.util.Collections;

public class Functions {

	public static boolean dataLoader() {
		  
		View.dataLoaderMenu();
		
		return LoadUsers.readUsersFile() && LoadAttractions.readAttractionsFile() && LoadPromotions.readPromotionsFile();
		
	}	
	
	public static void getAttraction() {
		
		for (Attraction attraction : LoadAttractions.getAttractionList()) {
			
			if (attraction.getId() == Model.idAttraction) {
				
				Model.attraction = attraction;
				
			}
			
		}
		
	} 
		
	public static void getAttractionsByPreferences(AttractionType at) {
		
		View.bannerAttractions();
		
		for (Attraction attraction : LoadAttractions.getAttractionList()) {
			
			if(Model.user.haveAttraction(attraction)) {
				
				System.out.println("[ - Facts about the Atraction: " + attraction.getName() + ", cost $" + attraction.getCost() + ", time " + attraction.getTime() + "hs, " );
				System.out.println("[ quota "+attraction.getQuota() + " places, and it's " + attraction.getAttractionType() + " type.");
				
				System.out.println();
				
			} else {
			
				if (attraction.getAttractionType() == at) {
				
					System.out.println("[ "+ attraction.getId() + " - The Atraction: " + attraction.getName() + ", cost $" + attraction.getCost() + ", time " + attraction.getTime() + "hs, " );
					System.out.println("[ quota "+attraction.getQuota() + " places, and it's " + attraction.getAttractionType() + " type.");
					
					System.out.println();
					
				}
				
			}
			
		}
		
	}
	
	public static void getAllAttractions() {
		
		View.bannerAttractions();
		
		for (Attraction attraction : LoadAttractions.getAttractionList()) {
			
			System.out.println("[ "+ attraction.getId() + " - The Atraction: " + attraction.getName() + ", cost $" + attraction.getCost() + ", timeUser " + attraction.getTime() + "hs, " );
			System.out.println("[ quota "+attraction.getQuota() + " places, and it's " + attraction.getAttractionType() + " type.");
			
			System.out.println();
							
		}
		
	}
	
	public static boolean getAccessibleAttractions(AttractionType at, double time, double budget) {
		
		int flag = 0;
		
		View.bannerAttractions();
		
		Collections.sort(LoadAttractions.getAttractionList(), new CompareAttractions()); // Ordena la lista por de mayor a menor or costo, duracion y cupo.		
		
		for (Attraction attraction : LoadAttractions.getAttractionList()) {


		
			if(Model.user.haveAttraction(attraction)) {
				
							
			} else {				
			
				if (!Model.user.haveAttraction(attraction) && attraction.getAttractionType() == at && attraction.getTime() <= time && attraction.getCost() <= budget) {
													
					System.out.println("[ "+ attraction.getId() + " - The Atraction: " + attraction.getName() + ", cost $" + attraction.getCost() + ", timeUser " + attraction.getTime() + "hs, " );
		
					System.out.println("[ quota "+attraction.getQuota() + " places, and it's " + attraction.getAttractionType() + " type.");
								
					System.out.println();
								
					flag ++;
												
				}
								
			}
			
		}
		
		if(flag > 0) {
			
			return true;
			
		} else {
			
			return false;
			
		}
					
		
	}
	
	public static void buyAttraction() {
		
		boolean menu;
		
		getUser(Model.idUser);	// Actualiza las variables locales obtenidad de la class usada como bdd.-

		/*---------------- NEW CODE ----------------*/
		
		// Ordena Atracciones por Las de costo mas caro primero
			
		Collections.sort(LoadAttractions.getAttractionList(), new CompareAttractionByCost());	 

		Collections.sort(LoadAttractions.getAttractionList(), new CompareAttractions());
		
		menu = Functions.getAccessibleAttractions(Model.user.getPreferences(), Model.user.getTime(), Model.user.getBudget());
		
		if(menu) {
		
			View.buyAttractionMenu();	// Menu Opciones
			
		} else {
			
			View.noBuyMenu();	// Menu Back
			
		}
		
		
		
		// Escanea la opcion, o el ID de una atraccion o el 0 para volver atrás.-
		Model.idAttraction = Model.scanner.nextInt();
		
		if (Model.idAttraction != 0) {	// porque si elije '0' volvia para atrás.-
		
			for (Attraction attraction : LoadAttractions.getAttractionList()) {
				
				if (attraction.getId() == Model.idAttraction) {
					
					Model.attraction = attraction;
					
				}
				
			}
			
			if (!Model.user.haveAttraction(Model.attraction)) {
			
				if (Model.user.getBudget() > 0 && Model.user.getTime() > 0) {
									
					for (User user : LoadUsers.getUserList()) {
						
						if(user.getId() == Model.user.getId()) {
						
							Model.user.buyAttraction(Model.attraction);
							// Este metodo "buyAttraction" se encargara a travez del siguiente metodo
							// removeQuotaOfAnAttraction(newAttraction) que se ubica en el usuario de
							// descontar una cantidad en el cupo de la atraccion.- 
							
							
							// Si quisieramos utilizar el getter & setter de
							// Atraccion cuando realizamos la compra por el user
							// lo hariamos como esta aca abajo
													
							//Model.attraction.setQuota(Model.attraction.getQuota()-1);
																				
						}
												
					}
					
				} else if (Model.user.getBudget() > 0){
					
					for (User user : LoadUsers.getUserList()) {
						
						if(user.getId() == Model.user.getId()) {
						
							Model.user.buyAttraction(Model.attraction);
							
						}
					}
										
				} else if (Model.user.getTime() > 0){
					
					for (User user : LoadUsers.getUserList()) {
						
						if(user.getId() == Model.user.getId()) {
						
							Model.user.buyAttraction(Model.attraction);
							
						}
						
					}
					
				}

			} 

		}

	}
	
	public static void getAllPromotion() {
		
		View.bannerPromotions();
		
		for( Promotion promotion : LoadPromotions.getPromotionList()) {
			
			System.out.println("[ " + promotion.getId() + " - " + promotion.getPromotionType() + " type promotion, Name , " + promotion.getName()); 
			System.out.println("[ at a cost of gold coins: " + String.format("%.2f", promotion.getCost()) + ", time required " + promotion.getTime() + " hs.");
				
			System.out.println();
					
		}
		
	}
	
	public static void getPromotionTimeLimit(double time) {
		
		View.bannerPromotions();
		
		int flag = 0;
		
		for( Promotion promotion : LoadPromotions.getPromotionList()) {
			
			if(promotion.time <= time) {
			
				System.out.println("[ " + promotion.getId() + " - " + promotion.getPromotionType() + " type promotion, Name , " + promotion.getName()); 
				System.out.println("[ at a cost of gold coins: " + String.format("%.2f", promotion.getCost()) + ", time required " + promotion.getTime() + " hs.");
					
				System.out.println();
				
				flag ++;
				
			}
							
		}
		
		if (flag == 0) {
			
			System.out.println("[ We do not have promotions with your user time limits      ]");
		}
		
	}
	
	public static boolean getAccessiblePromotions() {

		int flag = 0; 
		
		View.bannerPromotions();
		
		for (Promotion promotion : LoadPromotions.getPromotionList()) {
			
			if(Model.user.havePromotion(promotion)) {
					
			} else {
			
				boolean result = true;
				
				for (Attraction atraction : promotion.getAttractionsList()) {
					
					if (Model.user.haveAttraction(atraction)) { // Si tengo las atracciones de la promotion
						
						View.colorearMensaje(View.red,"[---------------------------------------------------------------------]");
						View.colorearMensaje(View.red,"[ The '" + promotion.name + "' promotion has been blocked because it"); 
						View.colorearMensaje(View.red,"[ contains the product '"+ atraction.getName() +"' already purchased!!");
						View.colorearMensaje(View.red,"[---------------------------------------------------------------------]");
						
						result = false;
						
					}				
					
				}
					
				if (result) {
					
					System.out.println("[ " + promotion.getId() + " - The , " + promotion.getName().toUpperCase() + "."); 
					System.out.println("[ Has a cost of: " + String.format("%.2f", promotion.getCost()) + " gold coins, and required " + promotion.getTime() + " hs.");
					System.out.println("[ Includes the following attractions: ");
					
					for(Attraction atraction : promotion.getAttractionsList()) {
						
						System.out.println("[ -" + atraction.getName());
						
					}
					
					System.out.println();
					
					flag ++;
						
				}
						
			}
		
		}
		
		if(flag > 0) {
			
			return true;
			
		} else {
			
			return false;
			
		}
				
	}
		
	public static void buyPromotion() {
		
		boolean menu;
		
		getUser(Model.idUser);
		
		/*---------------- NEW CODE ----------------*/
		
		menu = Functions.getAccessiblePromotions();
		//Functions.getAllPromotion();
		
		if(menu) {
			
			View.buyPromotionMenu();	// Menu
			
		} else {
			
			View.noBuyMenu();	// Menu Back
			
		}
		
		// Escanea la opcion, o el ID de una Promocion o el 0 para volver atrás.-
		Model.idPromotion = Model.scanner.nextInt();
		
		if (Model.idPromotion != 0) {
		
			for (Promotion promotion : LoadPromotions.getPromotionList()) {
				
				if (promotion.getId() == Model.idPromotion) {
					
					Model.promotion = promotion;
					
				}
				
			}
			
			if (!Model.user.havePromotion(Model.promotion)) {
				
				if (Model.user.getBudget() > 0 && Model.user.getTime() > 0) {
									
					for (User user : LoadUsers.getUserList()) {
						
						if(user.getId() == Model.user.getId()) {
						
							Model.user.buyPromotion(Model.promotion);
							// Este metodo buy promotion se encargara a travez del siguiente metodo
							// removeQuotaOfAnAttraction(newAttraction) que se ubica en el usuario de
							// descontar una cantidad en el cupo de la atraccion.- 
							
							
							
							// Si quisieramos utilizar el getter & setter de
							// Atraccion cuando realizamos la compra por el user
							// lo hariamos como esta aca abajo
							/*
							for(Attraction attraction: Model.promotion.attractionList) {
								attraction.setQuota(attraction.getQuota()-1);
							}
							*/
																	
						}
						
					}
					
				} else if (Model.user.getBudget() > 0){
					
					for (User user : LoadUsers.getUserList()) {
						
						if(user.getId() == Model.user.getId()) {
						
							Model.user.buyPromotion(Model.promotion);
							
						}
						
					}
								
				} else if (Model.user.getTime() > 0){
					
					for (User user : LoadUsers.getUserList()) {
				
						if(user.getId() == Model.user.getId()) {
							
							Model.user.buyPromotion(Model.promotion);
							
						}

					}

				}

			} 			

		}

	}
	
	public static void getUser(int idUser) {
		
		for (User user : LoadUsers.getUserList()) {
			
			if (user.getId() == idUser) {
				
				Model.user = user;
				
			}
			
		}
		
		View.currentSituation();	// Le mostrara al usuario su situacion econimica, como tambien tiempo que posee.-
				
	}

	public static void myShopping(int idUser) {
		
		View.colorearMensaje(View.green,"[---------------------------------------------------------------------]");
		View.colorearMensaje(View.green,"[                            YOUR SHOPPING                            ]");
		View.colorearMensaje(View.green,"[---------------------------------------------------------------------]");
		
		for(User user: LoadUsers.getUserList()) {
			
			if (user.getId() == idUser) {
				
				View.colorearMensaje(View.green,"[ USER ID " + user.getId() + " - " + user.getName().toUpperCase() + " -");
				View.colorearMensaje(View.green,"[---------------------------------------------------------------------]");
				
				View.colorearMensaje(View.blue,"[ Your attractions...");
				
				for (Attraction attraction : user.getListOfAttractions()) {
										
					
					System.out.println("[ - Attraction article No. " + attraction.getId() + " - The '" + attraction.getName() + "',");
					System.out.println("[   Has a cost of: " + String.format("%.2f", attraction.getCost()) + " gold coins, and required " + attraction.getTime() + " hs.");
					System.out.println();
				}
				
				View.colorearMensaje(View.green,"[---------------------------------------------------------------------]");
				
				View.colorearMensaje(View.blue,"[ Your Promotions...");
				
				for(Promotion promotion : user.getListOfPromotions()) {
					
					System.out.println("[ - Promotion article No. " + promotion.getId() + " - The '" + promotion.getName().toUpperCase() + "'."); 
					System.out.println("[   Has a cost of: " + String.format("%.2f", promotion.getCost()) + " gold coins, and required " + promotion.getTime() + " hs.");
					System.out.println("[   Includes the following attractions: ");
													
					for(Attraction atraction : promotion.getAttractionsList()) {
						
						System.out.println("[   -" + atraction.getName());
						
					}
					
					System.out.println();
															
				}
				
			}
			
		}
		
		View.colorearMensaje(View.green,"[---------------------------------------------------------------------]");
						
	}
	
}