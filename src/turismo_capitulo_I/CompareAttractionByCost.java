package turismo_capitulo_I;

import java.util.Comparator;

public class CompareAttractionByCost implements Comparator<Attraction> {

	@Override
	public int compare(Attraction attraction1, Attraction attraction2) {
		
		if (attraction1.getCost() > attraction2.getCost()) {
			return -1;			
		}else if (attraction1.getCost() > attraction2.getCost()) {
			return 0;
		}else {
			return 1;
		}		
		
	}

}
