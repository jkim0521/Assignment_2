package mru.tsc.model;

/**
 * Boardgames class must have a defined minimum and maximum amount of players
 * as well as a defined list of designers. 
 * Board games can have a 7, 8, or 9 as the first digit in the serial number.
 * @author Joseph Kim
 */
public class Boardgames extends Toy{
	private String serialNumber;
	private int minimumPlayer;
	private int maximumPlayer;
	private String designerName;
	
	//Accessor methods of a board game
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public int getMinimum() {
		return minimumPlayer;
	}
	
	public int getMaximum() {
		return maximumPlayer;
	}
	
	public String getDesignerName() {
		return designerName;
	}
	
	//Mutator methods of a board game
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public void setMinimum(int minimumPlayer) {
		this.minimumPlayer = minimumPlayer;
	}
	
	public void setMaximum(int maximumPlayer) {
		this.maximumPlayer = maximumPlayer;
	}
	
	public void setDesignerName (String designerName) {
		this.designerName = designerName;
	}
}
