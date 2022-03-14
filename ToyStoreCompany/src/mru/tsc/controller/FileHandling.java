package mru.tsc.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;
import java.io.*;

/**
 * This class handles all file related operations.
 * @author Skylar Wiltse
 */
public class FileHandling {
	protected final static String TOYS = "toys.txt";
	Scanner input = new Scanner(System.in);
	//Navigation navi = new Navigation();
	
	/**
	 * Takes the file containing all toys available, delimits each
	 * line using ";", and stores the values of each line into a String[],
	 * which is then stored in an ArrayList.
	 * @return - toyCatalogue
	 * @throws IOException
	 */
	public ArrayList<String[]> toyCatalogue() throws IOException {
		ArrayList<String[]> toyList = new ArrayList<>();
		String[] toy;
		String line = "";
		File file = new File(TOYS);
		Scanner reader = new Scanner(file);
		
		int i = 0;
		while(reader.hasNext()) {
			line = reader.nextLine();
			toy = line.split(";");
			
			toyList.add(i, toy);
			i++;
		}
		
		reader.close();
		return toyList;
	}
	
	/**
	 * Saves the String containing information pertaining to a new toy's description
	 * and appends the information to the end of the text file
	 * @author Joseph Kim
	 * @param toyDesc The toString of a new toy created in the Navigation class
	 * @throws IOException 
	 */
	public void saveToFile(String toyDesc) throws IOException{
		String saveToy = toyDesc;
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(TOYS, true), "UTF-8"));
		//Ensures that the cursor for appending the String is on a new line 
		writer.append("\n");
		writer.append(saveToy);
		writer.close();		
	}
	
	/**
	 * Reads the text file and searches for any matching serial numbers defined by the user
	 * prompting for its removal from the text file
	 * @author Joseph Kim
	 * @param serialNumber The verified serial number defined by the user
	 * @throws IOException
	 */
	public void removeFromFile(String serialNumber) throws IOException{
		ArrayList<String> database = new ArrayList<>();
		FileWriter writer = null;
		String sn = serialNumber;
		String selection = "";
		
		//Reads the text file and adds each line into the database ArrayList
		try(BufferedReader reader = new BufferedReader(new FileReader(TOYS))){
			String currentLine;
			while((currentLine = reader.readLine()) != null) {
				database.add(currentLine);
			}
		}
		catch(IOException e) {
			System.out.println("An error occured while reading file! Please try again.");
		}
		
		//Compares the serial number with a serial number in the ArrayList
		for(String i : database) {
			if(i.startsWith(sn)) {
				System.out.println("\nThis Item Found: \n");
				System.out.println(i);
				selection = i;
			}
		}
		//Inquire if to remove toy or not
		System.out.println("\nWould you like to remove this? (Y/N) : ");
		try {
			char option = input.next().charAt(0);
			switch(option) {
			case 'y': //fall through
			case 'Y': database.remove(database.indexOf(selection));
					  database.removeIf(i -> i == null || "".equals(i));
					  System.out.println("\nItem Removed!");
					  //Save changes to the text file
					  try {
						  writer = new FileWriter(TOYS);
						  for(String db : database) {
							  writer.write(db + System.lineSeparator());
						  }
						  writer.close();
					  }
					  catch(IOException e) {
						  System.out.println("An error occurred while saving changes! Please try again.");
					  }		
					  break;
					
			case 'n': //fall through
			case 'N': System.out.println("\nRedirecting to Main Menu...");
					  break;
			}
		}
		catch (InputMismatchException imm) {
			System.out.print("");
		}		
	}
	
	/**
	 * Checks to see if the user-entered serial number
	 * does not already exist within the text file
	 * @author Joseph Kim
	 * @param serialNumber User-entered serial number
	 * @return
	 */
	public boolean isUnique(String serialNumber) {
		ArrayList<String> database = new ArrayList<>();
		String sn = serialNumber;

		//Reads the text file and adds each line into the database ArrayList
		try(BufferedReader reader = new BufferedReader(new FileReader(TOYS))){
			String currentLine;
			while((currentLine = reader.readLine()) != null) {
				database.add(currentLine);
			}
		}
		catch(IOException e) {
			System.out.println("An error occured while reading file! Please try again.");
		}
		//Compares the serial number with a serial number in the ArrayList
			for(String i : database) {
				if(i.startsWith(sn)) {
					return false;
				}
			}
		return true;
	}
}
