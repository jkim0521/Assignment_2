/**
 * 
 */
package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import mru.tsc.controller.FileHandling;
import mru.tsc.model.Animals;
import mru.tsc.model.Toy;

/**
 * Test methods for the Toy Store Company program.
 * @author Skylar Wiltse
 */
class Test {
	
	//Make an animal object and fetch a value
	void test1() {
		Animals test1 = new Animals("2323232323", "Test", "Brand", 0, 1, 10, "Soft", 'L');
		Toy testToy = test1;
		boolean passTest1 = false;
		if(testToy.serialNumber().equals("2323232323")) {
			passTest1 = true;
		}
		assertTrue(passTest1);
	}
	
	//Test to make sure toyCatalogue is properly made
	void test2() {
		FileHandling test2 = new FileHandling();
		boolean passTest2 = false;
		try {
			if(test2.toyCatalogue().size() == 265) {
				passTest2 = true;
			}
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		assertTrue(passTest2);
	}
	
	void test3() {
		fail();
	}
}
