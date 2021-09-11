package turismo_capitulo_I;

import java.util.Comparator;

public class CompareAttractions implements Comparator<Attraction>{

	@Override
	public int compare(Attraction attraction1, Attraction attraction2) {
		
		int result = Double.compare(attraction2.getCost(), attraction1.getCost());
		
		if (result == 0) { // Si cost son iguales se compara por time
		
			result = Double.compare(attraction2.getTime(), attraction1.getTime());
			
			if (result ==0) { // Si time son inguales se compara por quota
			
				result = Integer.compare(attraction2.getQuota(), attraction1.getQuota());
				
			}
			
		}
		
		return result;
		
	}

}