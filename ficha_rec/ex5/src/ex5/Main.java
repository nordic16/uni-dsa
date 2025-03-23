package ex5;

public class Main {
	public static void main(String[] args) {
		int[] nums = { 5, 3, 1, 2, 6 };
		nums = rearrange(nums, 0, 0);
		
		for (int n : nums) {
			System.out.print(n + " ");
		}
	}

	private static int[] rearrange(int[] arr, int a, int pos) {
		while(arr[a] % 2 == 0) a++;
		
		if (arr[pos] % 2 == 0) {
			int tmp = arr[a];
			arr[a] = arr[pos];
			arr[pos] = tmp;
			a++;
		}
		
		return (pos == arr.length - 1 ? arr : rearrange(arr, a, pos+1));

	}
}
