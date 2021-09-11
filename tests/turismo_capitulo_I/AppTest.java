package turismo_capitulo_I;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void dataUploadSupervisorTest() {
		
		// Comprueba que se hayan cargado los archivos con:
		// -Los Usuarios
		// -Las Atracciones
		// -las Promociones
		
		// Lo unico obligatorio es que las Atracciones sean cargadas que las Promociones,
		// ya que las primeras estan contenidas en estas ultimas.-
		
		boolean dataUploadSupervisor;
		
		dataUploadSupervisor = Functions.dataLoader();

		assertTrue(dataUploadSupervisor);
		
	}
	
	@Test
	public void readAndLoadUsersOKTest() {
		
		// Comprueba que se hayan cargado los archivos con:
		// -Los Usuarios
		
		boolean 
		
		dataUploadUser = LoadUsers.readUsersFile();

		assertTrue(dataUploadUser);
		
	}
	
	@Test
	public void readAndLoadAttractionsOKTest() {

		// Comprueba que se hayan cargado los archivos con:
		// -Las Atracciones
		
		boolean dataUploadAttractions;
		
		dataUploadAttractions = LoadAttractions.readAttractionsFile();

		assertTrue(dataUploadAttractions);
		
	}
	
	@Test
	public void readAndLoadPromotionsOKTest() {

		// Comprueba que se hayan cargado los archivos con:
		// -las Promociones
		
		boolean dataUploadPromotions;
		
		LoadAttractions.readAttractionsFile();
		
		dataUploadPromotions = LoadPromotions.readPromotionsFile();

		assertTrue(dataUploadPromotions);
		
	}
		
}
