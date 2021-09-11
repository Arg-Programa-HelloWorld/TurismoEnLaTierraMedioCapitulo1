package turismo_capitulo_I;

import static org.junit.Assert.*;

import org.junit.Test;

public class AttractionTest {
		
	@Test
	public void ICreateAnAttraction() {
	
		Attraction attraction = new Attraction(12,"Paso de Caradhras", 9, 8, 7, AttractionType.SCENERY);
				
		assertEquals(12, attraction.getId());
		assertEquals("Paso de Caradhras",attraction.getName());
		assertEquals(9.0, attraction.getCost(), 0.001);
		assertEquals(8.0, attraction.getTime(), 0.001);
		assertEquals(7.0, attraction.getQuota(), 0.001);
		assertEquals(AttractionType.SCENERY, attraction.getAttractionType());
			
	}
	
}