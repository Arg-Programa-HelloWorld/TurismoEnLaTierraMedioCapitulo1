package turismo_capitulo_I;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadAttractions {

	private static ArrayList<Attraction> attractionList = new ArrayList<Attraction>();
	
	public static boolean readAttractionsFile() {
		
		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferReader = null;

		try {

			file = new File("data_folder/attractions.in");
			fileReader = new FileReader(file);
			//fileReader = new FileReader("attractions.in"); / otra forma de hacerlo
			
			bufferReader = new BufferedReader(fileReader);

			String line = bufferReader.readLine(); // lee la primera linea
			//	bufferReader.readLine() => lee una linea.-

			while(line != null) {
				
				//System.out.println(line);	// muestra la linea leida
				//line = bufferReader.readLine();	// avanza a la proxima linea
				
				String [] dataAttraction = line.split(",");
				
				int id = Integer.valueOf(dataAttraction[0].trim());
				String name = dataAttraction[1].trim();
				double cost = Double.parseDouble(dataAttraction[2]);
				double time = Double.parseDouble(dataAttraction[3]);
				//int quota = Integer.parseInt(dataUser[3].trim());
				int quota = Integer.valueOf(dataAttraction[4].trim());
				String kind = dataAttraction[5].trim();
				
				//System.out.println("Tipo " + tipo.trim() + " con un largo de " + tipo.length());
				
				// AttractionType.ADVENTURE,	// Tipo.AVENTURA,
				// AttractionType.SCENERY,	// Tipo.PAISAJE,
				// AttractionType.TASTING		// Tipo.DEGUSTACION 
				
				AttractionType kindOf = null;
				
				if (kind.equals("AttractionType.ADVENTURE")) {
					
					kindOf = AttractionType.ADVENTURE;
					
				} else if (kind.equals("AttractionType.SCENERY")) {
					
					kindOf = AttractionType.SCENERY;
					
				} else if (kind.equals("AttractionType.TASTING")) {
					
					kindOf = AttractionType.TASTING;
				
				}
				
				Attraction attraction = new Attraction(id, name, cost, time, quota, kindOf);
				
				LoadAttractions.attractionList.add(attraction);
				
				//System.out.println("Nombre " + name + ", costo $" + cost + ", tiempo " + time + ", cupo " + quota + ", preferencia " + kindOf);
				
				line = bufferReader.readLine();
				
			}
			
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

		return true;

	}

	protected static ArrayList<Attraction> getAttractionList() {
		return attractionList;
	}

	protected static void setAttractionList(ArrayList<Attraction> attractionList) {
		LoadAttractions.attractionList = attractionList;
	}
	
	

}
