package ex8;

import utils.BinarySearchST;

public class Ex8 {
    public static void main(String[] args) {
        BinarySearchST<String, Integer> keys = new BinarySearchST<>();
        keys.put("hello", 1);
        keys.put("there", 45);
        keys.put("execute order", 66);
        keys.put("Anakin Skywalker", 66);

        System.out.printf("Before deletion: %s\n", keys);
        keys.delete("there");
        System.out.printf("After deletion: %s\n", keys);
        System.out.println("\nSorry, Anakin...");
        keys.delete("Anakin Skywalker");
        System.out.printf("After deletion: %s", keys);
    }
}
