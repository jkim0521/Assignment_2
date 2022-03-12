package mru.tsc.model;

/**
 * The Toy class is the parent of the Figures, Animals, Puzzles, 
 * and Boardgames classes, which contains characteristics that are 
 * shared between all toys within the database. 
 * @author Joseph Kim & Skylar Wiltse
 *
 */
public class Toy {
	protected String serialNumber;
	protected String toyName;
	protected String brandName;
	protected double price;
	protected int availableCount;
	protected int ageRange;
	
	//Constructor for Toy
	public Toy (String serialNumber, String toyName, String brandName, double price, int availableCount, int ageRange) {
		this.serialNumber = serialNumber;
		this.toyName = toyName;
		this.brandName = brandName;
		this.price = price;
		this.availableCount = availableCount;
		this.ageRange = ageRange;
	}
	
	//Accessor methods of a toy
	public String serialNumber() { return serialNumber; }
	
	public String getToyName() { return toyName; }
	
	public String getBrandName() { return brandName; }
	
	public double getPrice() { return price; }
	
	public int getAvailableCount() { return availableCount; }
	
	public int getAgeRange() { return ageRange; }
	
	//Mutator methods of a toy
	public void setSN (String serialNumber) {this.serialNumber = serialNumber;}
	
	public void setToyName(String toyName) { this.toyName = toyName; }
	
	public void setBrandName(String brandName) { this.brandName = brandName; }
	
	public void setPrice(double price) { this.price = price; }
	
	public void setAvailableCount(int availableCount) { this.availableCount = availableCount; }
	
	public void setAgeRange(int ageRange) { this.ageRange = ageRange; }
}
