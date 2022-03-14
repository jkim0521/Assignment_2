package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import mru.tsc.controller.FileHandling;
import mru.tsc.model.Animals;
import mru.tsc.model.Toy;
import mru.tsc.view.Menu;

import org.junit.jupiter.api.Test;

/**
 * Test methods for the Toy Store Company program.
 * @author Skylar Wiltse & Joseph Kim
 */
class Tests {
	
	//Make an Animal object and fetch a value from the parent class
	@Test
	void test1() {
		Animals test1 = new Animals("2323232323", "Test", "Brand", 0, 1, 10, "Soft", 'L');
		Toy testToy = test1;
		boolean passTest1 = false;
		if(testToy.serialNumber().equals("2323232323")) {
			passTest1 = true;
		}
		assertTrue(passTest1);
	}
	
	//Test if a serial number that is less than 10 digits long will be verified
	@Test
	void test2() throws NumberFormatException, IOException {
		Menu menu = new Menu();
		String sNum = "123456789";
		boolean test = menu.verifySN(sNum);
		assertTrue(!test);
	}
	
	//Test if
	@Test
	void test3() {
		Menu menu = new Menu();
		String sNum = "6234567890";
		int test = menu.verifyType(sNum);
		if(test == 0 || test == 1) {
			sNum = "Figure";
		}
		else if(test == 2 || test == 3) {
			sNum = "Animal";
		}
		else if(test >= 4 && test <=6) {
			sNum = "Puzzle";
		}
		else if(test >= 7) {
			sNum = "Board Game";
		}
		assertTrue(sNum.equals("Puzzle"));
	}
	
	//Test to make sure toyCatalogue is properly made
	@Test
	void test4() {
		FileHandling test2 = new FileHandling();
		boolean passTest2 = false;
		try {
			if(test2.toyCatalogue().size() == 265) {
				passTest2 = true;
			}
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		assertTrue(!passTest2);
	}
	
	//Test to make sure the serial number is unique when entered
		@Test
		void test5() {
			FileHandling filehandle = new FileHandling();
			String sNum = "1234567890";
			boolean test = filehandle.isUnique(sNum);
			assertTrue(test);   //meaning serial number is unique
		}
		
	//Test to check that the inverse of test5 works
		@Test
		void test6() {
			FileHandling filehandle = new FileHandling();
			String sNum = "2835360879";
			boolean test = filehandle.isUnique(sNum);
			assertTrue(!test);   //meaning serial number is not unique
		}	
}
