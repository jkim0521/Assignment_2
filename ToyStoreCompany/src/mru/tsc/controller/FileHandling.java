package mru.tsc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
	
	ArrayList<String[]> toyCatalogue() throws IOException {
		ArrayList<String[]> toyList = new ArrayList<>();
		String[] toy;
		String line = "";
		File file = new File("toys.txt");
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
