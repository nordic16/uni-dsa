package stuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExemploSonar {
	public void symmetric(int x) {
		int expected = -x;
		int actual = -x;

		System.out.println(expected == actual);
	}

	public void equals(TryEquals x, TryEquals y) {
		boolean expected = x.equals(y);
		boolean actual = true;

		for (int i = 0; i < 10; i++) {
			System.out.println(expected == actual);
		}
	}


	public String readFile(String f) throws FileNotFoundException {
		String sb = "";

		Scanner bufferedReader = new Scanner(new File(f));

		while(bufferedReader.hasNextLine()) {
			String line = bufferedReader.nextLine();
			System.out.println(line);
		}

		return sb;
	}

	public void declaracaoMatrizes() {
		int[][] matrix = new int[1][2];
		int[][] matrix2 = new int[2][1];

		System.out.println(matrix[0][0]);
		System.out.println(matrix2[0][0]);
	}

	public void trocaValores(int a, int b) {
		int c = 0;
		a = b;
		c = a;
		System.out.println(a + " " + b + " " + c);
	}
	


	
	

}
