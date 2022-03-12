package mru.tsc.controller;
import mru.tsc.model.Figures;
import mru.tsc.model.Toy;
import mru.tsc.view.Menu;
import java.io.IOException;

/**
 * The Navigation class allows for navigation of the menus of the ToyStore Company.
 * Some of the classes throw an exception in order to identify
 * whether the user input is a String or an Integer. 
 * @author Joseph Kim & Skylar Wiltse
 *
 */
public class Navigation {
	FileHandling inventory = new FileHandling();
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
				case "1": {
					//Search & Purch
					searchMenu();
					break;
					}
				case "2": {
					//Add Toy
					addToy();
					break;
					}
				case "3": {
					//Remove toy
					break;
					}
				case "4": {
					//Save & Quit
					decision = false;
					menu.exitMessage();
					break;
					}
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
	private String searchMenu() throws NumberFormatException{
		String choice = "";
		String searchVal = "";
		boolean decision = true;

		//prints the options for the search menu
		choice = menu.searchMenu();

		//loop if user inputs an incorrect option
		while(decision) {
			switch(choice) {
				case "1": {
					//SN Search
					searchVal = menu.searchSN();
					break;
				}
				case "2": {
					//Name Search
					searchVal = menu.searchName();
					searchToy(searchVal);
					break;
				}
				case "3": {
					//Type Search
					searchVal = menu.searchType();
					break;
				}
				case "4": {
					//Back
					decision = false;
					mainMenu();
					break;
				}
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
		return searchVal;
	}
	
	/**
	 * Method to search toy  catalogue for a toy using a given seach value.
	 * @param searchVal - The value the user wants to search with.
	 */
	private void searchToy(String searchVal) {
		//variables
		boolean found = false;
		String item = "";
		//try parsing catalogue for item
		try {
			//parse Arraylist
			for(int i = 0; i < inventory.toyCatalogue().size(); i++) {
				//parse String array at each index to check for searchVal
				for(int j = 0; j < inventory.toyCatalogue().get(i).length; j++) {
					item = inventory.toyCatalogue().get(i).toString();
					if(item.contains(searchVal)) {
						found = true;
						purchaseToy(i);
					} 
					else {
						found = false;
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Something went wrong.");
		}
	}
	
	/*
	 * Method used to decrement the stock of a toy when purchased.
	 * @param index - Index of the toy in the toyCatalogue Arraylist.
	 */
	private void purchaseToy(int index) {
		//create a copy of String[] in Arraylist for ease of access
		String [] stock;
		int newStock = 0;
		try {
			//find amound of toys in stock
			stock = inventory.toyCatalogue().get(index);
			inventory.toyCatalogue().remove(index);
			
			//decrement stock, change value in array and store back into Arraylist
			newStock = Integer.parseInt(stock[4]) - 1;
			stock[4] = Integer.toString(newStock);
			inventory.toyCatalogue().add(index, stock);
		} 
		catch (IOException e) {
			System.out.println("Something went wrong.");
		}
		
	}
	
	/**
	 * Method to add a new toy to the database
	 * Creates a new toy object, with its type determined by the 
	 * significant digit of the serial number
	 */
	private void addToy() {
		//boolean decision = true;
		boolean verified;
		
		//Fulfillment of Toy
		String serialNumber = menu.enterSN();
		//checks to see if the serial number entered by the user is 10 digits long
		verified = menu.verifySN(serialNumber);
		if(!verified) {
			System.out.println("This is an invalid Serial Number, please double-check that the number is exactly 10 digits long!");
			mainMenu();
		}
		//Enter a valid toy name
		String toyName = menu.enterName();
		if(toyName.isEmpty()) {
			System.out.println("This is an invalid name for a toy, a name must contain something!");
			mainMenu();
		}
		//Enter a valid toy brand
		String brandName = menu.enterBrand();
		if(brandName.isEmpty()) {
			System.out.println("This is an invalid brand name, the brand name cannot be empty!");
			mainMenu();
		}
		//Enter a valid price, higher than zero and rounded to the nearest hundredth
		double price = menu.enterPrice();
		if(price <= 0) {
			System.out.println("The Toy cannot have a price below or at 0.00! Please enter a valid price.");
			mainMenu();
		}
		//Enter a valid available count, higher than zero
		int availableCount = menu.enterCount();
		if(availableCount <= 0) {
			System.out.println("This is an invalid count! Please enter an integer that is higher than 0.");
			mainMenu();
		}
		//Enter a valid age that is appropriate for the toy, higher than zero
		int ageRange = menu.enterAge();
		if(ageRange <= 0) {
			System.out.println("This is an invalid age! Please enter an integer that is higher than 0.");
			mainMenu();
		}
		
		
		//Determines the type of toy that is being entered based on significant digit of the serial number
		int toyType = menu.verifyType(serialNumber);
		if(toyType == 0 || toyType == 1) {
			char classification = menu.enterClassification();
			if(classification == 'Z') {
				System.out.println("This is an invalid classification! Please enter either A, D, or H.");
				mainMenu();
			}
			//Create new Figure object
			Figures figure = new Figures(serialNumber, toyName, brandName, price, availableCount, ageRange, classification);
		}
		else if(toyType == 2 || toyType == 3) {
			String material = menu.enterMaterial();
			if(material.isEmpty()) {
				System.out.println("This is an invalid input, material cannot be empty!");
				mainMenu();
			}
			
		}
		else if(toyType >=4 && toyType <=6) {
			
		}
		else if(toyType >= 7) {
			
		}
		else {
			mainMenu();
		}
	}
}
