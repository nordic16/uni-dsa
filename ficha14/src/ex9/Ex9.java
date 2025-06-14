package ex9;

import utils.BinarySearchST;

public class Ex10 {
    public static void main(String[] args) {
        BinarySearchST<Integer, Integer> numbers = new BinarySearchST<>();
        numbers.put(1, 0);
        numbers.put(2, 25);
        numbers.put(3, 42);
        System.out.println(numbers);

        // a)
        System.out.printf("Floor %d: %s\n", 5, numbers.floor(5));
        System.out.printf("Floor %d: %s\n", 2, numbers.floor(2));

        //b)
        numbers.put(0, 255);
        System.out.printf("\nBefore removal: %s\n", numbers);
        numbers.deleteMin();
        System.out.printf("After removal: %s\n", numbers);

        // c)
        numbers.put(5, 255);
        System.out.printf("\nBefore removal: %s\n", numbers);
        numbers.deleteMax();
        System.out.printf("After removal: %s\n", numbers);

    }
}
