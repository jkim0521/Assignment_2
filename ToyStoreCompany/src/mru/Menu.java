package mru;
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
	void welcomeMessage() {
		System.out.println("     **********************************");
		System.out.println("     *  WELCOME TO TOY STORE COMPANY  *");
		System.out.println("     **********************************");
	}
	
	/**
	 * Prints out the main menu options
	 * @return user input for menu navigation
	 */
	String mainMenu() {
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
	String searchMenu() {
		String choice = "";
		System.out.println("\nFind Toys With: ");
		System.out.println("\n(1) Serial Number (SN)");
		System.out.println("(2) Toy Name");
		System.out.println("(3) Type");
		System.out.println("(4) Back to Main Menu");
		System.out.println("\nEnter Option: ");
		choice = option.nextLine();
		return choice;
	}
	
	/**
	 * Method to re-prompt the user for input if initial
	 * input was incorrect
	 * @return
	 */
	String badInput() {
	    String choice = "";
		System.out.println("\nEnter Option: ");
		choice = option.nextLine();
		return choice;
	}
		
	/**
	 * Prints out the exit message when a user quits program
	 */
	void exitMessage() {
		System.out.println("\nSaving data into database...");
		System.out.println("\n*********** THANKS FOR VISITING US! ***********");
		option.close();
	}
}
