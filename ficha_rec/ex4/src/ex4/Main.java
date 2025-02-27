package ex4;

public class Main {
	public static void main(String[] args) {
		String p = "abc";
		System.out.println(reverse(p, 0));
	}
	
	private static StringBuilder reverse(String s, int p) {
		return (p == s.length() - 1 ? new StringBuilder(s.charAt(p)) : reverse(s, p + 1)).append(s.charAt(p)); 
	}


}
