package mru.tsc.model;

/**
 * Animals class includes a String to represent the material of
 * the stuffed animal and a char that represents the size of the toy. 
 * Animals have either a 2 or 3 as the first digit in the serial number.
 * @author Joseph Kim
 */
public class Animals extends Toy{
	private String material;
	private char size;
	
	//Constructor for new Animal object
	public Animals (String serialNumber, String toyName, String brandName, double price, int availableCount, int ageRange, String material, char size) {
		super(serialNumber, toyName, brandName, price, availableCount, ageRange);
		this.material = material;
		this.size = size;
	}
	
	//Accessor methods of an animal	
	public String getMaterial() { return material; }
	
	public char getSize() { return size; }

	//Mutator methods of an animal	
	public void setMaterial(String material) { this.material = material; }
	
	public void setSize(char size) { this.size = size; }
	
	//Animals toString method
	public String toString() {
		return serialNumber +"," +toyName +"," +brandName +"," +price +"," +availableCount +",+" +ageRange +"," +material +"," +size;
	}
}
