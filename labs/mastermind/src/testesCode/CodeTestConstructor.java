package testesCode;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import types.Code;
import types.Colour;

class CodeTestConstructor {

	private Code codeToTest;

	@Test
	void testeConstrutor1() {

		Colour[]start = new Colour[4];

		start[0] = Colour.BLUE;
		start[1] = Colour.GREEN;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;
		
		codeToTest = new Code(start);

		String expected = "[B, G, B, B]";
		String actual = codeToTest.toString();

		assertEquals(expected, actual);


	}
		
	@Test
	void testeConstrutor4() {

		Colour[] start = new Colour[8];

		start[0] = Colour.GREEN;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;
		start[4] = Colour.GREEN;
		start[5] = Colour.BLUE;
		start[6] = Colour.BLUE;
		start[7] = Colour.BLUE;

		codeToTest = new Code(start);
		
		// start[7] = Colour.GREEN;

		String expected = "[G, B, B, B, G, B, B, B]";
		String actual = codeToTest.toString();

		assertEquals(expected, actual);


	}

	
	

}
