package ex3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int[] arr = new int[120];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 251);
        }

        System.out.printf("Original array: %s%n", Arrays.toString(arr));
        Algorithm.mergeSort(arr);
        System.out.printf("Sorted array: %s%n", Arrays.toString(arr));
    }
}
