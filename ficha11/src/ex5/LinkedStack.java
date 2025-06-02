package ex5;
import java.util.Stack;

public class LinkedStack<E> extends Stack<E> {
    private class Node {
        E item;
        Node next;

        public Node(E item) {
            this.item = item;
        }
    }
    private Node first;
    private int size;

    @Override
    public E push(E val) {
        Node oldFirst = this.first;
        this.first = new Node(val);
        this.first.next = oldFirst;
        size++;

        return val;
    }

    @Override
    public E pop() {
        E item = this.first.item;
        this.first = this.first.next;
        size--;

        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node node = this.first;

        while (node != null) {
            sb.append(node.item.toString());

            if (node.next != null) {
                sb.append(", ");
            }

            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // PART OF EXERCISE 4.

    /***
     * Solução O(1) para size()
     *
     * @return tamanho da lista.
     */
    @Override
    public int size() {
        return size;
    }

    private Node mergesort(Node head) {
        if (head.next == null) {
            return head;
        }

        int mid = size() / 2;
        Node node = head;
        for (int i = 0; node.next != null && i < mid; i++) {
            node = node.next;
        }


        
    }
}
