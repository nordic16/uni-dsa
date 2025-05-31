package ex5;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Random random = new Random(System.currentTimeMillis());
    private static final int M = 4;

    public static void quicksort(Comparable[] arr) {
        quicksort(arr, 0, arr.length-1);
    }

    private static void quicksort(Comparable[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = partition(arr, lo, hi);

            if ((mid - 1) - lo <= M) {
                insertionsort(arr, lo, mid-1);
            } else {
                quicksort(arr, lo, mid-1);
            }

            if (hi - (mid + 1) <= M) {
                insertionsort(arr, mid+1, hi);
            } else {
                quicksort(arr, mid+1, hi);
            }
        }
    }

    private static void insertionsort(Comparable[] arr, int lo, int hi) {
        for (int i = lo+1; i <= hi; i++) {
            int j = i;

            while (j > lo && arr[j].compareTo(arr[j-1]) < 0) {
                exch(arr, j, j-1);
                j--;
            }
        }
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1; // + 1 because otherwise last element wouldn't be compared to pivot (element at lo).

        while (true) {
            while (arr[++i].compareTo(arr[lo]) < 0) { if (i == hi) break; }
            while (arr[--j].compareTo(arr[lo]) > 0) { if (j == lo) break; }
            if (i >= j) { break; }
            exch(arr, i, j);
        }
        exch(arr, lo, j); // pivot is now at correct place.
        return j;
    }

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] arr = random.ints(48, 0, 26).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));
        quicksort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
