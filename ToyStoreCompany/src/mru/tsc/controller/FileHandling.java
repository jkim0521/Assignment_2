package mru.tsc.controller;

import java.io.File;

/**
 * The FileHandling class takes the file containing all toys available, delimits each
 * line using ";", and stores the values of each line into a String[], which is then stored in an ArrayList.
 * @author Skylar Wiltse
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
	protected final String TOYS = "toys.txt";
	
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
}
