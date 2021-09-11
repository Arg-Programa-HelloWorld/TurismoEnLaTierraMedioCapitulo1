package turismo_capitulo_I;

public class Attraction {

	// Costo de visita.-
	// Tiempo promedio para realizarla.-
	// Cupo de personas.-
	// Tipo de attraction: paisaje, de aventura, de desgustacion (Aventura, Paisaje, Degustacion).-

	private int id;			// ID
	private String name;	// nombre
	private double cost; 	// costo
	private double time; 	// tiempo
	private int quota; 		// cupo
	private AttractionType attractionType; // el tipo de attractionName1

	public Attraction() {

	}

	public Attraction(int id, String name, double cost, double time, int quota, AttractionType attractionType) {

		this.id = id;		// ID		
		this.name = name;   // nombre
		this.cost = cost;   // costo
		this.time = time;   // tiempo
		this.quota = quota; // cupo
		this.attractionType = attractionType; // el tipo de attraction.-

	}

	public String getName() {
		
		return name;
		
	}

	public double getCost() {
		
		return cost;
		
	}

	public double getTime() {
		
		return time;
		
	}
		
	public void setQuota(int quota) {
		this.quota = quota;
	}

	public int getQuota() {
		
		return quota;
		
	}

	public AttractionType getAttractionType() {
	
		return attractionType;
		
	}

	public int getId() {
		return id;
	}

}