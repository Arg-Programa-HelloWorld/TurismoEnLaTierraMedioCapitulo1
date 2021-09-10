package turismo_capitulo_I;

import java.util.ArrayList;

public class PromotionAyB extends Promotion {

	public PromotionAyB(int id, PromotionType promotionType, String name, ArrayList<Attraction> attractionList) {
		
		super(id, promotionType, name, attractionList);

		calculatePrice();
		
	}

	@Override
	public void calculatePrice() {
		
		double time = 0;
		double cost = 0;
		double discount = attractionList.get(attractionList.size() - 1).getCost();
		
		for (int i = 0; i < attractionList.size(); i++) {
			
			cost += attractionList.get(i).getCost();
			time += attractionList.get(i).getTime();
			//System.out.println(attraction.getName());
			
		}
		
		super.time = time;
		super.cost = cost - discount;
		super.discount = discount;
				
	}
	
}
