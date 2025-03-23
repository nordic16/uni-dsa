package testesMasterMind;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import types.Code;
import types.Colour;
import types.Mastermind;

class CodeTestToScore {

	public static String EOL = System.lineSeparator();

	private Mastermind jogo;

	@Test
	void teste1() {

		Colour[] multicolour = Colour.values();

		this.jogo = new Mastermind(0, 4, multicolour);

		int expected = 0;
		int actual = jogo.score();

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

		int expected = 0;
		int actual = jogo.score();

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

		int expected = 0;
		int actual = jogo.score();

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

		jogo.play(tentativa);

		int expected = 0;
		int actual = jogo.score();

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

		int expected = 50;
		int actual = jogo.score();

		assertEquals(expected, actual);
	}
	
	
	@Test
	void teste6() {


		Colour[] multicolour = Colour.values();

		this.jogo = new Mastermind(0, 4, multicolour);



		Colour[]trial = new Colour[4];

		trial[0] = Colour.BLUE;
		trial[1] = Colour.PINK;
		trial[2] = Colour.RED;
		trial[3] = Colour.ORANGE;

		Code tentativa = new Code(trial);
		jogo.play(tentativa);
		
		
		trial[0] = Colour.BLUE;
		trial[1] = Colour.PINK;
		trial[2] = Colour.RED;
		trial[3] = Colour.ORANGE;


		tentativa = new Code(trial);

		jogo.play(tentativa);

		int expected = 100;
		int actual = jogo.score();

		assertEquals(expected, actual);
	}
	
	@Test
	void teste7() {

		Colour[] multicolour = Colour.values();

		this.jogo = new Mastermind(0, 4, multicolour);



		Colour[]trial = new Colour[4];

		trial[0] = Colour.BLUE;
		trial[1] = Colour.BLUE;
		trial[2] = Colour.BLUE;
		trial[3] = Colour.BLUE;

		Code tentativa = new Code(trial);
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

		int expected = 50;
		int actual = jogo.score();

		assertEquals(expected, actual);
	}
}



