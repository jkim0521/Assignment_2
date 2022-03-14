/**
 * 
 */
package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.*;

import mru.tsc.model.Animals;
import mru.tsc.model.Toy;

/**
 * Test methods for the Toy Store Company program.
 * 
 * @author Skylar Wiltse
 */
class Test {
	
	//Make an animal object and fetch a value
	void test1() {
		Animals test = new Animals("2323232323", "Test", "Brand", 0, 1, 10, "Soft", 'L');
		Toy testToy = test;
		boolean pass = false;
		if(testToy.serialNumber().equals("2323232323")) {
			pass = true;
		}
		assertTrue(pass);
	}
	
	void test2() {
		fail();
	}
	
	void test3() {
		fail();
	}
}
