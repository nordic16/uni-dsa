package ex1;

import java.util.Arrays;

public class ConjuntoDeInteiros {
    private final int[] numeros;

    public int[] getNumeros() {
        return numeros;
    }

    public ConjuntoDeInteiros(int[] a) {
        Arrays.sort(a);
        this.numeros = Arrays.copyOf(a, a.length);
    }

    public boolean contem(int key) {
        return Arrays.binarySearch(this.numeros, key) >= 0;
    }



}
