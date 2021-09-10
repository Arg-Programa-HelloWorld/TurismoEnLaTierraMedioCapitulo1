package turismo_capitulo_I;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadPromotions {

	private static ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
	
	public static boolean readPromotionsFile() {

		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferReader = null;

		try {
			
			Promotion promotion = null;

			file = new File("data_folder/promotions.in");
			fileReader = new FileReader(file);
			// fileReader = new FileReader("promotion.in"); / otra forma de hacerlo

			bufferReader = new BufferedReader(fileReader);

			String line = bufferReader.readLine(); // lee la primera linea

			// bufferReader.readLine() => lee una linea.-
			while (line != null) {

				// System.out.println(line); // muestra la linea leida
				// line = bufferReader.readLine(); // avanza a la proxima linea

				String[] dataPromotion = line.split(",");

				int id = Integer.valueOf(dataPromotion[0].trim()); 
				String type = dataPromotion[1].trim();
				String name = dataPromotion[2].trim();
				int attraction1ID = Integer.valueOf(dataPromotion[3].trim());
				int attraction2ID = Integer.valueOf(dataPromotion[4].trim());
				int attraction3ID = Integer.valueOf(dataPromotion[5].trim());
				int discount = attraction3ID;
						
				PromotionType typeOf = null;

				if (type.equals("PromotionType.PERCENTAGE")) {

					ArrayList<Attraction> attractionListPer = new ArrayList<Attraction>();
													
					for (Attraction attraction : LoadAttractions.getAttractionList()) {
						
						if (attraction.getId() == attraction1ID || attraction.getId() == attraction2ID) {
							
							attractionListPer.add(attraction);
						}
						
					}
					
					typeOf = PromotionType.PERCENTAGE;
					promotion = new PercentagePromotion(id, typeOf, name, attractionListPer, discount);
					attractionListPer = null;

				} else if (type.equals("PromotionType.ABSOLUTE")) {
					
					ArrayList<Attraction> attractionListABS = new ArrayList<Attraction>();

					for (Attraction attraction : LoadAttractions.getAttractionList()) {
						
						if (attraction.getId() == attraction1ID || attraction.getId() == attraction2ID) {
							
							attractionListABS.add(attraction);
						}
						
					}
					
					typeOf = PromotionType.ABSOLUTE;
					promotion = new PromotionAbsolute(id, typeOf, name, attractionListABS, discount);
					attractionListABS = null;

				} else if (type.equals("PromotionType.A_AND_B")) {
					
					ArrayList<Attraction> attractionListAAB = new ArrayList<Attraction>();
					
					for (Attraction attraction : LoadAttractions.getAttractionList()) {
												
						if (attraction.getId() == attraction1ID || attraction.getId() == attraction2ID ||
								attraction.getId() == attraction3ID) {
							
							attractionListAAB.add(attraction);
						}
						
					}
					
					typeOf = PromotionType.A_AND_B;
					promotion = new PromotionAyB(id, typeOf, name, attractionListAAB);
					attractionListAAB = null;
					
				}

				LoadPromotions.promotionList.add(promotion);
				
				line = bufferReader.readLine();

			}
			
			return true;

		} catch (IOException e) {

			e.printStackTrace();

			return false;

		} finally {

			try {

				if (fileReader != null) {

					fileReader.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();
			
			}

		}

	}

	public static ArrayList<Promotion> getPromotionList() {
		return promotionList;
	}

	public static void setPromotionList(ArrayList<Promotion> promotionList) {
		LoadPromotions.promotionList = promotionList;
	}
		
}
