package mru.tsc.model;

/**
 * Boardgames class must have a defined minimum and maximum amount of players
 * as well as a defined list of designers. 
 * Board games can have a 7, 8, or 9 as the first digit in the serial number.
 * @author Joseph Kim
 */
public class Boardgames extends Toy{
	private int minimumPlayer;
	private int maximumPlayer;
	private String designerName;
	
	//Constructor for new Board Game object
	public Boardgames (String serialNumber, String toyName, String brandName, double price, int availableCount, 
			           int ageRange, int minimumPlayer, int maximumPlayer, String designerName) {
		super(serialNumber, toyName, brandName, price, availableCount, ageRange);
		this.minimumPlayer = minimumPlayer;
		this.maximumPlayer = maximumPlayer;
		this.designerName = designerName;
	}
	
	//Accessor methods of a board game	
	public int getMinimum() { return minimumPlayer; }
	
	public int getMaximum() { return maximumPlayer; }
	
	public String getDesignerName() { return designerName; }
	
	//Mutator methods of a board game	
	public void setMinimum(int minimumPlayer) { this.minimumPlayer = minimumPlayer;	}
	
	public void setMaximum(int maximumPlayer) { this.maximumPlayer = maximumPlayer;	}
	
	public void setDesignerName (String designerName) {	this.designerName = designerName; }
	
	//Boardgames toString method
	public String toString() {
		return serialNumber +"," +toyName +"," +brandName +"," +price +"," +availableCount +",+" +ageRange +"," 
	           +minimumPlayer +"-" +maximumPlayer +"," +designerName;
	}
}
