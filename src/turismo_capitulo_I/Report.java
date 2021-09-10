package turismo_capitulo_I;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Report {
	
	public static void toPrint(User aUser) throws IOException {
		
		aUser.calculateTimeAndGoldSpent();
		
		// or
		// aUser.calculateTotalTime();
		// aUser.calculateTotalGold();
		
		String ruta;
		
		ruta = "reports/" + aUser.getName() + ".out";
				
		int idUser = aUser.getId();
		
		//  Preparo el archivo de salida
		PrintWriter salida = new PrintWriter(new FileWriter(ruta));
		//PrintWriter salida = new PrintWriter(new FileWriter("reports/salida.out"));
	     
	    //int dni = 34567890;
	    //String s = "dni:";
	    //salida.print(s);      
		//salida.println(" "+ dni); 
	
        
		salida.println("[---------------------------------------------------------------------]");
		salida.println("[                            YOUR SHOPPING                            ]");
		salida.println("[---------------------------------------------------------------------]");
		
		for(User user: LoadUsers.getUserList()) {
			
			if (user.getId() == idUser) {
				
				salida.println("[ USER ID " + user.getId() + " - " + user.getName().toUpperCase() + " -");
				salida.println("[---------------------------------------------------------------------]");
				
				salida.println("[ Your attractions...");
				for (Attraction attraction : user.getListOfAttractions()) {
										
					
					salida.println("[ - Attraction article No. " + attraction.getId() + " - The '" + attraction.getName() + "',");
					salida.println("[   Has a cost of: " + String.format("%.2f", attraction.getCost()) + " gold coins, and required " + attraction.getTime() + " hs.");
					salida.println("");
				}
				
				salida.println("[---------------------------------------------------------------------]");
				
				salida.println("[ Your Promotions...");
				
				for(Promotion promotion : user.getListOfPromotions()) {
					
					salida.println("[ - Promotion article No. " + promotion.getId() + " - The '" + promotion.getName().toUpperCase() + "'."); 
					salida.println("[   Has a cost of: " + String.format("%.2f", promotion.getCost()) + " gold coins, and required " + promotion.getTime() + " hs.");
					salida.println("[   Includes the following attractions: ");
													
					for(Attraction atraction : promotion.getAttractionsList()) {
						
						salida.println("[   -" + atraction.getName());
						
					}
					
					salida.println("");
																				
				}
				
				salida.println("[---------------------------------------------------------------------]");
				salida.println("[ The total time taken is " + user.getTotalTime() + " hs.");
				salida.println("[ and the amount of gold coins spent is " + user.getTotalGold());
				salida.println("[---------------------------------------------------------------------]");
				
				
			}
			
		}

		salida.close();  

	}
	
}
