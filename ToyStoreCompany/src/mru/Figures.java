package mru;

/**
 * Figures class include toys that are action figures(A), dolls(D), 
 * or historical figurines(H). 
 * Figures have either a 0 or 1 as the first digit in the serial number.
 * @author Joseph Kim
 */
public class Figures extends Toy{
	private String serialNumber;
	private char classification;
	
	//Accessor methods of a figure
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public char getClassification() {
		return classification;
	}
	
	//Mutator methods of a figure
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setClassification(char classification) {
		this.classification = classification;
	}
}
