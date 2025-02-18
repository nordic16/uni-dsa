import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class Exercise0 {

	public static void copyText (String fileIn, String
			fileOut) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File(fileIn));
		PrintWriter writer = new PrintWriter(new File(fileOut));
		
		
		while (scanner.hasNextLine()) {
			writer.println(scanner.nextLine());
		}
		
		scanner.close();
		writer.close();
	}
	
	public static void writeSquares (String fileIn, String
			fileOut) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File(fileIn));
		PrintWriter writer = new PrintWriter(new File(fileOut));
		
		while (scanner.hasNextInt()) {
			int x = scanner.nextInt();
			x = x * x;
			writer.println(x);
		} 
		scanner.close();
		writer.close();
	}
	
	public static void writeMultiples (String fileIn, String
			fileOut, int n) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File(fileIn));
		PrintWriter writer = new PrintWriter(fileOut);
		
		while(scanner.hasNextInt()) {
			int x = scanner.nextInt();
			
			if (x % n == 0) {
				writer.println(scanner.nextInt());
			}
		}
		scanner.close();
		writer.close();
	}
	
	public static void lowerUpper(String fileIn, String
			fileOut) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File(fileIn));
		PrintWriter writer = new PrintWriter(new File(fileOut));
		int n = 1;
		
		while (scanner.hasNextLine()) {
			String line  = scanner.nextLine();			
			
			if (n % 2 == 0) {
				line = line.toUpperCase();
			
			} else {
				line = line.toLowerCase();
			}
			
			writer.println(line);
			n++;
		}
		scanner.close();
		writer.close();	
	}
	
	public static void commonElements (String fileIn, String
			fileOut, int[] values) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File(fileIn));
		PrintWriter writer = new PrintWriter(new File(fileOut));
		
		while (scanner.hasNextInt()) {
			int x = scanner.nextInt();
						
			for (int val : values) {
				if(val == x) {
					writer.println(x);
				}
			}
		}
		scanner.close();
		writer.close();
		
	}

}
