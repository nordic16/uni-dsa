package ex14;

import ex13.Date;
import ex13.Transaction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        primeirasTransacoes("/Users/xkyfal/Documents/programming/uni-dsa/ficha10/src/ex14/file.txt", 4);
    }

    private static Transaction[] primeirasTransacoes(String ficheiro, int quantas) throws FileNotFoundException {
        Transaction[] transactions = new Transaction[quantas];

        try(Scanner sc = new Scanner(new File(ficheiro))) {
            for (int i = 0; i < quantas && sc.hasNextLine(); i++) {
                String[] splt = sc.nextLine().split(" ");
                Date date = new Date(Integer.parseInt(splt[0]), Integer.parseInt(splt[1]), Integer.parseInt(splt[2]));
                transactions[i] = new Transaction(date, Double.parseDouble(splt[3]));
            }
        }

        Arrays.sort(transactions);

        System.out.println(Arrays.toString(transactions));

        return transactions;
    }
}
