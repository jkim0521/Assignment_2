package mru.tsc.model;

/**
 * Puzzles class includes a char to represent the type of puzzle
 * which can either be mechanical(M), cryptic(C), logical(L), trivia(T),
 * or riddle(R) related. 
 * Puzzles can have a 4, 5, or 6 as the first digit in the serial number.
 * @author Joseph Kim
 */
public class Puzzles extends Toy{
	private char puzzleType;
	
	//Constructor for new Puzzle object
	public Puzzles (String serialNumber, String toyName, String brandName, double price, int availableCount, int ageRange, char puzzleType) {
		super(serialNumber, toyName, brandName, price, availableCount, ageRange);
		this.puzzleType = puzzleType;
	}
	
	//Accessor methods of a puzzle	
	public char getPuzzleType() { return puzzleType; }
	
	//Mutator methods of a puzzle	
	public void setPuzzleType(char puzzleType) { this.puzzleType = puzzleType; }
	
	//Puzzles toString method
	public String toString() {
		return serialNumber +"," +toyName +"," +brandName +"," +price +"," +availableCount +",+" +ageRange +"," +puzzleType;
	}
}
