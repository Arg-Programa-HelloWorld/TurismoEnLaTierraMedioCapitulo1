package turismo_capitulo_I;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	User roberto;
	
	Attraction moria;
	Attraction minasTirith;
	
	ArrayList<Attraction> attractionsList;
	ArrayList<Attraction> attractionsList2;
	ArrayList<Promotion> promotionsList;
	
	PromotionAbsolute promocion;
	
	@Before
	public void setup() {
		roberto = new User(1, "Roberto", 200, 50, AttractionType.ADVENTURE);
		
		moria = new Attraction(1, "Moria", 10, 2, 6, AttractionType.ADVENTURE);
		minasTirith = new Attraction(2, "Minas Tirith", 5, 2.5, 25, AttractionType.SCENERY);
		
		attractionsList = new ArrayList<Attraction>();
		attractionsList2 = new ArrayList<Attraction>();
		promotionsList = new ArrayList<Promotion>();
				
		//promocion = new PromotionAbsolute(1, PromotionType.ABSOLUTE, "Oferton", attractionsList2, 5);
					
	}
	
	@After
	public void afterSetup() {
		attractionsList.clear();
		attractionsList2.clear();
		promotionsList.clear();
	}
	
	@Test
	public void crearUserTest() {
		
		assertNotNull(roberto);
		
		assertEquals(1, roberto.getId());
		assertEquals("Roberto", roberto.getName());
		assertEquals(200, roberto.getBudget(), 0);
		assertEquals(50, roberto.getTime(), 0);
		assertEquals(AttractionType.ADVENTURE, roberto.getPreferences());
		assertEquals(0, roberto.getTotalTime(), 0);
		assertEquals(0, roberto.getTotalGold(), 0);
		assertFalse(roberto.getAttractionFlag());
		
		assertNotNull(roberto.getListOfAttractions());
		assertNotNull(roberto.getListOfPromotions());
	}
	
	@Test
	public void buyAttractionTest() {
		
		attractionsList.add(moria);
		attractionsList.add(minasTirith); // Carga lista para comparar
		
		roberto.buyAttraction(moria); // Compra atracciones
		
		assertEquals(190, roberto.getBudget(), 0);
		assertEquals(48, roberto.getTime(), 0);
		
		roberto.buyAttraction(minasTirith);
		
		assertEquals(185, roberto.getBudget(), 0);
		assertEquals(45.5, roberto.getTime(), 0);
		
		assertEquals(attractionsList, roberto.getListOfAttractions());
	}
	
	@Test
	public void buyWithoutMoneyTest() {
		
		roberto.setBudget(0);
		
		roberto.buyAttraction(moria);
		
		assertFalse(roberto.getListOfAttractions().contains(moria));
		
		
		attractionsList2.add(moria);
		attractionsList2.add(minasTirith);
		
		promocion = new PromotionAbsolute(1, PromotionType.ABSOLUTE, "Oferton", attractionsList2, 5);
		
		roberto.buyPromotion(promocion);
		
		assertFalse(roberto.getListOfPromotions().contains(promocion));	
	
	}
	
	@Test
	public void buyWithoutTimeTest() {

		roberto.setTime(0);
		
		roberto.buyAttraction(moria);
		
		assertFalse(roberto.getListOfAttractions().contains(moria));
		
		
		attractionsList2.add(moria);
		attractionsList2.add(minasTirith);
		
		promocion = new PromotionAbsolute(1, PromotionType.ABSOLUTE, "Oferton", attractionsList2, 5);
		
		roberto.buyPromotion(promocion);
		
		assertFalse(roberto.getListOfPromotions().contains(promocion));
	}
	
	@Test
	public void buyOwnedAttractionTest() {
		
		attractionsList.add(moria);// Carga lista para comparar
		
		roberto.buyAttraction(moria); 
		
		assertEquals(190, roberto.getBudget(), 0);
		assertEquals(48, roberto.getTime(), 0);
		
        roberto.buyAttraction(moria); // Intenta comprar nuevamente la misma atraccion
		
		assertEquals(190, roberto.getBudget(), 0);
		assertEquals(48, roberto.getTime(), 0);
		
		assertEquals(attractionsList, roberto.getListOfAttractions());
	}
	
	@Test
	public void buyPromotionTest() {
		
		attractionsList2.add(moria);
		attractionsList2.add(minasTirith); // Carga lista para comparar
		
		promocion = new PromotionAbsolute(1, PromotionType.ABSOLUTE, "Oferton", attractionsList2, 5);
		
		promotionsList.add(promocion);
				
		roberto.buyPromotion(promocion); // Compra promocion
		
		assertEquals(190, roberto.getBudget(), 0);
		assertEquals(45.5, roberto.getTime(), 0);
		
		assertEquals(promotionsList, roberto.getListOfPromotions());

	}
	
	@Test
	public void buyOwnedPromotionTest() {
		
		attractionsList2.add(moria);
		attractionsList2.add(minasTirith); // Carga lista para comparar
		
		promocion = new PromotionAbsolute(1, PromotionType.ABSOLUTE, "Oferton", attractionsList2, 5);
		
		promotionsList.add(promocion);
				
		roberto.buyPromotion(promocion); // Compra promocion
		
		assertEquals(190, roberto.getBudget(), 0);
		assertEquals(45.5, roberto.getTime(), 0);
		
		assertEquals(promotionsList, roberto.getListOfPromotions());
		
		// Intenta comprar la misma procion nuevamente
		
		roberto.buyPromotion(promocion); 
		
		assertEquals(190, roberto.getBudget(), 0);
		assertEquals(45.5, roberto.getTime(), 0);
		
		assertEquals(promotionsList, roberto.getListOfPromotions());
	
	}
	
	@Test
	public void buyPromotionWithOwnedAttractionTest() {
		
		roberto.buyAttraction(moria); // Compro atracciones
		
		attractionsList.add(moria); // Carga lista para comparar
		
		assertEquals(190, roberto.getBudget(), 0);
		assertEquals(48, roberto.getTime(), 0);
		
		// Intento comprar promocion que contiene una atraccion ya comprada
						
		attractionsList2.add(moria);
		attractionsList2.add(minasTirith); // Carga lista de comparar
		
		promocion = new PromotionAbsolute(1, PromotionType.ABSOLUTE, "Oferton", attractionsList2, 5);		
		
		promotionsList.add(promocion); // Carga lista para comparar
				
		roberto.buyPromotion(promocion); // Intenta comprar promocion
		
		assertEquals(190, roberto.getBudget(), 0);
		assertEquals(48, roberto.getTime(), 0);
		
		assertNotEquals(promotionsList, roberto.getListOfPromotions()); // No agrega la promocion a la lista
		assertNotEquals(attractionsList2,roberto.getListOfAttractions());
		
	}
	
	@Test
	public void buyAttractionWithOwnedPromotionTest() {
		
		attractionsList2.add(moria);
		attractionsList2.add(minasTirith); // Carga lista de promocion
		
		promocion = new PromotionAbsolute(1, PromotionType.ABSOLUTE, "Oferton", attractionsList2, 5);
		
		promotionsList.add(promocion); // Carga lista para comparar
				
		roberto.buyPromotion(promocion); // Intenta comprar promocion
		
		assertEquals(190, roberto.getBudget(), 0);
		assertEquals(45.5, roberto.getTime(), 0);
		
		
		// Intento comprar promocion que contiene una atraccion ya comprada
		
		roberto.buyAttraction(moria); // Compro atracciones
		
		attractionsList.add(moria); // Carga lista para comparar
		
		assertEquals(190, roberto.getBudget(), 0);
		assertEquals(45.5, roberto.getTime(), 0);
		
		assertEquals(promotionsList, roberto.getListOfPromotions()); // Agrega la promocion a la lista		
		
	}
	
	@Test
	public void calculateTimeAndGoldSpentTest() {
		
		roberto.buyAttraction(moria);
		roberto.buyAttraction(minasTirith);
		roberto.calculateTimeAndGoldSpent();
				
		assertEquals(15, roberto.getTotalGold(), 0);
		assertEquals(4.5, roberto.getTotalTime(), 0);
		
	}
}
