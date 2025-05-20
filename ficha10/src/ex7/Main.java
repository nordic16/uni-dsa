package ex7;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[6];
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(0, 101);
        }

        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("Sorted array: " + Arrays.toString(InsertionSort.sortArray(nums)));
    }
}
