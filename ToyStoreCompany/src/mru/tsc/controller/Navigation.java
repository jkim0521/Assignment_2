package mru.tsc.controller;
import mru.tsc.exceptions.InputPriceException;
import mru.tsc.exceptions.InvalidCharException;
import mru.tsc.exceptions.InvalidSerialNumberException;
import mru.tsc.exceptions.LessThanZeroException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.exceptions.EmptyInputException;
import mru.tsc.exceptions.IncompatibleInputException;
import mru.tsc.exceptions.MaximumPlayerException;
import mru.tsc.exceptions.MinMaxPriceException;
import mru.tsc.exceptions.NonUniqueNumberException;
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
	Scanner sc = new Scanner(System.in);

	/**
	 * Outputs options and allows navigation of the main menu.
	 * This method throws NumberFormatException to allow parsing
	 * user input to check if an integer or String was entered
	 * @throws IOException 
	 */
	public void mainMenu() throws NumberFormatException, IOException{
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
					removeToy();
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
	 * Outputs options and allows navigation of the search sub menu
	 * @throws IOException 
	 */
	private String searchMenu() throws NumberFormatException, IOException{
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
					searchToyType(searchVal);
					break;
				}
				case "4": {
					// Gift Suggestion
					gift();
					break;
				}

				case "5": {
					// Back
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
		ArrayList<String[]> results = new ArrayList<>();
		String[] result;
		String item = "";
		//try parsing catalogue for item
		try {
			//parse Arraylist
			for(int i = 0; i < inventory.toyCatalogue().size(); i++) {
				//parse String array at each index to check for searchVal
				for(int j = 0; j < inventory.toyCatalogue().get(i).length; j++) {
					item = inventory.toyCatalogue().get(i).toString();
					if(item.contains(searchVal)) {
						result = item.split(";");
						results.add(result);
						purchaseToy(i);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Something went wrong.");
		}
		//Print results for selection.
		int counter = 1;
		ArrayList<String> selection = new ArrayList<>();
		for(int i = 0; i < results.size(); i++) {
			String[] r = results.get(i);
			char identifier = r[0].charAt(0);
			switch (identifier) {
				case '0':
				case '1': {
					String rString = "(" + counter + ")" + "Figure, SN: " + r[0] + ", Name: " + r[1] +
							", Brand: " + r[2] + ", Price: " + r[3] + ", In Stock: " + r[4] +
							", Age Appropriate: " + r[5] + ", Classification: " + r[7];
					selection.add(rString);
					break;
				} 
				case '2':
				case '3': {
					String rString = "(" + counter + ")" + "Type: Animal, SN: " + r[0] + ", Name: " + r[1] +
							", Brand: " + r[2] + ", Price: " + r[3] + ", In Stock: " + r[4] +
							", Age Appropriate: " + r[5] + ", Material: " + r[7] + "Size: " + r[8];
					selection.add(rString);
					break;
				}
				case '4':
				case '5':
				case '6': {
					String rString = "(" + counter + ")" +"Type: Puzzle, SN: " + r[0] + ", Name: " + r[1] +
							", Brand: " + r[2] + ", Price: " + r[3] + ", In Stock: " + r[4] +
							", Age Appropriate: " + r[5] + ", Puzzle Type: " + r[7];
					selection.add(rString);
					break;
				}
				case '7':
				case '8':
				case '9': {
					String rString = "(" + counter + ")" +"Type: Board Game, SN: " + r[0] + ", Name: " + r[1] +
							", Brand: " + r[2] + ", Price: " + r[3] + ", In Stock: " + r[4] +
							", Age Appropriate: " + r[5] + ", # of Players: " + r[7] + ", Designers: " + r[8];
					selection.add(rString);
					break;
				}
			}
		}
		//Print selection menu
		int i;
		for(i = 0; i < selection.size(); i++) {
			System.out.print(selection.get(i));
		}
		System.out.println("Enter the number of the item you would like to purchase, or " + (i+1) + "to go back to the main menu.");
		String choice = sc.nextLine();
		
		for(int j = 0; j < selection.size(); j++) {
			if(choice.equals(j)) {
				purchaseToy(j);
			}
			if (Integer.parseInt(choice) == (selection.size() + 1)) {
				menu.mainMenu();
			}
			else {
				System.out.println("Invalid input, please try again.");
				menu.mainMenu();
			}
		}
		sc.close();
	}
	
	/*
	 * Method to search by type of toy.
	 * @param - User entered type.
	 */
	private void searchToyType(String type) throws IOException {
		ArrayList<String[]> toyList = inventory.toyCatalogue();
		ArrayList<String[]> results = new ArrayList<>();
		String[] result;
		type = type.toLowerCase();
		try {
			switch (type) {
			case "figure": {
				for(int i = 0; i < toyList.size(); i++) {
					 result = toyList.get(i);
					 String SN = result[0];
					 if (SN.charAt(0) == 0 || SN.charAt(0) == 1) {
						results.add(result);
					} 
				}
				break;
			}
			case "animal": {
				for(int i = 0; i < toyList.size(); i++) {
					 result = toyList.get(i);
					 String SN = result[0];
					 if (SN.charAt(0) == 2 || SN.charAt(0) == 3) {
						results.add(result);
					} 
				}
				break;
			}
			case "puzzle": {
				for(int i = 0; i < toyList.size(); i++) {
					 result = toyList.get(i);
					 String SN = result[0];
					 if (SN.charAt(0) == 4 || SN.charAt(0) == 5 || SN.charAt(0) == 6) {
						results.add(result);
					} 
				}
				break;
			}
			case "board game": {
				for(int i = 0; i < toyList.size(); i++) {
					 result = toyList.get(i);
					 String SN = result[0];
					 if (SN.charAt(0) == 7 || SN.charAt(0) == 8 || SN.charAt(0) == 9) {
						results.add(result);
					} 
				}
				break;
			}
			default:
				throw new InvalidCharException("Cannot find anything of type " + type + ". Try: "
						+ "figure, animal, puzzle, or board game.");
			}
		} 
		catch (Exception e) {
			System.out.println("Something went wrong.");
		}
		//Print results for selection.
		int counter = 1;
		ArrayList<String> selection = new ArrayList<>();
		for(int i = 0; i < results.size(); i++) {
			String[] r = results.get(i);
			char identifier = r[0].charAt(0);
			switch (identifier) {
				case '0':
				case '1': {
					 String rString = "(" + counter + ")" + "Figure, SN: " + r[0] + ", Name: " + r[1] +
							", Brand: " + r[2] + ", Price: " + r[3] + ", In Stock: " + r[4] +
							", Age Appropriate: " + r[5] + ", Classification: " + r[7];
					 selection.add(rString);
					 break;
					} 
				case '2':
				case '3': {
					String rString = "(" + counter + ")" + "Type: Animal, SN: " + r[0] + ", Name: " + r[1] +
							", Brand: " + r[2] + ", Price: " + r[3] + ", In Stock: " + r[4] +
							", Age Appropriate: " + r[5] + ", Material: " + r[7] + "Size: " + r[8];
					selection.add(rString);
					break;
					}
				case '4':
				case '5':
				case '6': {
					String rString = "(" + counter + ")" +"Type: Puzzle, SN: " + r[0] + ", Name: " + r[1] +
							", Brand: " + r[2] + ", Price: " + r[3] + ", In Stock: " + r[4] +
							", Age Appropriate: " + r[5] + ", Puzzle Type: " + r[7];
					selection.add(rString);
					break;
					}
				case '7':
				case '8':
				case '9': {
					String rString = "(" + counter + ")" +"Type: Board Game, SN: " + r[0] + ", Name: " + r[1] +
							", Brand: " + r[2] + ", Price: " + r[3] + ", In Stock: " + r[4] +
							", Age Appropriate: " + r[5] + ", # of Players: " + r[7] + ", Designers: " + r[8];
					selection.add(rString);
					break;
					}
				}
			}
			//Print selection menu
			int i;
			for(i = 0; i < selection.size(); i++) {
				System.out.print(selection.get(i));
			}
			System.out.println("Enter the number of the item you would like to purchase, or " + ((i+1)) + "to go back to the main menu.");
			String choice = sc.nextLine();
			
			for(int j = 0; j < selection.size(); j++) {
				if(choice.equals(j)) {
				purchaseToy(j);
				}
				if (Integer.parseInt(choice) == (selection.size() + 1)) {
					menu.mainMenu();
				}
				else {
					System.out.println("Invalid input, please try again.");
					menu.mainMenu();
				}
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
	 * A method that asks the user a list of questions in order to provide 
	 * a suggestion for a toy for purchase as a gift
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void gift() throws NumberFormatException, IOException {
		String type = "Any";
		String suggestion = "";
		double min = 0.0;
		double max = 0.0;
		int minAge = 0;
		int choice;
		int answered = 0;
			
		menu.giftInstructions();
			
			//Price Range
		System.out.println("\nEnter the minimum price for a gift: ");
		choice = menu.qInput();
		if(choice == 1) {
			min = menu.qPrice();
			try {
				if(min <= 0) {
					throw new InputPriceException();
				}
				else if (min > 0) {
					answered++;
				}
			}
			catch(InputPriceException ipe) {
				System.out.println(ipe.getMessage());
			}	
		}
			
		System.out.println("\nEnter the maximum price for a gift: ");
		choice = menu.qInput();
		if(choice == 1) {
			max = menu.qPrice();
			try {
				if (max <= min) {
					throw new MinMaxPriceException();
				}	
			}
			catch(MinMaxPriceException mmpe) {
				System.out.println(mmpe.getMessage());
			}
			try {
				if(max <= 0) {
					throw new InputPriceException();
				}
				else if (max > min) {
					answered++;
				}
			}
			catch(InputPriceException ipe) {
				System.out.println(ipe.getMessage());
			}	
		}
			
		//Age
		System.out.println("\nEnter the minimum age: ");
		choice = menu.qInput();
		if(choice == 1) {
			minAge = menu.qAge();
			try {
				if(minAge <= 0) {
					throw new LessThanZeroException();
				}
				else if(minAge > 0) {
					answered++;
				}
			}
			catch(LessThanZeroException lze) {
				System.out.println(lze.getMessage());
			}
		}
		
		//Type
		System.out.println("\nEnter the type of toy (in one word, non-plural): ");
		choice = menu.qInput();
		if(choice == 1) {
			type = menu.qType();
			try {
				if(!type.equals("figure") || !type.equals("animal") || !type.equals("puzzle") || !type.equals("boardgame")) {
					throw new IncompatibleInputException();
				}
				else {
					answered++;
				}
		}
			catch(IncompatibleInputException iipe) {
				System.out.println(iipe.getMessage());
			}
		}
		suggestion = menu.concatQuestions(min, max, minAge, type, answered);
		System.out.println(suggestion);
		mainMenu();
	}
	
	/**
	 * Method to select a particular toy to remove from the database.
	 * Prompts the user to enter a valid serial number and 
	 * requests if the user would like to remove the toy.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void removeToy() throws NumberFormatException, IOException {
		boolean verified;
		
		String serialNumber = menu.enterSN();
		verified = menu.verifySN(serialNumber);
		try {
			if(!verified) {
				throw new InvalidSerialNumberException();
			}
		}
		catch(InvalidSerialNumberException isne) {
			System.out.println(isne.getMessage());
			mainMenu();
		}
		try {
			inventory.removeFromFile(serialNumber);
		} catch (IOException e) {
			System.out.println("");
		}
		removeSuccess();
	}
	
	/**
	 * Method to add a new toy to the database
	 * Creates a new toy object, with its type determined by the 
	 * significant digit of the serial number
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private void addToy() throws NumberFormatException, IOException {
		boolean verified;
		boolean isUnique;
		
		//Fulfillment of Toy constructor
		String serialNumber = menu.enterSN();
		//checks to see if the serial number entered by the user is 10 digits long
		verified = menu.verifySN(serialNumber);
		try {
			if(!verified) {
				throw new InvalidSerialNumberException();
			}
		}
		catch(InvalidSerialNumberException isne) {
			System.out.println(isne.getMessage());
			mainMenu();
		}
		//checks to see if the inputted serial number does not already exist
		isUnique = inventory.isUnique(serialNumber);
		try {
			if(!isUnique) {
				throw new NonUniqueNumberException();
			}
		}
		catch(NonUniqueNumberException nune) {
			System.out.println(nune.getMessage());
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
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void addSuccess() throws NumberFormatException, IOException {
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
	
	/**
	 * Prints a message upon adding a new toy to the text file before
	 * Prompting the user to press enter to continue which then
	 * redirects to the main menu
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void removeSuccess() throws NumberFormatException, IOException {
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
