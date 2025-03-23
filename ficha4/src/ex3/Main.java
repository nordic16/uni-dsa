package ex3;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> e = new ArrayStack<>(1);
        e.push(1);
        e.push(2);
        e.push(2);
        e.push(4);

        System.out.println(e.toString());
        System.out.println(e.size());
    }
}
