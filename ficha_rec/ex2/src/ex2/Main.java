package ex2;

public class Main {
	public static void main(String[] args) {
		char[] nums = {'1', '3', '5', '3', '1'};
		
		 System.out.println(parseNums(nums, 0));
	}
	
	private static int parseNums(char[] vec, int pos) {
		int num = vec[pos] - '0';
		int padding = (int) Math.pow(10, vec.length - pos - 1);

		if (pos == vec.length - 1) {
			return num;
		}
		
		return num * padding + parseNums(vec, pos + 1);
	} 
}
