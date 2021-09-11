package turismo_capitulo_I;

import java.util.*;

public class User {

	
	private int id;							// ID
	private String name;					// nombre
	private double budget;					// presupuesto
	private double time;					// tiempo que dispone
	private AttractionType preferences;		// preferencias
	private double totalTime;
	private double totalGold;
	
	private boolean attractionFlag = false;

	private ArrayList<Attraction> listOfAttractions = new ArrayList<Attraction>();
	private ArrayList<Promotion> listOfPromotions = new ArrayList<Promotion>();

	public User(int id, String name, double budget, double time, AttractionType preferences) {
		
		this.id = id;
		this.name = name;					// nombre
		this.budget =  budget;				// presupuesto
		this.time = time;					// tiempo que dispone

		this.preferences = preferences;		// preferencias

	}
	
	public int getId() {
		return id;
	}	
		
	protected String getName() {
		return name;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	protected double getBudget() {
		return budget;
	}


	public void setTime(double time) {
		this.time = time;
	}
	
	protected double getTime() {
		return time;
	}

	protected AttractionType getPreferences() {
		return preferences;
	}
	
	public double getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}

	public double getTotalGold() {
		return totalGold;
	}

	public void setTotalGold(double totalGold) {
		this.totalGold = totalGold;
	}
	
	public boolean getAttractionFlag() {
		return attractionFlag;
	}

	public void setAttractionFlag(boolean haveAttractionFlag) {
		this.attractionFlag = haveAttractionFlag;
	}

	protected ArrayList<Attraction> getListOfAttractions() {
		return listOfAttractions;
	}

	protected void setListOfAttractions(Attraction atraccion) {
		this.getListOfAttractions().add(atraccion);
	}
	
	public ArrayList<Promotion> getListOfPromotions() {
		return listOfPromotions;
	}

	public void setListOfPromotions(Promotion newPromotion) {
		this.getListOfPromotions().add(newPromotion);
	}
	
	
	protected boolean haveAttraction(Attraction newAttraction) { 
		
		boolean result = false;	// Va a devolver este 'false' si no encuentra la Atraccion en su lista de compras
		
		for(Attraction attraction : this.getListOfAttractions()) { 
		
			if (attraction == newAttraction) { // Consulta si el user ya tiene esa atraccion comprada.-
			
				View.colorearMensaje(View.cyan,"[ You already have that product!!!");
				View.colorearMensaje(View.cyan,"[ " + attraction.getId() + " - The Attraction: " + attraction.getName());
				System.out.println("");
				
				result = true;	//
				
				break; // Detiene el for al cumplirse la igualdad.- (Encontrar la atraccion en su lista)
				
			}
		}
		
		for(Promotion promotion : this.getListOfPromotions()) {
			
			for(Attraction at : promotion.getAttractionsList()) {
			
				if (at.getId() == newAttraction.getId()) {
			
					result = true;
						
				}
					
			}
							
		}
			
				
		return result;
		
	}
	
	protected boolean havePromotion(Promotion newPromotion) { 
		
		boolean result = false;	// Va a devolver este 'false' si no encuentra la Atraccion en su lista de compras
		
		for(Promotion promotion : this.getListOfPromotions()) { 
		
			if (promotion == newPromotion) { // Consulta si el user ya tiene esa atraccion comprada.-
			
				View.colorearMensaje(View.cyan,"[ You already have that product!!!");
				View.colorearMensaje(View.cyan,"[ " + promotion.getId() + " - The Promotion: " + promotion.getName());
				System.out.println("");
				
				result = true;	//
				
				break; // Detiene el for al cumplirse la igualdad.- (Encontrar la atraccion en su lista)
				
			}
		}
		
		return result;
		
	}
	
	protected boolean haveMoney(double cost) {
		
		if (cost <= this.getBudget()) {
		
			return true;	// Tengo dinero disponible!!
			
		} else {			
			
			View.colorearMensaje(View.red,"[---------------------------------------------------------------------]");
			View.colorearMensaje(View.red,"[ Your budget is insufficient to purchase this product!!!             ]"); // Si Users no posee budget suficiente
			View.colorearMensaje(View.red,"[---------------------------------------------------------------------]");
			return false;	// No tengo dinero disponible!!
			
			
		}
	}
		
	protected boolean haveTime(double time) {
		
		if (time <= this.getTime()) {
		
			return true;	// Tengo tiempo disponible!!
			
						
		} else {
			
			View.colorearMensaje(View.red,"[---------------------------------------------------------------------]");
			View.colorearMensaje(View.red,"[ Your do not have enough time to purchase this product!!!            ]"); // Si Users no posee budget suficiente
			View.colorearMensaje(View.red,"[---------------------------------------------------------------------]");
			
			return false;	// No tengo tiempo disponible!!
			
		}
		
	}
	
	protected void pay(double cost) {		
		
		this.setBudget(this.getBudget() - cost);
		
	}
	
	protected void spendTime(double time) {
		
		this.setTime(this.getTime() - time);
		
	}
	
	protected void buyAttraction(Attraction newAttraction) {
		
		if ( !this.haveAttraction(newAttraction) && this.haveMoney(newAttraction.getCost()) && this.haveTime(newAttraction.getTime()) ) {
		
			// Si no tengo la atraccion        y       Si tengo dinero suficiente        y        Si tengo tiempo suficiente
			
			this.pay(newAttraction.getCost());			// Pago
			this.spendTime(newAttraction.getTime()); 	// Uso tiempo
			this.setListOfAttractions(newAttraction); 	// Agrego la atracion a la lista
			
		}	
		
	}	
	
	protected void buyPromotion(Promotion newPromotion) {
		
		/*---------------- NEW CODE ----------------*/
		
		int flag = 0 ;
						
		if ( !this.havePromotion(newPromotion) && this.haveMoney(newPromotion.getCost()) && this.haveTime(newPromotion.getTime()) ){
			
			for(Attraction attraction : newPromotion.getAttractionsList()) {
				
				if (this.haveAttraction(attraction)) {
						
					flag ++;
							
				}
											
			}
			
			if(flag == 0) {
			
				this.pay(newPromotion.getCost());			// Pago
				this.spendTime(newPromotion.getTime()); 	// Uso tiempo
				this.setListOfPromotions(newPromotion); 	// Agrego la promocion a la lista
								
			} else {
				
				View.colorearMensaje(View.red,"[---------------------------------------------------------------------]");
				View.colorearMensaje(View.red,"[ You already own some products of this promotion!!!                  ]");
				View.colorearMensaje(View.red,"[---------------------------------------------------------------------]");
						
			}		
			
		}

	}
	
	protected void calculateTotalTime() {
		
		double amountOfTime = 0;
				
		for (Attraction attraction : this.getListOfAttractions()) {
			
			amountOfTime += attraction.getTime();
			
		}
		
		for (Promotion promotion : this.getListOfPromotions()) {
			
			amountOfTime += promotion.time;
						
		}
		
		this.setTotalTime(amountOfTime);
		
	}
	
	protected void calculateTotalGold() {
		
		double amountOfGold = 0;
		
		for (Attraction attraction : this.getListOfAttractions()) {
			
			amountOfGold += attraction.getCost();
			
		}
		
		for (Promotion promotion : this.getListOfPromotions()) {
			
			amountOfGold += promotion.cost;		
			
		}
		
		this.setTotalGold(amountOfGold);
			
	}
	
	protected void calculateTimeAndGoldSpent() {
		
		this.calculateTotalTime();
		this.calculateTotalGold();
				
	}
	
}
























