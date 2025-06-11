package Ex1;

import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        char[] arr = {'a', 'e', 'd'};
        System.out.printf("Before reversal: %s\n", Arrays.toString(arr));
        reverse(arr);
        System.out.printf("After reversal: %s\n", Arrays.toString(arr));

    }


    private static void reverse(char[] arr) {
        reverse(arr, 0, arr.length-1);
    }

    private static void reverse(char[] arr, int lo, int hi) {
        if (hi <= lo) { return; }

        char tmp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = tmp;
        reverse(arr, lo+1, hi-1);
    }

}



