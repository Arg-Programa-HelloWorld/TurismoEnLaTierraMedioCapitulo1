package turismo_capitulo_I;

import java.util.ArrayList;

public abstract class Promotion {

	protected int id;			// ID
	protected PromotionType promotionType;
	protected String name;
	protected ArrayList<Attraction> attractionList = new ArrayList<Attraction>();
	protected double time = 0;
	protected double cost = 0;
	protected double discount = 0;
	
	public Promotion(int id, PromotionType promotionType, String name, ArrayList<Attraction> attractionList) {
		
		this.id = id;
		this.promotionType = promotionType;
		this.name = name;
		this.attractionList = attractionList;
		
	}

	
	public void calculatePrice() {
		
	}

	public int getId() {
		return id;
	}


	protected ArrayList<Attraction> getAttractionsList() {
		return attractionList;
	}


	public double getCost() {
		return cost;
	}


	public double getTime() {
		return time;
	}


	public PromotionType getPromotionType() {
		return promotionType;
	}


	public String getName() {
		return name;
	}

}