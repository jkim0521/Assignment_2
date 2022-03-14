package mru.tsc.view;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Menu class deals with printing out various messages
 * including the welcome message and menu options. User input 
 * is gathered here and is returned to the Navigation class
 * @author Joseph Kim
 *
 */
public class Menu {
	Scanner option = new Scanner(System.in);

	/**
	 * Prints out the welcome message, shown upon starting the program
	 */
	public void welcomeMessage() {
		System.out.println("     **********************************");
		System.out.println("     *  WELCOME TO TOY STORE COMPANY  *");
		System.out.println("     **********************************");
	}
	
	/**
	 * Prints out the main menu options
	 * @return user input for menu navigation
	 */
	public String mainMenu() {
		String choice = "";
		System.out.println("\nHow may we help you?");
		System.out.println("\n(1) Search Inventory and Purchase Toy");
		System.out.println("(2) Add New Toy");
		System.out.println("(3) Remove Toy");
		System.out.println("(4) Save & Quit");
		System.out.println("\nEnter Option: ");
		choice = option.nextLine();
		return choice;
	}
	
	/**
	 * Prints out the search menu options
	 * @return user input for menu navigation
	 */
	public String searchMenu() {
		String choice = "";
		System.out.println("\nFind Toys With: ");
		System.out.println("\n(1) Serial Number (SN)");
		System.out.println("(2) Toy Name");
		System.out.println("(3) Type");
		System.out.println("(4) Gift Suggestion");
		System.out.println("(5) Back to Main Menu");
		System.out.println("\nEnter Option: ");
		choice = option.nextLine();
		return choice;
	}
	
	public String searchSN() {
		String sn = "";
		System.out.println("\nEnter Serial Number: ");
		sn = option.nextLine();
		return sn;
	}
	
	public String searchName() {
		String name = "";
		System.out.println("\nEnter Toy Name: ");
		name = option.nextLine();
		return name;
	}
	
	public String searchType() {
		String type = "";
		System.out.println("\nEnter Type: ");
		type = option.nextLine();
		return type;
	}
	
	/**
	 * Prompt the user to enter a valid serial number for adding a toy
	 * @return
	 */
	public String enterSN() {
		String sn = "";
		System.out.println("\nEnter Serial Number: ");
		sn = option.nextLine();
		return sn;
	}
	
	/**
	 * Prompt the user to enter a valid name for the toy when adding a toy
	 * @return
	 */
	public String enterName() {
		String name = "";
		System.out.println("\nEnter Toy Name: ");
		name = option.nextLine();
		return name;
	}
	
	/**
	 * Prompt the user to enter a valid name for the toy when adding a toy
	 * @return
	 */
	public String enterBrand() {
		String brand = "";
		System.out.println("\nEnter Toy Brand: ");
		brand = option.nextLine();
		return brand;
	}
	
	/**
	 * Prompt the user to enter a valid price for the toy when adding a toy
	 * The price is rounded to two decimal places before it is returned
	 * @return
	 */
	public double enterPrice() {
		double price;
		System.out.println("\nEnter Toy Price: ");
		price = option.nextDouble();
		price = Math.round(price*100.0)/100.0;
		return price;
	}
	
	/**
	 * Prompt the user to enter number of toys available for purchase in the
	 * current inventory, this should decrement as toys are purchased
	 * @return
	 */
	public int enterCount() {
		int availableCount;
		System.out.println("\nEnter Available Counts: ");
		try {
			availableCount = option.nextInt();
			return availableCount;
		}
		catch (InputMismatchException imm) {
			System.out.print("");
		}
		return -1;
	}
	
	/**
	 * Prompt the user to enter an age that is recommended for the toy
	 * @return
	 */
	public int enterAge() {
		int age;
		System.out.println("\nEnter Appropriate Age: ");
		try {
			age = option.nextInt();
			return age;
		}
		catch (InputMismatchException imm) {
			System.out.print("");
		}
		return -1;
	}
	
	/**
	 * Prompt the user to enter a valid name for the toy when adding a toy
	 * @return
	 */
	public char enterClassification() {
		System.out.println("\nEnter a classification (A, D, H): ");
		try {
			char classification = option.next().charAt(0);
			switch(classification) {
			case 'a': //fall through
			case 'A': classification = Character.toUpperCase(classification);
					  return classification;
			case 'd': //fall through
			case 'D': classification = Character.toUpperCase(classification);
					  return classification;
			case 'h': //fall through
			case 'H': classification = Character.toUpperCase(classification);
					  return classification;
			default: return 'Z';
			}
		}
		catch (InputMismatchException imm) {
			System.out.print("");
		}
		return 'Z';
	}
	
	/**
	 * Prompt the user to enter a valid material for a stuffed Animal when adding a toy
	 * @return
	 */
	public String enterMaterial() {
		String material = "";
		option.nextLine(); //conusme leftover new line
		System.out.println("\nEnter Material: ");
		material = option.nextLine();
		return material;
	}
	
	/**
	 * Prompt the user to enter a valid name for the toy when adding a toy
	 * @return
	 */
	public char enterSize() {
		System.out.println("\nEnter a size (S, M, L): ");
		try {
			char size = option.next().charAt(0);
			switch(size) {
			case 's': //fall through
			case 'S': size = Character.toUpperCase(size);
					  return size;
			case 'm': //fall through
			case 'M': size = Character.toUpperCase(size);
					  return size;
			case 'l': //fall through
			case 'L': size = Character.toUpperCase(size);
					  return size;
			default: return 'Z';
			}
		}
		catch (InputMismatchException imm) {
			System.out.print("");
		}
		return 'Z';
	}
	
