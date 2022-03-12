package mru.tsc.model;

/**
 * Figures class include toys that are action figures(A), dolls(D), 
 * or historical figurines(H). 
 * Figures have either a 0 or 1 as the first digit in the serial number.
 * @author Joseph Kim & Skylar Wiltse
 */
public class Figures extends Toy{
	private char classification;
	
	//Constructor for new Figure object
	public Figures (String serialNumber, String toyName, String brandName, double price, int availableCount, int ageRange, char classification) {
		super(serialNumber, toyName, brandName, price, availableCount, ageRange);
		this.classification = classification;
	}
	
	//Accessor methods of a figure	
	public char getClassification() { return classification; }
	
	//Mutator methods of a figure
	public void setClassification(char classification) { this.classification = classification; }
	
	//Figures toString method
	public String toString() {
		return serialNumber +"," +toyName +"," +brandName +"," +price +"," +availableCount +",+" +ageRange +"," +classification;
	}
}
