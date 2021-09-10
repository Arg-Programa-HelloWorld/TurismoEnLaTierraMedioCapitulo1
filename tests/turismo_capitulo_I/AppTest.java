package turismo_capitulo_I;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void dataUploadSupervisorTest() {
		
		boolean dataUploadSupervisor;
		
		dataUploadSupervisor = Functions.dataLoader();

		assertTrue(dataUploadSupervisor);
		
	}
	
	@Test
	public void readAndLoadUsersOKTest() {
		
		boolean 
		
		dataUploadUser = LoadUsers.readUsersFile();

		assertTrue(dataUploadUser);
		
	}
	
	@Test
	public void readAndLoadAttractionsOKTest() {
		
		boolean dataUploadAttractions;
		
		dataUploadAttractions = LoadAttractions.readAttractionsFile();

		assertTrue(dataUploadAttractions);
		
	}
	
	@Test
	public void readAndLoadPromotionsOKTest() {
		
		boolean dataUploadPromotions;
		
		LoadAttractions.readAttractionsFile();
		
		dataUploadPromotions = LoadPromotions.readPromotionsFile();

		assertTrue(dataUploadPromotions);
		
	}
		
}
