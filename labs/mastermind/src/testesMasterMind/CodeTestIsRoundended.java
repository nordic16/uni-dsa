package testesMasterMind;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import types.Colour;
import types.Mastermind;
import types.Code;

class CodeTestIsRoundended {

	public static String EOL = System.lineSeparator();

	private Mastermind jogo;

	@Test
	void teste1() {

		Colour[] binario = Colour.values();

		this.jogo = new Mastermind(0, 6, binario);

		boolean expected = false;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);


	}


	@Test
	void teste2() {

		Colour[] binario = Colour.values();

		this.jogo = new Mastermind(0, 6, binario);

		Colour[]trial = new Colour[6];

		trial[0] = Colour.BLUE;
		trial[1] = Colour.BLUE;
		trial[2] = Colour.BLUE;
		trial[3] = Colour.BLUE;
		trial[4] = Colour.BLUE;
		trial[5] = Colour.BLUE;


		Code tentativa = new Code(trial);
		jogo.play(tentativa);

		boolean expected = false;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);
	}
	
	

	@Test
	void teste3() {

		Colour[] binario = Colour.values();

		this.jogo = new Mastermind(0, 6, binario);

		Colour[]trial = new Colour[6];

		trial[0] = Colour.BLUE;
		trial[1] = Colour.PINK;
		trial[2] = Colour.RED;
		trial[3] = Colour.ORANGE;
		trial[4] = Colour.ORANGE;
		trial[5] = Colour.BLUE;

		Code tentativa = new Code(trial);
		jogo.play(tentativa);
		jogo.play(tentativa);

		boolean expected = false;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);
	}

	@Test
	void teste4() {

		Colour[] binario = Colour.values();

		this.jogo = new Mastermind(0, 6, binario);

		Colour[]trial = new Colour[6];

		trial[0] = Colour.GREEN;
		trial[1] = Colour.GREEN;
		trial[2] = Colour.GREEN;
		trial[3] = Colour.GREEN;
		trial[4] = Colour.GREEN;
		trial[5] = Colour.GREEN;

		Code tentativa = new Code(trial);
		jogo.play(tentativa);

		trial[5] = Colour.ORANGE;

		tentativa = new Code(trial);

		jogo.play(tentativa);

		boolean expected = false;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);;
	}

	@Test
	void teste5() {

		Colour[] binario = Colour.values();

		this.jogo = new Mastermind(0, 6, binario);

		Colour[]trial = new Colour[6];

		trial[0] = Colour.BLUE;
		trial[1] = Colour.PINK;
		trial[2] = Colour.RED;
		trial[3] = Colour.ORANGE;
		trial[4] = Colour.ORANGE;
		trial[5] = Colour.BLUE;

		Code tentativa = new Code(trial);
		jogo.play(tentativa);
		jogo.play(tentativa);

		trial[5] = Colour.RED;

		tentativa = new Code(trial);

		jogo.play(tentativa);

		trial[0] = Colour.BLUE;
		trial[1] = Colour.PINK;
		trial[2] = Colour.RED;
		trial[3] = Colour.ORANGE;
		trial[4] = Colour.ORANGE;
		trial[5] = Colour.ORANGE;


		tentativa = new Code(trial);

		jogo.play(tentativa);

		boolean expected = true;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);
	}
	
	@Test
	void teste6() {

		Colour[] binario = Colour.values();

		this.jogo = new Mastermind(0, 6, binario);

		Colour[]trial = new Colour[6];

		trial[0] = Colour.BLUE;
		trial[1] = Colour.BLUE;
		trial[2] = Colour.BLUE;
		trial[3] = Colour.BLUE;
		trial[4] = Colour.BLUE;
		trial[5] = Colour.BLUE;

		Code tentativa = new Code(trial);
		
		for (int i = 1; i < Mastermind.MAX_TRIALS; i++) {
			jogo.play(tentativa);
		}
		

		boolean expected = false;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);
	}
	
	@Test
	void teste7() {
		Colour[] binario = Colour.values();

		this.jogo = new Mastermind(0, 6, binario);

		Colour[]trial = new Colour[6];

		trial[0] = Colour.BLUE;
		trial[1] = Colour.BLUE;
		trial[2] = Colour.BLUE;
		trial[3] = Colour.BLUE;
		trial[4] = Colour.BLUE;
		trial[5] = Colour.BLUE;

		Code tentativa = new Code(trial);
		
		for (int i = 1; i <= Mastermind.MAX_TRIALS; i++) {
			jogo.play(tentativa);
		}
		
		boolean expected = true;

		boolean actual = jogo.isRoundFinished();

		assertEquals(expected, actual);
	}
}



