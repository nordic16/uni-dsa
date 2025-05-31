package ex6;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Random random = new Random(System.currentTimeMillis());

    public static void quicksort(Comparable[] arr) {
        quicksort(arr, 0, arr.length-1);
    }

    ///  TODO: figure out tomorrow.
    private static void quicksort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int gt = hi, lt = lo;
        int i = lo+1;
        Comparable v = arr[lo];

        while (i <= gt) {
            int cmp = arr[i].compareTo(v);
            if (cmp < 0) {
                exch(arr, lt++, i++);
            } else if (cmp > 0) {
                exch(arr, i, gt--);
            } else {
                i++;
            }
        }

        quicksort(arr, lo, lt-1);
        quicksort(arr, gt+1,  hi);
    }



    private static void exch(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        Integer[] arr = random.ints(40, 0 , 256).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
