package testesMasterMind;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import types.Colour;
import types.Mastermind;
import types.Code;

class CodeTestToSTring {

	public static String EOL = System.lineSeparator();

	private Mastermind jogo;

	@Test
	void teste1() {

		Colour[] multicolour = Colour.values();

		this.jogo = new Mastermind(0, 4, multicolour);

		String expected = "Number of Trials = 0" + EOL
				+ "Score = 0" + EOL
				+ "[?, ?, ?, ?]" + EOL
				+ EOL;
		String actual = jogo.toString();

		assertEquals(expected, actual);


	}


	@Test
	void teste2() {

		Colour[] multicolour = Colour.values();

		this.jogo = new Mastermind(0, 4, multicolour);



		Colour[]trial = new Colour[4];

		trial[0] = Colour.BLUE;
		trial[1] = Colour.BLUE;
		trial[2] = Colour.BLUE;
		trial[3] = Colour.BLUE;


		Code tentativa = new Code(trial);
		jogo.play(tentativa);

		String expected = "Number of Trials = 1" + EOL
				+ "Score = 0" + EOL
				+ "[?, ?, ?, ?]" + EOL
				+ EOL
				+ "[B, B, B, B]    1 0" + EOL;
		String actual = jogo.toString();

		assertEquals(expected, actual);
	}

	@Test
	void teste3() {

		Colour[] multicolour = Colour.values();

		this.jogo = new Mastermind(0, 4, multicolour);

		Colour[]trial = new Colour[4];

		trial[0] = Colour.BLUE;
		trial[1] = Colour.BLUE;
		trial[2] = Colour.BLUE;
		trial[3] = Colour.BLUE;
	
		Code tentativa = new Code(trial);
		jogo.play(tentativa);
		jogo.play(tentativa);

		String expected = "Number of Trials = 2" + EOL
				+ "Score = 0" + EOL
				+ "[?, ?, ?, ?]" + EOL
				+ EOL
				+ "[B, B, B, B]    1 0" + EOL;		
		String actual = jogo.toString();

		assertEquals(expected, actual);
	}

	@Test
	void teste4() {

		Colour[] multicolour = Colour.values();

		this.jogo = new Mastermind(0, 4, multicolour);


		Colour[]trial = new Colour[4];

		trial[0] = Colour.BLUE;
		trial[1] = Colour.BLUE;
		trial[2] = Colour.BLUE;
		trial[3] = Colour.BLUE;


		Code tentativa = new Code(trial);
		jogo.play(tentativa);
		jogo.play(tentativa);

		trial[3] = Colour.ORANGE;

		tentativa = new Code(trial);

		jogo.play(tentativa);

		String expected = "Number of Trials = 3" + EOL
				+ "Score = 0" + EOL
				+ "[?, ?, ?, ?]" + EOL
				+ EOL
				+ "[B, B, B, B]    1 0" + EOL
				+ "[B, B, B, O]    2 0" + EOL;
		String actual = jogo.toString();

		assertEquals(expected, actual);
	}

	@Test
	void teste5() {

		Colour[] multicolour = Colour.values();

		this.jogo = new Mastermind(0, 4, multicolour);

		Colour[]trial = new Colour[4];

		trial[0] = Colour.BLUE;
		trial[1] = Colour.BLUE;
		trial[2] = Colour.BLUE;
		trial[3] = Colour.BLUE;


		Code tentativa = new Code(trial);
		jogo.play(tentativa);
		jogo.play(tentativa);

		trial[3] = Colour.ORANGE;
		
		tentativa = new Code(trial);

		jogo.play(tentativa);

		trial[0] = Colour.BLUE;
		trial[1] = Colour.PINK;
		trial[2] = Colour.RED;
		trial[3] = Colour.ORANGE;
		

		tentativa = new Code(trial);

		jogo.play(tentativa);
		
		String expected = "Number of Trials = 4" + EOL
				+ "Score = 50" + EOL
				+ "[B, P, R, O]" + EOL
				+ EOL
				+ "[B, B, B, B]    1 0" + EOL
				+ "[B, B, B, O]    2 0" + EOL
				+ "[B, P, R, O]    4 0" + EOL;
		String actual = jogo.toString();

		assertEquals(expected, actual);
	}
}



