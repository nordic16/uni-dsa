package ex1;


import java.util.Arrays;
import java.util.Random;

import static ex3.Algorithm.quicksort;

public class Ex1 {
    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Integer[] arr = random.ints(16, 0, 257).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
