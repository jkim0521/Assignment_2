package mru.tsc.controller;
import mru.tsc.exceptions.InputPriceException;
import mru.tsc.exceptions.InvalidCharException;
import mru.tsc.exceptions.LessThanZeroException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import mru.tsc.exceptions.EmptyInputException;
import mru.tsc.exceptions.MaximumPlayerException;
import mru.tsc.model.Animals;
import mru.tsc.model.Boardgames;
import mru.tsc.model.Figures;
import mru.tsc.model.Puzzles;
import mru.tsc.model.Toy;
import mru.tsc.view.Menu;

/**
 * The Navigation class allows for navigation of the menus of the ToyStore Company.
 * Some of the classes throw an exception in order to identify
 * whether the user input is a String or an Integer. 
 * @author Joseph Kim & Skylar Wiltse
 *
 */
public class Navigation {
	Menu menu = new Menu();
	FileHandling inventory = new FileHandling();
	protected final String TOYS = "toys.txt";

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
		try {
			if(toyName.isEmpty()) {
				throw new EmptyInputException();
			}
		}
		catch(EmptyInputException eie) {
			System.out.println(eie.getMessage());
			mainMenu();
		}
		//Enter a valid toy brand
		String brandName = menu.enterBrand();
		try {
			if(brandName.isEmpty()) {
				throw new EmptyInputException();
			}
		}
		catch(EmptyInputException eie) {
			System.out.println(eie.getMessage());
			mainMenu();
		}
		//Enter a valid price, higher than zero and rounded to the nearest hundredth
		double price = menu.enterPrice();
		try {
			if(price <= 0) {
				throw new InputPriceException();
			}
		}
		catch(InputPriceException e) {
			System.out.println(e.getMessage());
		}
		//Enter a valid available count, higher than zero
		int availableCount = menu.enterCount();
		try {
			if(availableCount <= 0) {
				throw new LessThanZeroException();
			}
		}
		catch(LessThanZeroException lze) {
			System.out.println(lze.getMessage());
			mainMenu();
		}
		//Enter a valid age that is appropriate for the toy, higher than zero
		int ageRange = menu.enterAge();
		try {
			if(ageRange <= 0) {
				throw new LessThanZeroException();
			}
		}
		catch(LessThanZeroException lze) {
			System.out.println(lze.getMessage());
			mainMenu();
		}
		
		
		//Determines the type of toy that is being entered based on significant digit of the serial number
		int toyType = menu.verifyType(serialNumber);
		//Figures
		if(toyType == 0 || toyType == 1) {
			char classification = menu.enterClassification();
			try {
				if(classification == 'Z') {
					throw new InvalidCharException();
				}
			}
			catch(InvalidCharException ice) {
				System.out.println(ice.getMessage());
				mainMenu();
			}
			//Create new Figure object
			Figures figure = new Figures(serialNumber, toyName, brandName, price, availableCount, ageRange, classification);
			//Save Figure to database with delimiter
			String saveFigure = serialNumber +";" +figure.getToyName() +";" +figure.getBrandName() +";" +figure.getPrice() 
								+";" +figure.getAvailableCount() +";+" +figure.getAgeRange() +";" +figure.getClassification();
			try {
				inventory.saveToFile(saveFigure);
			} catch (IOException e) {
				System.out.println("Aborting operation! No changes will be saved.");
				mainMenu();
			}
			//Success
			addSuccess();
		}
		//Animals
		else if(toyType == 2 || toyType == 3) {
			String material = menu.enterMaterial();
			if(material.isEmpty()) {
				System.out.println("This is an invalid input, material cannot be empty!");
				mainMenu();
			}
			char size = menu.enterSize();
			try {
				if(size == 'Z') {
					throw new InvalidCharException();
				}
			}
			catch(InvalidCharException ice) {
				System.out.println(ice.getMessage());
				mainMenu();
			}
			//Create new Animal object
			Animals animal = new Animals(serialNumber, toyName, brandName, price, availableCount, ageRange, material, size);
			//Save Animal to database with delimiter
			String saveAnimal = serialNumber +";" +animal.getToyName() +";" +animal.getBrandName() +";" +animal.getPrice() 
								+";" +animal.getAvailableCount() +";+" +animal.getAgeRange() +";" +animal.getMaterial() 
								+";" +animal.getSize();
			try {
				inventory.saveToFile(saveAnimal);
			} catch (IOException e) {
				System.out.println("Aborting operation! No changes will be saved.");
				mainMenu();
			}
			//Success
			addSuccess();
		}
		//Puzzles
		else if(toyType >=4 && toyType <=6) {
			char puzzleType = menu.enterPuzzle();
			try {
				if(puzzleType == 'Z') {
					throw new InvalidCharException();
				}
			}
			catch(InvalidCharException ice) {
				System.out.println(ice.getMessage());
				mainMenu();
			}
			//Create new Puzzle object
			Puzzles puzzle = new Puzzles(serialNumber, toyName, brandName, price, availableCount, ageRange, puzzleType);
			//Save Puzzle to database with delimiter
			String savePuzzle = serialNumber +";" +puzzle.getToyName() +";" +puzzle.getBrandName() +";" +puzzle.getPrice() 
            					+";" +puzzle.getAvailableCount() +";+" +puzzle.getAgeRange() +";" +puzzle.getPuzzleType();
			try {
				inventory.saveToFile(savePuzzle);
			} catch (IOException e) {
				System.out.println("Aborting operation! No changes will be saved.");
				mainMenu();
			}
			//Success
			addSuccess();
		}
		//Board Games
		else if(toyType >= 7) {
			int minimumPlayer = menu.enterMinimum();
			if(minimumPlayer <= 0) {
				System.out.println("This is an invalid input! A board game must have at least 1 player!");
				mainMenu();
			}
			int maximumPlayer = menu.enterMaximum();
			try {
				if(maximumPlayer <= minimumPlayer) {
					throw new MaximumPlayerException();
				}
			}
			catch(MaximumPlayerException mpe) {
				System.out.println(mpe.getMessage());
				mainMenu();
			}
			String designerName = menu.enterDesigner();
			
			//Create new Boardgame Object
			Boardgames boardgame = new Boardgames(serialNumber, toyName, brandName, price, availableCount, ageRange, minimumPlayer, maximumPlayer, designerName);
			//Save Boardgame to database with delimiter
			String saveBoardgame = serialNumber +";" +boardgame.getToyName() +";" +boardgame.getBrandName() +";" +boardgame.getPrice() 
			                       +";" +boardgame.getAvailableCount() +";+" +boardgame.getAgeRange() +";" +boardgame.getMinimum() +"-" 
					               +boardgame.getMaximum() +";" +boardgame.getDesignerName();
			System.out.println(saveBoardgame);
			try {
				inventory.saveToFile(saveBoardgame);
			} catch (IOException e) {
				System.out.println("Aborting operation! No changes will be saved.");
				mainMenu();
			}
			//Success
			addSuccess();
		}
	}
	
	/**
	 * Prints a message upon adding a new toy to the text file before
	 * Prompting the user to press enter to continue which then
	 * redirects to the main menu
	 */
	public void addSuccess() {
		System.out.println("\nNew Toy Added!");
		System.out.println("\nPress Enter to Continue...");
		try {
			System.in.read();
		}
		catch(Exception e) {
			System.out.println("An error has occurred! Please try again.");
		} 
		mainMenu();
	}
}
