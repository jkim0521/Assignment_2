package mru.tsc.model;

/**
 * The Toy class is the parent of the Figures, Animals, Puzzles, 
 * and Boardgames classes, which contains characteristics that are 
 * shared between all toys within the database. 
 * @author Joseph Kim
 *
 */
public class Toy {
	private String toyName;
	private String brandName;
	private double price;
	private int availableCount;
	private String ageRange;

	//Accessor methods of a toy
	public String getToyName() {
		return toyName;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getAvailableCount() {
		return availableCount;
	}
	
	public String getAgeRange() {
		return ageRange;
	}
	
	//Mutator methods of a toy
	public void setToyName(String toyName) {
		this.toyName = toyName;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
}
