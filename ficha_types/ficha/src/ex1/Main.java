package ex1;

public class Main {
    public static void main(String[] args) {
        int[] c1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] c2 = new int[]{2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

        ConjuntoDeInteiros a = new ConjuntoDeInteiros(c1);
        ConjuntoDeInteiros b = new ConjuntoDeInteiros(c2);

        System.out.println("c1 contem 516: " + a.contem(1));
        System.out.println("c1 contem 1: " + a.contem(2));
        System.out.println("c1 contem 1: " + a.contem(516));

        System.out.println("\nc2 contem 512: " + b.contem(512));
        System.out.println("c2 contem 2: " + b.contem(2));
        System.out.println("c2 contem 2: " + b.contem(6));
    }
}
