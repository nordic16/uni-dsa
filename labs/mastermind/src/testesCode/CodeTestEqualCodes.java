package testesCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import types.Code;
import types.Colour;

class CodeTestEqualCodes {

	private Code codeToTest1;
	private Code codeToTest2;

	@Test
	void teste1() {

		Colour[]start = new Colour[4];

		start[0] = Colour.GREEN;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;

		codeToTest1 = new Code(start);
		codeToTest2 = new Code(start);

		boolean expected = true;
		boolean actual = codeToTest1.equalCodes(codeToTest2);

		assertEquals(expected, actual);


	}

	@Test
	void teste2() {

		Colour[]start = new Colour[4];

		start[0] = Colour.GREEN;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;


		codeToTest1 = new Code(start);

		assertThrows(
				NullPointerException.class,
				() -> codeToTest1.equalCodes(codeToTest2),
				"Expected to throw, but it didn't"
				);
		

	


	}

	@Test
	void teste3() {

		Colour[]start = new Colour[4];

		start[0] = Colour.GREEN;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;


		codeToTest1 = new Code(start);

		
		start = new Colour[3];

		start[0] = Colour.GREEN;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;

		codeToTest2 = new Code(start);

		boolean expected = false;
		boolean actual = codeToTest1.equalCodes(codeToTest2);

		assertEquals(expected, actual);
	}

	@Test
	void teste4() {

		Colour[]start = new Colour[4];

		start[0] = Colour.GREEN;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;


		codeToTest1 = new Code(start);

		
		start = new Colour[4];

		start[0] = Colour.GREEN;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;
		start[3] = Colour.GREEN;

		codeToTest2 = new Code(start);

		boolean expected = false;
		boolean actual = codeToTest1.equalCodes(codeToTest2);

		assertEquals(expected, actual);
	}


	@Test
	void teste5() {

		Colour[]start = new Colour[4];

		start[0] = Colour.GREEN;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;


		codeToTest1 = new Code(start);

		
		start = new Colour[4];

		start[0] = Colour.BLUE;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;

		codeToTest2 = new Code(start);

		boolean expected = false;
		boolean actual = codeToTest1.equalCodes(codeToTest2);

		assertEquals(expected, actual);
	}

	@Test
	void teste6() {

		Colour[]start = new Colour[4];

		start[0] = Colour.GREEN;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;


		codeToTest1 = new Code(start);
		
		codeToTest2 = new Code(codeToTest1.getCode());

		boolean expected = true;
		boolean actual = codeToTest1.equalCodes(codeToTest2);

		assertEquals(expected, actual);
	}
	
	@Test
	void teste7() {

		Colour[]start = new Colour[4];

		start[0] = Colour.GREEN;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;


		codeToTest1 = new Code(start);

		// Colour[]start2 = codeToTest1.getCode();
		Colour[]start2 = codeToTest1.getCode().clone();
		start2[0] = Colour.BLUE;
		
		codeToTest2 = new Code(start2);
		
		System.out.println(codeToTest1.toString());
		System.out.println(codeToTest2.toString());


		boolean expected = false;
		boolean actual = codeToTest1.equalCodes(codeToTest2);

		assertEquals(expected, actual);
	}


}
