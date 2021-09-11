package turismo_capitulo_I;

import java.util.ArrayList;

public class PercentagePromotion extends Promotion {

	private double percentageDiscount;
	
	public PercentagePromotion(int id, PromotionType promotionType, String name, ArrayList<Attraction> attractionList,
			double percentageDiscount) {
		
		super(id, promotionType, name, attractionList);
		this.percentageDiscount = percentageDiscount;
		
		this.calculatePrice();
		
	}	
	
	@Override
	public void calculatePrice() {
		
		double time = 0;
		double cost = 0;
		double discount = ((100 - percentageDiscount) / 100);
		
		for (Attraction attraction : super.attractionList) {
			
			cost += attraction.getCost();
			time += attraction.getTime();
			//System.out.println(attraction.getName());
			
		}
		
		super.time = time;
		super.cost = cost * discount;
		super.discount = cost - (cost * discount);
				
	}
	
}