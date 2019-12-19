package application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class MainTest extends Main {

	@Test
	void test() {
		//setting up an array to test
		String array [] = {
				"0","1","2"
		};
		//expecting "0" to be found at location 0 of the array
		assertEquals(0, positionOfStringInArray(array, "0"));	
		
		//creating variables to test against
		double testDouble=12.3456;
		//creating expectetDouble before implementing test to be able to verify result with debugging
		double expectetDouble = Double.parseDouble(formatDoubleToString(testDouble));
		//checking against 12.35 because format() rounds last digit.
		assertEquals(12.35, expectetDouble, 0.01);
		
	}

}
