package ex3;

public class Algorithm {
    public static void quicksort(Comparable[] arr) {
        quicksort(arr, 0, arr.length-1);
    }

    private static void quicksort(Comparable[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = partition(arr, lo, hi);
            quicksort(arr, lo, mid-1);
            quicksort(arr, mid + 1, hi);
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
}
