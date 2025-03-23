package testesCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import types.Code;
import types.Colour;

class CodeTestLength {

	private Code codeToTest;

	@Test
	void teste1() {

		Colour[]start = new Colour[1];

		start[0] = Colour.BLUE;
		
		
		codeToTest = new Code(start);

		int expected = 1;
		int actual = codeToTest.getLength();

		assertEquals(expected, actual);


	}
	
	@Test
	void teste2() {

		Colour[]start = new Colour[2];

		start[0] = Colour.BLUE;
		start[1] = Colour.GREEN;

		int expected = 2;
		
		codeToTest = new Code(start);
		
		int actual = codeToTest.getLength();

		assertEquals(expected, actual);


	}
	
	@Test
	public void teste4() {
		
		assertThrows(
					NullPointerException.class,
						() -> codeToTest.getLength(),
						"Expected top() to throw, but it didn't"
		);
	}

	
	
	
	
	@Test
	void teste5() {

		Colour[]start = new Colour[2];

		start[0] = Colour.BLUE;
		start[1] = Colour.GREEN;

		int expected = 2;
		
		codeToTest = new Code(start);
		
		start = null; 
		
		int actual = codeToTest.getLength();

		assertEquals(expected, actual);


	}

}
