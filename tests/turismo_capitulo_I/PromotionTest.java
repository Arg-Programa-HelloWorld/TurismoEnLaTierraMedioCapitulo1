package turismo_capitulo_I;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PromotionTest {
	
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
	

	@Test
	public void ICreateAPercentagePromotion() {
	
		//	1, PromotionType.PERCENTAGE,Pack Aventura,8,4,20
		
		ArrayList<Attraction> attractionList = new ArrayList<Attraction>();	
		
		//	8, Bosque Negro, 3, 4, 12, AttractionType.ADVENTURE
		//	4, Mordor, 25, 3, 4, AttractionType.ADVENTURE
		Attraction bosqueNegro = new Attraction(8, "Bosque Negro", 3, 4, 12, AttractionType.ADVENTURE);
		Attraction mordor = new Attraction(4, "Mordor", 25, 3, 4, AttractionType.ADVENTURE);
	
		attractionList.add(bosqueNegro);
		attractionList.add(mordor);
		
		//	Promotion with discount percentage.-	
		Promotion promotion = new PercentagePromotion(1, PromotionType.PERCENTAGE, "Pack Aventura", attractionList, 20);
		
		assertEquals(1, promotion.getId());
		assertEquals("Pack Aventura",promotion.getName());
		
		assertEquals(8, promotion.getAttractionsList().get(0).getId());
		assertEquals("Bosque Negro",promotion.getAttractionsList().get(0).getName());
		assertEquals(4, promotion.getAttractionsList().get(1).getId());
		assertEquals("Mordor",promotion.getAttractionsList().get(1).getName());
		
		//System.out.println(promotion.getCost());
		//System.out.println(promotion.getTime());
		
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
		
		assertEquals(PromotionType.PERCENTAGE, promotion.getPromotionType());
		
	}
	
	@Test
	public void ICreateAAbsolutePromotion() {

		//	2,PromotionType.ABSOLUTE,Pack Degustacion,6,3,2
		
		ArrayList<Attraction> attractionList = new ArrayList<Attraction>();	
		
		
		//	3, La Comarca, 3, 6.5, 150, AttractionType.TASTING
		//	6, Lothlorien, 35, 1, 30, AttractionType.TASTING
		Attraction laComarca = new Attraction(3, "La Comarca", 3, 6.5, 150, AttractionType.TASTING);
		Attraction lothlorein = new Attraction(6, "Lothlorien", 35, 1, 30, AttractionType.TASTING);
	
		attractionList.add(laComarca);
		attractionList.add(lothlorein);
		
		//	Promotion with absolute discount.-	
		Promotion promotion = new PromotionAbsolute(2, PromotionType.ABSOLUTE, "Pack Degustacion", attractionList,2);
		
		assertEquals(2, promotion.getId());
		assertEquals("Pack Degustacion", promotion.getName());
		
		assertEquals(3, promotion.getAttractionsList().get(0).getId());
		assertEquals("La Comarca",promotion.getAttractionsList().get(0).getName());
		assertEquals(6, promotion.getAttractionsList().get(1).getId());
		assertEquals("Lothlorien",promotion.getAttractionsList().get(1).getName());
		
		//System.out.println(promotion.getCost());
		//System.out.println(promotion.getTime());
		
		// Este tipo de promotion realiza un descuento de un X monto fijo, siendo 2 el de esta promotion.-
		// Las dos Atracciones que incluye tienen un presio de:
		// -La Comarca = $3
		// -Lothlorien = $35
		// Que harían un total de = 3 + 35 => 38
		// y si le aplicamos un descuento del 2
		// 38 - 2 = $36
		assertEquals(36, promotion.getCost(), 0.001);
		
		// Las dos Atracciones que incluye tienen un tiempo individual de: 
		// -Bosque Negro = 4hs.
		// -Mordor = 3hs.
		// Tiempo que se necesita para la promotion es de 4 + 3 = 7hs.
		assertEquals(7.5, promotion.getTime(), 0.001);
		
		assertEquals(PromotionType.ABSOLUTE, promotion.getPromotionType());
		
	}
	
	@Test
	public void ICreateAPromotionAandB() {

		//	3, PromotionType.A_AND_B,Pack Paisajes,2,5,7
		
		ArrayList<Attraction> attractionList = new ArrayList<Attraction>();	
		
		//	2, Minas Tirith, 5, 2.5, 25, AttractionType.SCENERY
		//	5, Abismo de Helm, 5, 2, 15, AttractionType.SCENERY
		//	7, Erebor, 12, 3, 32, AttractionType.SCENERY
		
		Attraction minasTirith = new Attraction(2, "Minas Tirith", 5, 2.5, 25, AttractionType.SCENERY);
		Attraction abismoDeHelm = new Attraction(5, "Abismo de Helm", 5, 2, 15, AttractionType.SCENERY);
		Attraction erebor = new Attraction(7, "Erebor", 12, 3, 32, AttractionType.SCENERY);
				
		attractionList.add(minasTirith);
		attractionList.add(abismoDeHelm);
		attractionList.add(erebor);
		
		//	Discount promotion of the total of the last of three products.-	
		Promotion promotion = new PromotionAyB(3, PromotionType.A_AND_B, "Pack Paisajes", attractionList);
		
		assertEquals(3, promotion.getId());
		assertEquals(PromotionType.A_AND_B, promotion.getPromotionType());
		assertEquals("Pack Paisajes", promotion.getName());
		
		assertEquals(2, promotion.getAttractionsList().get(0).getId());
		assertEquals("Minas Tirith",promotion.getAttractionsList().get(0).getName());
		assertEquals(5, promotion.getAttractionsList().get(1).getId());
		assertEquals("Abismo de Helm",promotion.getAttractionsList().get(1).getName());
		assertEquals(7, promotion.getAttractionsList().get(2).getId());
		assertEquals("Erebor",promotion.getAttractionsList().get(2).getName());
		
		//System.out.println(promotion.getCost());
		//System.out.println(promotion.getTime());
		
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
		
		// Las dos Atracciones que incluye tienen un tiempo individual de 
		// -Minas Tirith = 2.5hs. 
		// -Abismo de Helm = 2hs.
		// -Erebor = 3hs.
		// Tiempo que se necesita para la promotion es de 4 + 3 = 7
		assertEquals(7.5, promotion.getTime(), 0.001);
						
	}
	
}