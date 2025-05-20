package ex7;

public class InsertionSort {

    public static int[] sortArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int val = arr[j];

            while (j > 0 && val < arr[j-1]) {
                j--;
            }

            // shifts elements by one position.
            for (int k = i-1; k >= j; k--) {
                arr[k+1] = arr[k];
            }

            arr[j] = val;
        }


        return arr;
    }


    /**
     * exchanges i with j.
     * */
    private static void exch(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
