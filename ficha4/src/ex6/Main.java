package ex6;

public class Main {
    public static void main(String[] args) {
        PilhaComFuga<Integer> x = new PilhaComFuga<>(4);
        x.push(25);
        x.push(2);
        x.push(4);

        x.push(5);
        x.push(6);

        x.pop();
        System.out.println(x);
    }
}
