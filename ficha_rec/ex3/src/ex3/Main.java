package ex3;

public class Main {
	public static void main(String[] args) {
		String name = "racecar";
		String name2 = "anakin";
		
		System.out.println(palindrome(name, 0, name.length() - 1));
	}
	
	private static boolean palindrome(String str, int begin, int end) {
		if (str.charAt(end) != str.charAt(begin)) {
			return false;
		}
		
		return (begin == end) || palindrome(str, begin + 1, end - 1);
	}
}
