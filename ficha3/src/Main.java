import ex11.Stopwatch;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = new int[]{10, 100, 250, 500, 1500, 2000, 1000000};

        for (int size: sizes) {
            long x = System.nanoTime();
            option8(size);
            double duration = (double) (System.nanoTime() - x) / 100000000;
            System.out.printf("Took me around %.8fs to complete your request: {%d, %.8f} %n", duration, size, duration);
        }

    }


    private static int option1(int n, int[] v) {
        int soma = 0;
        for ( int i = 0; i < n ; i ++) {
            soma += v[i];
        }

        return soma;
    }

    private static int option2(int n) {
        int m = 0;
        for ( int i = 1; i < 10 * n ; i ++) {
            for (int j = 1; j < n; j++) {
                m++;
            }
        }
        return m;
    }

    private static int option3(int n) {
        int b = n * n ;
        while ( b > n ) {
            if (b % 2 == 0) {
                b--;
            }
            else {
                b -= 2;
            }
        }

        return b;
    }

    private static int option4(int n) {
        int x = n * n * n ;
        while ( x > 1) {
            x /= 2;
        }
        return x;
    }

    private static int option5(int n) {
        int soma = n * n ;
        while ( soma % 2 == 0) {
            soma--;
        }
        return soma;
    }

    private static int option6(int n, int[][] a, int[][] b, int[][] c) {
        for ( int i = 0; i < n ; i ++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    a[i][j] += b[i][k] * c[k][j];
                }
            }
        }
        return 0;
    }

    private static int option7(int n) {
        int c = 0;
        for ( int i = 0; i < n ; i ++) {
            for (int j = i; j < n; j++) {
                c++;
            }
        }
        return c;
    }

    private static int option8(int n) {
        int c = 0;
        for ( int i = n ; i > 0; i /=2) {
            for (int j = 0; j < i; j++) {
                c++;
            }
        }
        return c;
    }
}