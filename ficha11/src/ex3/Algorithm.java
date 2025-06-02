package ex3;

public class Algorithm {
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0,  arr.length - 1);
    }

    private static void mergeSort(int[] arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;

        if (lo < hi) {
            if (arr.length <= 15) { // 1.
                // no need to call merge here, insertion sort handles everything.
                insertionSort(arr, lo, hi);
            }
            else {
                mergeSort(arr, lo, mid);
                mergeSort(arr, mid + 1, hi);

                if (arr[mid] > arr[mid + 1]) { // 2.
                    merge(arr, lo, mid, hi);
                }

            }
        }
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int[] left = new int[mid - lo + 1];
        int[] right = new int[hi - mid];

        System.arraycopy(arr, lo, left, 0, left.length);
        System.arraycopy(arr, mid + 1, right, 0, right.length);

        int i = 0;
        int j = 0;
        int k = lo;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void insertionSort(int[] arr, int from, int to) {
        for (int i = from + 1; i < to; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                int tmp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = tmp;
            }
        }
    }

}
