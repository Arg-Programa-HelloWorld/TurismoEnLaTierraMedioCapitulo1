package turismo_capitulo_I;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadUsers {

	private static ArrayList<User> userList = new ArrayList<User>();
	
	public static boolean readUsersFile() {
		
		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferReader = null;

		try {

			file = new File("data_folder/persons.in");
			fileReader = new FileReader(file);
			//fileReader = new FileReader("persons.txt"); / otra forma de hacerlo
			
			bufferReader = new BufferedReader(fileReader);

			String line = bufferReader.readLine(); // lee la primera linea
			
			//	bufferReader.readLine() => lee una linea.-
			while(line != null) {
				
				//System.out.println(line);	// muestra la linea leida
				//line = bufferReader.readLine();	// avanza a la proxima linea
											
				String [] dataUser = line.split(",");
				
				int id = Integer.valueOf(dataUser[0].trim());
				String name = dataUser[1].trim();
				double budget = Double.parseDouble(dataUser[2]);
				double time = Double.parseDouble(dataUser[3]);
				String type = dataUser[4].trim();
				
				AttractionType typeOf = null;
				
				if (type.equals("AttractionType.ADVENTURE")) {
					
					typeOf = AttractionType.ADVENTURE;
					
				} else if (type.equals("AttractionType.SCENERY")) {
					
					typeOf = AttractionType.SCENERY;
					
				} else if (type.equals("AttractionType.TASTING")) {
					
					typeOf = AttractionType.TASTING;
				
				}
								
				User user = new User(id, name, budget, time, typeOf);
				
				LoadUsers.userList.add(user);
				
				// System.out.println("Nombre " + name + ", presupuesto $" + budget + ", tiempo " + time + " preferencia " + kindOf);
				
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

	public static ArrayList<User> getUserList() {
		return userList;
	}

	public static void setUserList(User user) {
		userList.add(user);
	}

}