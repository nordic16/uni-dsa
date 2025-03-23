package ex2;

import java.util.Random;

public class Main {
    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        mediaAleatorios(100000);
    }

    public static void mediaAleatorios(int n) {
        Acumulador ac = new Acumulador();

        for (int i = 0; i < n; i++) {
            ac.adicionar(random.nextDouble(0, 1));
        }

        System.out.printf("Media: (%d valores): %.5f", ac.getN(), ac.media());
    }
}
