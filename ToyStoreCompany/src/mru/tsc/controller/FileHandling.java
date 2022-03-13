package mru.tsc.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
/**
 * The FileHandling class takes the file containing all toys available, delimits each
 * line using ";", and stores the values of each line into a String[], which is then stored in an ArrayList.
 * @author Skylar Wiltse
 */
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
	protected final static String TOYS = "toys.txt";
	
	ArrayList<String[]> toyCatalogue() throws IOException {
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
		writer.append("\n");
		writer.append(saveToy);
		writer.close();		
	}
}
