package mru.tsc.model;

/**
 * Animals class includes a String to represent the material of
 * the stuffed animal and a char that represents the size of the toy. 
 * Animals have either a 2 or 3 as the first digit in the serial number.
 * @author Joseph Kim
 */
public class Animals extends Toy{
	private String serialNumber;
	private String material;
	private char size;
	
	//Accessor methods of an animal
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public char getSize() {
		return size;
	}

	//Mutator methods of an animal
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void setSize(char size) {
		this.size = size;
	}
}
