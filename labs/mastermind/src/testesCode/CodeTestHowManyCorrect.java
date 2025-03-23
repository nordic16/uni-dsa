package testesCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import types.Code;
import types.Colour;

class CodeTestHowManyCorrect {

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
		
		Colour[]trial = new Colour[4];

		trial[0] = Colour.GREEN;
		trial[1] = Colour.BLUE;
		trial[2] = Colour.BLUE;
		trial[3] = Colour.BLUE;

		
		codeToTest1 = new Code(start);
		codeToTest2 = new Code(trial);

        int[] expected = {4, 0};
        int[] result = codeToTest1.howManyCorrect(codeToTest2);

        assertArrayEquals(expected, result);


	}
	
	@Test
	void teste2() {

		Colour[]start = new Colour[4];

		start[0] = Colour.BLUE;
		start[1] = Colour.BLUE;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;

		
		codeToTest1 = new Code(start);
		
		Colour[]trial = new Colour[4];

		trial[0] = Colour.GREEN;
		trial[1] = Colour.GREEN;
		trial[2] = Colour.GREEN;
		trial[3] = Colour.GREEN;

		
		codeToTest1 = new Code(start);
		codeToTest2 = new Code(trial);

        int[] expected = {0, 0};
        int[] result = codeToTest1.howManyCorrect(codeToTest2);

        assertArrayEquals(expected, result);


	}

	
	@Test
	void teste5() {

		Colour[]start = new Colour[4];

		start[0] = Colour.BLUE;
		start[1] = Colour.GREEN;
		start[2] = Colour.BLUE;
		start[3] = Colour.BLUE;
		
		codeToTest1 = new Code(start);
		
		Colour[]trial = new Colour[4];

		trial[0] = Colour.GREEN;
		trial[1] = Colour.GREEN;
		trial[2] = Colour.GREEN;
		trial[3] = Colour.GREEN;
		
		codeToTest1 = new Code(start);
		codeToTest2 = new Code(trial);

        int[] expected = {1, 0};
        int[] result = codeToTest1.howManyCorrect(codeToTest2);

        assertArrayEquals(expected, result);


	}
	
	
	@Test
	void teste7() {

		Colour[]start = new Colour[4];

		start[0] = Colour.BLUE;
		start[1] = Colour.GREEN;
		start[2] = Colour.ORANGE;
		start[3] = Colour.BLUE;
	
		
		codeToTest1 = new Code(start);
		
		
		Colour[]trial = new Colour[4];

		trial[0] = Colour.GREEN;
		trial[1] = Colour.BLUE;
		trial[2] = Colour.ORANGE;
		trial[3] = Colour.GREEN;
		
	
		
		codeToTest1 = new Code(start);
		codeToTest2 = new Code(trial);

        int[] expected = {1, 2};
        int[] result = codeToTest1.howManyCorrect(codeToTest2);

        assertArrayEquals(expected, result);

	}
	

}

