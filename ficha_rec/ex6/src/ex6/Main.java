package ex6;

public class Main {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		for (int i = 1; i <= 20; i++) {
			System.out.println(String.format("For %d: %b", i, canAdd(arr, 0, 1, i)));
		}
		
	}
	
	private static boolean canAdd(int[] arr, int a, int pos, int k) {
		if (pos == arr.length) return false; // para facilitar leitura.
		
		return arr[a] + arr[pos] == k || (pos == arr.length - 1 ? canAdd(arr, a + 1, a + 2, k) : canAdd(arr, a, pos + 1, k));
	}
}
