package turismo_capitulo_I;

import java.util.Scanner;

public abstract class AppParaProbarPromociones {

	public static void main(String[] args) {
		
		
		LoadAttractions.readAttractionsFile();
		LoadPromotions.readPromotionsFile();
		LoadUsers.readUsersFile();
		
		for(Promotion promotion : LoadPromotions.getPromotionList()) {
			
			System.out.println(promotion.name);
			
			for(Attraction atraction : promotion.getAttractionsList()) {
				
				System.out.println(atraction.getName());
				
			}
			
			System.out.println("----------------------");			
			
		}
		
	}

}