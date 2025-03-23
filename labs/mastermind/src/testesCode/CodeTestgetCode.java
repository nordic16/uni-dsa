package testesCode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import types.Code;
import types.Colour;

class CodeTestgetCode {

	private Code codeToTest;

	@Test
	void teste1() {

		Colour[]expected = new Colour[4];
		
		expected[0] = Colour.GREEN;
		expected[1] = Colour.BLUE;
		expected[2] = Colour.BLUE;
		expected[3] = Colour.BLUE;

		codeToTest = new Code(expected);

		Colour[] actual = codeToTest.getCode();

		assertArrayEquals(expected, actual);

	}
	
	@Test
	void teste2() {

		Colour[]expected = new Colour[8];
		
		expected[0] = Colour.GREEN;
		expected[1] = Colour.BLUE;
		expected[2] = Colour.BLUE;
		expected[3] = Colour.BLUE;
		expected[4] = Colour.GREEN;
		expected[5] = Colour.BLUE;
		expected[6] = Colour.BLUE;
		expected[7] = Colour.BLUE;

		codeToTest = new Code(expected);

		Colour[] actual = codeToTest.getCode();

		assertArrayEquals(expected, actual);

	}
	@Test
	void teste3() {

		Colour[]start = new Colour[8];
		
		start[0] = Colour.GREEN;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;
		start[4] = Colour.GREEN;
		start[5] = Colour.BLUE;
		start[6] = Colour.BLUE;
		start[7] = Colour.BLUE;

		codeToTest = new Code(start);

		Colour[] code = codeToTest.getCode();
		
		start[7] = Colour.GREEN;
		

		boolean actual = Arrays.deepEquals(start, code);
		boolean expected = false;
		
		assertEquals(expected, actual);

	}
	
	
}
