package mru;

/**
 * Puzzles class includes a char to represent the type of puzzle
 * which can either be mechanical(M), cryptic(C), logical(L), trivia(T),
 * or riddle(R) related. 
 * Puzzles can have a 4, 5, or 6 as the first digit in the serial number.
 * @author Joseph Kim
 */
public class Puzzles extends Toy{
	private String serialNumber;
	private char puzzleType;
	
	//Accessor methods of a puzzle
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public char getPuzzleType() {
		return puzzleType;
	}
	
	//Mutator methods of a puzzle
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public void setPuzzleType(char puzzleType) {
		this.puzzleType = puzzleType;
	}
}