	/**
	 * Prompt the user to enter a valid name for the toy when adding a toy
	 * @return
	 */
	public char enterPuzzle() {
		System.out.println("\nEnter a Puzzle Type (M, C, L, T, R): ");
		try {
			char puzzleType = option.next().charAt(0);
			switch(puzzleType) {
			case 'm': //fall through
			case 'M': puzzleType = Character.toUpperCase(puzzleType);
					  return puzzleType;
			case 'c': //fall through
			case 'C': puzzleType = Character.toUpperCase(puzzleType);
					  return puzzleType;
			case 'l': //fall through
			case 'L': puzzleType = Character.toUpperCase(puzzleType);
					  return puzzleType;
			case 't': //fall through
			case 'T': puzzleType = Character.toUpperCase(puzzleType);
					  return puzzleType;
			case 'r': //fall through
			case 'R': puzzleType = Character.toUpperCase(puzzleType);
					  return puzzleType;
			default: return 'Z';
			}
		}
		catch (InputMismatchException imm) {
			System.out.print("");
		}
		return 'Z';
	}
	
	/**
	 * Prompt the user to enter an integer that represents the minimum amount of players for a board game.
	 * There can be no less than one player
	 * @return
	 */
	public int enterMinimum() {
		int min;
		System.out.println("\nEnter Minimum Number of Players: ");
		try {
			min = option.nextInt();
			return min;
		}
		catch (InputMismatchException imm) {
			System.out.print("");
		}
		return -1;
	}
	
	/**
	 * Prompt the user to enter an integer that represents the maximum amount of players for a board game
	 * The maximum cannot be less than the minimum amount of players
	 * @return
	 */
	public int enterMaximum() {
		int max;
		System.out.println("\nEnter Maximum Number of Players: ");
		try {
			max = option.nextInt();
			return max;
		}
		catch (InputMismatchException imm) {
			System.out.print("");
		}
		return -1;
	}
	
	/**
	 * Prompt the user to enter a valid material for a stuffed Animal when adding a toy
	 * @return
	 */
	public String enterDesigner() {
		String designer = "";
		option.nextLine(); //conusme leftover new line
		System.out.println("\nEnter Designer Names(Use ',' to separate the names): ");
		designer = option.nextLine();
		return designer;
	}
	
	/**
	 * Verifies the length of a given serial number to match the system's requirements
	 * of 10 digits (9 digits following after the significant digit).
	 * @param serialNumber
	 * @return returns true if the serial number is an appropriate length
	 */
	public boolean verifySN(String serialNumber) {
		String sn = serialNumber;
		int length = sn.length();
		if (length == 10) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verifies the type of toy that is being recorded by examining the significant digit
	 * of the given serial number (0-1 figures, 2-3 animals, 4-6 puzzles, 7-9 boardgames). 
	 * @param serialNumber
	 * @return the significant digit of the serial number
	 */
	public int verifyType(String serialNumber) {
		String sn = serialNumber;
		String digit = sn.substring(0,1);
		try {
			int sigdig = Integer.parseInt(digit);
			return sigdig;
		}
		catch (NumberFormatException nfe) {
			System.out.println("This is an invalid Serial Number! Please input only integers.");
		}
		return -1;
	}
	
	//Gift Methods
		public int qInput() {
			int choice;
			try {
				choice = option.nextInt();
				switch(choice) {
				case 1: return choice;
				default: System.out.println("\nSkipping...");
						 break;
				}
			}
				catch (InputMismatchException imm) {
					System.out.print("");
				}
				return 0;
		}
		
		public double qPrice() {		
			double price;
			price = option.nextDouble();
			price = Math.round(price*100.0)/100.0;
			return price;
		}
		
		public int qAge() {
			return option.nextInt();
		}
		
		public String qType(){
			String type = "";
			option.next();  //consume leftover newline
			type = option.next();
			type = type.toLowerCase();
			return type;
		}
		
		public String concatQuestions(double min, double max, int age, String type, int answered) {
			int questionsAnswered = answered;
			String suggestion= "";
			if(questionsAnswered >= 2) {
				//determine price range from answers
				double minimum = min;
				double maximum = max;
				String priceRange = "";
				if(minimum == 0.0 && maximum > 0.0) {
					priceRange = "$"+minimum +"0-" +maximum;
				}
				else if(minimum > 0.0 && maximum == 0.0) {
					priceRange = "$"+minimum +"+";
				}
				else if(minimum > 0.0 && maximum > 0.0) {
					priceRange = "$" +minimum +"-" +maximum;
				}
				else if(minimum == 0.0 && maximum == 0.0){
					priceRange = "No price range";
				}
				System.out.println("\n===================================================");
				System.out.println("\nThe results of the questions are the following: ");
				System.out.println("\nPrice Range: " +priceRange);
				System.out.println("\nAge Group: " +age +"+");
				System.out.println("\nType of Toy: " +type);
				System.out.println("===================================================");
				
				suggestion = "\nThis feature is not implemented yet!\n";
				return suggestion;
			}
			else {
				System.out.println("Not enough questions answered to make a suggestion!");
			}
			return "Z";
		}
		
		//End Gift Methods
	
	/**
	 * Method to re-prompt the user for input if initial
	 * input was incorrect
	 * @return
	 */
	public String badInput() {
	    String choice = "";
		System.out.println("\nEnter Option: ");
		choice = option.nextLine();
		return choice;
	}
	
	public void giftInstructions() {
		System.out.println("\nAnswer the following questions for your suggestion!");
		System.out.println("To answer a question, please enter a 1");
		System.out.println("However, you may enter any integer to skip the question if you are unsure");
	}
	
	/**
	 * Prints out the exit message when a user quits program
	 */
	public void exitMessage() {
		System.out.println("\nSaving data into database...");
		System.out.println("\n*********** THANKS FOR VISITING US! ***********");
		option.close();
	}
}
