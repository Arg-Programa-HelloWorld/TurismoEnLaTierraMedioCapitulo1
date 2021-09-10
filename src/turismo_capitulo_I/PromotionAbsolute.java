package turismo_capitulo_I;

import java.util.ArrayList;

public class PromotionAbsolute extends Promotion {

	double absoluteDiscount;
	
	public PromotionAbsolute(int id, PromotionType promotionType, String name, ArrayList<Attraction> attractionList,
			double absoluteDiscount) {
		
		super(id, promotionType, name, attractionList);
		this.absoluteDiscount = absoluteDiscount;
		
		calculatePrice();
		
	}

	@Override
	public void calculatePrice() {
		
		double time = 0;
		double cost = 0;
		double discount = absoluteDiscount;
		
		for (Attraction attraction : attractionList) {
			
			cost += attraction.getCost();
			time += attraction.getTime();
			//System.out.println(attraction.getName());
			
		}
		
		super.time = time;
		super.cost = cost - discount;
		super.discount = discount;
				
	}
	
}
