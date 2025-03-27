package stuff;

import java.util.Random;

public class MyRandomGenerators {

	private final Random gerador;

	 MyRandomGenerators(Random g){
		 this.gerador = g;
		 System.out.println(g.nextBoolean());
	 }
	 
	 void printRandom() {
		 System.out.println(gerador.nextBoolean());
	 }
}
