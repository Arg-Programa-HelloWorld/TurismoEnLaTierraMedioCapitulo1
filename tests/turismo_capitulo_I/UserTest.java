package turismo_capitulo_I;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	//                  -PROMOTIONS-
	//
	//	1, PromotionType.PERCENTAGE,Pack Aventura,8,4,20
	//	2, PromotionType.ABSOLUTE,Pack Degustacion,6,3,2
	//	3, PromotionType.A_AND_B,Pack Paisajes,2,5,7
	
	
	//                  -ATTRACTIONS-
	//
	//	1, Moria, 10, 2, 6, AttractionType.ADVENTURE
	//	2, Minas Tirith, 5, 2.5, 25, AttractionType.SCENERY
	//	3, La Comarca, 3, 6.5, 150, AttractionType.TASTING
	//	4, Mordor, 25, 3, 4, AttractionType.ADVENTURE
	//	5, Abismo de Helm, 5, 2, 15, AttractionType.SCENERY
	//	6, Lothlorien, 35, 1, 30, AttractionType.TASTING
	//	7, Erebor, 12, 3, 32, AttractionType.SCENERY
	//	8, Bosque Negro, 3, 4, 12, AttractionType.ADVENTURE
	//	9, Paso de Caradhras, 9, 8, 7, AttractionType.SCENERY
	
	
	//				       -USERS-			
	//
	// 1, Eowyn, 10, 8, AttractionType.ADVENTURE
	// 2, Gandalf, 100, 5, AttractionType.SCENERY
	// 3, Sam, 36, 8, AttractionType.TASTING
	// 4, Galadriel, 120, 2, AttractionType.SCENERY
	// 5, Frodo, 15, 4, AttractionType.TASTING
	// 6, Meriadoc, 25, 8, AttractionType.TASTING
	// 7, Peregrin, 40, 12, AttractionType.ADVENTURE
	// 8, Boromir, 10, 9, AttractionType.TASTING
	// 9, Legolas, 26, 4, AttractionType.SCENERY
	// 10, Gimli, 38, 12, AttractionType.SCENERY
	
	
	User roberto;
	User gandalf;
	User sam;
	User galadriel;
	User frodo;
	User meriadoc;
	
	Attraction moria;
	Attraction minasTirith;
	Attraction laComarca;
	Attraction mordor;
	Attraction abismoDeHelm;
	Attraction lothlorien;
	Attraction erebor;
	Attraction bosqueNegro;
	Attraction pasoDeCaradhras;
	Attraction sierraDeLaVentana;
	
	ArrayList<Attraction> attractionsList;
	ArrayList<Attraction> attractionsListPercentage;
	ArrayList<Attraction> attractionsListAbsolute;
	ArrayList<Attraction> attractionsListA_and_B;
	
	
	Promotion promotion;
	
	ArrayList<Promotion> promotionsList;
	
	@Before
	public void setup() {
		
		roberto = new User(1, "Roberto", 100, 100, AttractionType.SCENERY);
		gandalf = new User(2, "Gandalf", 100, 5, AttractionType.SCENERY);
		sam = new User(3, "Sam", 36, 8, AttractionType.TASTING);
		galadriel = new User(4, "Galadriel", 120, 2, AttractionType.SCENERY);
		frodo = new User(5, "Frodo", 15, 4, AttractionType.TASTING);
		meriadoc = new User(6, "Meriadoc", 25, 8, AttractionType.TASTING);
				
		moria = new Attraction(1, "Moria", 10, 2, 6, AttractionType.ADVENTURE);
		minasTirith = new Attraction(2, "Minas Tirith", 5, 2.5, 25, AttractionType.SCENERY);
		laComarca =  new Attraction(3, "La Comarca", 3, 6.5, 150, AttractionType.TASTING);
		mordor = new Attraction(4, "Mordor", 25, 3, 4, AttractionType.ADVENTURE);
		abismoDeHelm = new Attraction(5, "Abismo de Helm", 5, 2, 15, AttractionType.SCENERY);
		lothlorien = new Attraction(6, "Lothlorien", 35, 1, 30, AttractionType.TASTING);
		erebor = new Attraction(7, "Erebor", 12, 3, 32, AttractionType.SCENERY);
		bosqueNegro = new Attraction(8, "Bosque Negro", 3, 4, 12, AttractionType.ADVENTURE);
		pasoDeCaradhras = new Attraction(9, "Paso de Caradhras", 9, 8, 7, AttractionType.SCENERY);
		
		attractionsList = new ArrayList<Attraction>();
		attractionsListPercentage = new ArrayList<Attraction>();
		attractionsListAbsolute = new ArrayList<Attraction>();
		attractionsListA_and_B = new ArrayList<Attraction>();
		
		promotionsList = new ArrayList<Promotion>();
		
	}
	
	@After
	public void afterSetup() {
		
		attractionsList.clear();
		
		attractionsListPercentage.clear();
		attractionsListAbsolute.clear();
		attractionsListA_and_B.clear();
		
		promotionsList.clear();
		
	}
	
	
	@Test
	public void newUserTest() {
		
		// Crear un Usuario.-
		
		assertNotNull(roberto);
		
		assertEquals(1, roberto.getId());
		assertEquals("Roberto",roberto.getName());
		assertEquals(100, roberto.getBudget(), 0);
		assertEquals(100, roberto.getTime(), 0);
		assertEquals(AttractionType.SCENERY, roberto.getPreferences());
		
		assertEquals(0, roberto.getTotalTime(), 0);
		assertEquals(0, roberto.getTotalGold(), 0);
		assertFalse(roberto.getAttractionFlag());
		
		assertNotNull(roberto.getListOfAttractions());
		assertNotNull(roberto.getListOfPromotions());
		
	}
	
	@Test
	public void buyAnAttractionTest() {
		
		//	Comprar una atraccion, 
		
		//  -Comprobar que nos descuenta Presupuesto.-
		//  -Comprobar que nos descuenta Tiempo.-
		//  -Y que realmente la tenemos en nuestra lista de atracciones.-
		
		attractionsList.add(moria);
		attractionsList.add(minasTirith); // Carga lista para comparar.-
		
		roberto.buyAttraction(moria); // Roberto compra la atraccion Moria.-
		
		assertEquals(90, roberto.getBudget(), 0);
		assertEquals(98, roberto.getTime(), 0);
		
		roberto.buyAttraction(minasTirith);  // Roberto compra la atraccion Minas Tirith.-
		
		assertEquals(85, roberto.getBudget(), 0);
		assertEquals(95.5, roberto.getTime(), 0);
		
		assertEquals(attractionsList, roberto.getListOfAttractions());		
		
	}
	

	@Test
	public void buyAttractionWithoutMoneyTest() {
		
		// Comprar Atracción sin Dinero.-
		
		// -Demuestra que no lo podemos hacer.-
		
		roberto.setBudget(0);
		
		roberto.buyAttraction(moria);	// Intenta comprar la atraccion pero no puede por falta de dinero.-
		
		assertFalse(roberto.getListOfAttractions().contains(moria));

	}
	
	@Test
	public void buyPromotionWithoutMoneyTest() {
		
		// Comprar Promoción sin Dinero.-
		
		// -Demuestra que no lo podemos hacer.-
		
		attractionsList.add(lothlorien);
		attractionsList.add(laComarca);
		
		roberto.setBudget(0);
				
		promotion = new PromotionAbsolute(1, PromotionType.ABSOLUTE, "Oferton", attractionsList, 5);
		
		roberto.buyPromotion(promotion);	// Intenta comprar la Promocion pero no puede por falta de dinero.-
		
		assertFalse(roberto.getListOfPromotions().contains(promotion));	
	
	}
	
	@Test
	public void buyAttractionWithoutTimeTest() {
		
		// Comprar Atracción sin Tiempo.-
		
		// -Demuestra que no lo podemos hacer.-
		
		roberto.setTime(0);
		
		roberto.buyAttraction(moria);	// Intenta comprar la atraccion pero no puede por falta de Tiempo.-
		
		assertFalse(roberto.getListOfAttractions().contains(moria));

	}
	
	@Test
	public void buyPromotionWithoutTimeTest() {
		
		// Comprar Promoción sin Tiempo.-
		
		// -Demuestra que no lo podemos hacer.-
		
		attractionsListAbsolute.add(lothlorien);
		attractionsListAbsolute.add(laComarca);
		
		roberto.setTime(0);
		//System.out.println(roberto.getTime());		
		
		//	2, PromotionType.ABSOLUTE,Pack Degustacion,6,3,2
		promotion = new PromotionAbsolute(2, PromotionType.ABSOLUTE, "Pack Degustacion", attractionsListAbsolute, 2);
		
		roberto.buyPromotion(promotion);	// Intenta comprar la Promocion pero no puede por falta de Tiempo.-
		
		assertFalse(roberto.getListOfPromotions().contains(promotion));	
	
	}
	
	@Test
	public void buyAttractionWeAlreadyQwnTest() {
		
		// Comprar Atracción que ya poseemos
		
		// -Comprueba que un Usuario "N" no podra comprar una Atraccion si ya la compro con anterioridad "la tiene en su lista".-
		
		attractionsList.add(moria);		// Carga la atraccion moria a la lista para comparar.-
		
		roberto.buyAttraction(moria);	// Compra la Atraccion "moria".-
		
		assertEquals(90, roberto.getBudget(), 0);
		assertEquals(98, roberto.getTime(), 0);
		
		assertTrue(roberto.haveAttraction(moria));	//	Comprueba que ya posee la Atraccion en sus compras.-
		
        roberto.buyAttraction(moria); // Al ya tener la Atraccion, la compra no se realiza.-
		
		assertEquals(90, roberto.getBudget(), 0);	// Mantiene el mismo dinero.-
		assertEquals(98, roberto.getTime(), 0);		// Mantiene el mismo tiempo.-
		
		assertEquals(attractionsList, roberto.getListOfAttractions());
		
		assertEquals(1, roberto.getListOfAttractions().get(0).getId());
		
	}
	
	@Test
	public void buyPercentagePromotionTest() {
		
		// Compra de una Promocion de tipo Promocion Porcentual
		
		// -Comprueba el descuento de un N porciento sobre el total.-
		
		attractionsListPercentage.add(bosqueNegro);
		attractionsListPercentage.add(mordor);
		
		//	1, PromotionType.PERCENTAGE,Pack Aventura,8,4,20
		promotion = new PercentagePromotion(1, PromotionType.PERCENTAGE, "Pack Aventura", attractionsListPercentage, 20);
		
		promotionsList.clear();
		promotionsList.add(promotion);
				
		roberto.buyPromotion(promotion); // Compra promotion.-
		
		//System.out.println(roberto.getBudget());
		
		assertEquals(77.6, roberto.getBudget(), 0.001);
		assertEquals(93, roberto.getTime(), 0.001);
								
		// Este tipo de promotion realiza un descuento de un X %, siendo 20 el de esta promotion.-
		// Las dos Atracciones que incluye tienen un presio de:
		// -Bosque Negro = $3
		// -Mordor = $25
		// Que harían un total de = 3 + 25 => 28
		// y si le aplicamos un descuento del 20
		// 28 * (1 - (20 / 100)) = 22.40
		assertEquals(22.40, promotion.getCost(), 0.001);
		
		// Las dos Atracciones que incluye tienen un tiempo individual de: 
		// -Bosque Negro = 4hs.
		// -Mordor = 3hs.
		// Tiempo que se necesita para la promotion es de 4 + 3 = 7hs.-
		assertEquals(7.0, promotion.getTime(), 0.001);
		
		assertEquals(promotionsList, roberto.getListOfPromotions());

	}
	
	@Test
	public void buyPromotionAbsoluteTest() {
		
		// Compra de una Promocion de tipo Promocion descuento Absoluto
		
		// -Comprueba el descuento de un N "fijo-estipulado para esa promocion" sobre el total.-
		
		attractionsListAbsolute.add(lothlorien);
		attractionsListAbsolute.add(laComarca);
		
		//	2, PromotionType.ABSOLUTE,Pack Degustacion,6,3,2
		promotion = new PromotionAbsolute(2, PromotionType.ABSOLUTE, "Oferton", attractionsListAbsolute, 2);
		
		promotionsList.clear();
		promotionsList.add(promotion);
				
		roberto.buyPromotion(promotion); // Compra promotion.-
		
		//System.out.println(roberto.getBudget());
		
		assertEquals(64, roberto.getBudget(), 0);
		assertEquals(92.5, roberto.getTime(), 0);
		
		// Este tipo de promotion realiza un descuento de un X monto fijo, siendo 2 el de esta promotion.-
		// Las dos Atracciones que incluye tienen un presio de:
		// -La Comarca = $3
		// -Lothlorien = $35
		// Que harían un total de = 3 + 35 => 38
		// y si le aplicamos un descuento del 2
		// 38 - 2 = $36
		assertEquals(36, promotion.getCost(), 0);
		
		// Las dos Atracciones que incluye tienen un tiempo individual de: 
		// -Bosque Negro = 4hs.
		// -Mordor = 3hs.
		// Tiempo que se necesita para la promotion es de 4 + 3 = 7hs.
		assertEquals(7.5, promotion.getTime(), 0);
		
		assertEquals(promotionsList, roberto.getListOfPromotions());

	}
	
	@Test
	public void buyPromotionA_and_BTest() {
		
		// Compra de una Promocion de tipo Promocion A x B
		
		// -Comprueba el descuento del tercer producto.-
		// -El usuario compra una promocion 
		//  Atrac1 + Atrac2 + Atrac3 siendo esta ultima gratuita, pagando solo la suma de las dos primeras.- 
		
		attractionsListA_and_B.add(minasTirith);
		attractionsListA_and_B.add(abismoDeHelm);
		attractionsListA_and_B.add(erebor);
		
		//	3, PromotionType.A_AND_B,Pack Paisajes,2,5,7
		promotion = new PromotionAyB(3, PromotionType.A_AND_B, "Pack Paisajes", attractionsListA_and_B);
		
		promotionsList.clear();
		promotionsList.add(promotion);
				
		roberto.buyPromotion(promotion); // Compra promotion.-
		
		//System.out.println(roberto.getBudget());
		
		assertEquals(90, roberto.getBudget(), 0);
		assertEquals(92.5, roberto.getTime(), 0);
		
		// Este tipo de promotion realiza un descuento de un que por llevar tres productos Atracciones
		// la ultima es gratuita.-
		// Las dos Atracciones que incluye tienen un presio de: 
		// -Minas Tirith = $5
		// -Abismo de Helm = $5
		// -Erebor = $12
		// Que harían un total de = 5 + 5 + 12
		// y si le aplicamos un descuento del $12 que es el valor de la ultima atraccion.-
		// 22 - 12 => $10
		assertEquals(10, promotion.getCost(), 0.001);
		
		// Las dos Atracciones que incluye tienen un tiempo individual de: 
		// -Minas Tirith = 2.5hs. 
		// -Abismo de Helm = 2hs.
		// -Erebor = 3hs.
		// Tiempo que se necesita para la promotion es de 4 + 3 = 7
		assertEquals(7.5, promotion.getTime(), 0.001);
		
		assertEquals(promotionsList, roberto.getListOfPromotions());

	}
	
	@Test
	public void buyPromotionThatWeAlreadyOwn() {
		
		// Comprar promoción que ya poseemos
		
		// -Comprueba que un Usuario "N" no podra comprar una Promocion si ya la compro con anterioridad "la tiene en su lista".-
		
		attractionsList.add(moria);			//	Carga la atraccion moria a la lista para comparar.-
		attractionsList.add(minasTirith); 	//  Carga la atraccion minasTirith a la lista para comparar.-
		
		promotion = new PromotionAbsolute(2, PromotionType.ABSOLUTE, "Oferton", attractionsList, 5);
		
		promotionsList.add(promotion);
				
		roberto.buyPromotion(promotion); // Compra la Promocion "promotion".-
		
		assertEquals(90, roberto.getBudget(), 0);
		assertEquals(95.5, roberto.getTime(), 0);
		
		assertEquals(promotionsList, roberto.getListOfPromotions());
		
		assertTrue(roberto.havePromotion(promotion));	//	Comprueba que ya posee la promocion en sus compras.-
		
		// Intenta comprar la misma procion nuevamente.-
		
		roberto.buyPromotion(promotion);	// Al ya tenerla promocion, la compra no se realiza.-
		
		assertEquals(90, roberto.getBudget(), 0);	// Mantiene el mismo dinero.-
		assertEquals(95.5, roberto.getTime(), 0);	// Mantiene el mismo Tiempo.-
		
		assertEquals(promotionsList, roberto.getListOfPromotions());
	
	}
	
	@Test
	public void buyPromotionWithOwnedAttractionTest() {
		
		// Comprar una promocion que contiene una Atraccion que ya poseemos.-
		
		// -Demuestra que no se efectuara la compra por ya poseer un producto de la lista de
		// -productos de la promocion.-
		
		roberto.buyAttraction(moria); // Compro atracciones.-
		
		attractionsList.add(moria); // Carga lista para comparar poder compararla con la lista de Atracciones de Roberto.-
		
		assertEquals(90, roberto.getBudget(), 0);
		assertEquals(98, roberto.getTime(), 0);
		
		// Intento comprar promocion que contiene una atraccion ya comprada.-
						
		attractionsList.add(moria);
		attractionsList.add(minasTirith); // Carga lista de comparar.-
		
		promotion = new PromotionAbsolute(2, PromotionType.ABSOLUTE, "Oferton", attractionsList, 5);		
		
		promotionsList.add(promotion); // Carga lista para comparar poder compararla con la lista de Promociones de Roberto.-
				
		roberto.buyPromotion(promotion); // Intenta comprar promocion, pero no lo logro por tener la atraccion moria ya adquirida.-
		
		assertEquals(90, roberto.getBudget(), 0);
		assertEquals(98, roberto.getTime(), 0);
		
		assertNotEquals(promotionsList, roberto.getListOfPromotions()); // No agrega la Promocion "promotion" a la lista.-
		assertNotEquals(attractionsList,roberto.getListOfAttractions());
		
	}
	
	@Test
	public void buyAttractionWithOwnedPromotionTest() {
		
		// Comprar una Atraccion que esta contenida en una Promocion que ya poseemos.-
		
		// -Demuestra que no se efectuara la compra por ya poseer el producto en una lista de
		// -productos de una promocion anteriormente adquirida.-
		
		attractionsList.add(moria);
		attractionsList.add(minasTirith); // Carga lista de promocion.-
		
		promotion = new PromotionAbsolute(2, PromotionType.ABSOLUTE, "Oferton", attractionsList, 5);
		
		promotionsList.add(promotion); // Carga lista para comparar.-
				
		roberto.buyPromotion(promotion); // Intenta comprar promocion.-
		
		assertEquals(90, roberto.getBudget(), 0);
		assertEquals(95.5, roberto.getTime(), 0);
		
		
		// Intento comprar promocion que contiene una atraccion ya comprada.-
		
		roberto.buyAttraction(moria); // Compro atracciones.-
		
		attractionsList.add(moria); // Carga lista para comparar.-
		
		assertEquals(90, roberto.getBudget(), 0);
		assertEquals(95.5, roberto.getTime(), 0);
		
		assertEquals(promotionsList, roberto.getListOfPromotions()); // Agrega la promocion a la lista		
		
	}
	
	@Test
	public void calculateTimeAndGoldSpentTest() {
		
		// Calcula Tiempo y Dinero gastado en nuestro itinerario.-
		
		roberto.buyAttraction(moria);
		roberto.buyAttraction(minasTirith);
		roberto.calculateTimeAndGoldSpent();
				
		assertEquals(15, roberto.getTotalGold(), 0);
		assertEquals(4.5, roberto.getTotalTime(), 0);
		
	}
	
	@Test
	public void runOutOfAnAttraction() {
		
		// Quedarse sin atracción.-
		
		// -Demuestra que tras la compra de un usuario sobre una atraccion esta pierde un cupo
		
		assertEquals(6, moria.getQuota());
		
		roberto.buyAttraction(moria);
		gandalf.buyAttraction(moria);
		sam.buyAttraction(moria);
		galadriel.buyAttraction(moria);
		frodo.buyAttraction(moria);
		meriadoc.buyAttraction(moria);
		
		assertEquals(0, moria.getQuota());
				
	}
	
	@Test
	public void updateTheQuotaOfAnAttractionByPurchasingAPromotion() {
		
		// Actualizar cupo de una atracción por compra de una promocion.-
		
		// -Demuestra que tras la compra de una Promocion, cada atraccion contenida pierde un cupo.-
		
		attractionsList.add(moria);
		attractionsList.add(minasTirith); // Carga lista de promocion.-
		
		promotion = new PromotionAbsolute(2, PromotionType.ABSOLUTE, "Oferton", attractionsList, 5);
		
		assertEquals(6, moria.getQuota());
		
		roberto.buyPromotion(promotion);
		
		assertEquals(5, moria.getQuota());
		
	}
	
}