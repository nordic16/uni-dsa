package main;

import types.Code;
import types.Colour;
import types.Mastermind;

public class Main2 {

	public static void main(String[] args) {
		Colour[] multicolour = Colour.values();

		Mastermind jogo = new Mastermind(0, 4, multicolour);

		Colour[] trial = new Colour[4];
		trial = new Colour[4];
		trial[0] = Colour.BLUE;
		trial[1] = Colour.ORANGE;
		trial[2] = Colour.BLUE;
		trial[3] = Colour.BLUE;
		
		Code tentativa = new Code(trial);
		jogo.play(tentativa);
		jogo.play(tentativa);

		System.out.println();
		System.out.println(jogo.toString());

		trial[3] = Colour.ORANGE;

		tentativa = new Code(trial);
		jogo.play(tentativa);

		System.out.println();
		System.out.println(jogo.toString());

		trial[0] = Colour.BLUE;
		trial[1] = Colour.PINK;
		trial[2] = Colour.RED;
		trial[3] = Colour.ORANGE;

		tentativa = new Code(trial);
		jogo.play(tentativa);
		

		System.out.println();
		System.out.println(jogo.toString());
	}

}
