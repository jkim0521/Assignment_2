package mru;
import java.util.*;

/**
 * The Navigation class allows for navigation of the menus of the ToyStore Company.
 * Some of the classes throw an exception in order to identify
 * whether the user input is a String or an Integer. 
 * @author Joseph Kim
 *
 */
public class Navigation {
	Menu menu = new Menu();

	/**
	 * Outputs options and allows navigation of the main menu.
	 * This method throws NumberFormatException to allow parsing
	 * user input to check if an integer or String was entered
	 */
	public void mainMenu() throws NumberFormatException{
		String choice = "";
		boolean decision = true;

		//prints the options for the main menu
		choice = menu.mainMenu();

		//loop if user inputs an incorrect option
		while(decision) {
			switch(choice){
			case "1": {searchMenu(); break;}
			case "2": {break;}
			case "3": {break;}
			case "4": {decision = false; menu.exitMessage(); break;}
			default: 
				//determine if input can be parsed as an Integer
				try {
					if(Integer.parseInt(choice)>4 || Integer.parseInt(choice)<1) {
						System.out.println("This input is invalid!");
					}
				//input is not an integer, prints the appropriate message
				} catch(NumberFormatException e){
					System.out.println("Please enter an integer value!");
					choice = "";
				}
				choice = menu.badInput();
			}
		}
		//exits the program
		System.exit(0);
	}

	/**
	 * Outputs options and allows navigation of the search menu
	 */
	private void searchMenu() throws NumberFormatException{
		String choice = "";
		boolean decision = true;

		//prints the options for the search menu
		choice = menu.searchMenu();

		//loop if user inputs an incorrect option
		while(decision) {
			switch(choice) {
			case "1": break;
			case "2": break;
			case "3": break;
			case "4": decision = false; mainMenu(); break;
			default: try {
				//determine if input can be parsed as an Integer
				if(Integer.parseInt(choice)>4 || Integer.parseInt(choice)<1) {
					System.out.println("This input is invalid!");
				}
			//input is not an integer, prints the appropriate message
			} catch(NumberFormatException e){
				System.out.println("Please enter an integer value!");
				choice = "";
			}
			choice = menu.badInput();
			}	

		}

	}
}
