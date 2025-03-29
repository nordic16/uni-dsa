package ex5;

import ex2.LinkedStack;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class MoveToFrontSet<E> implements ConjuntoDeDados<E> {
    private int size;
    private Node first;

    private class Node {
        E item;
        Node next;

        public Node(E item) {
            this.item = item;
        }
    }

    @Override
    public void add(E e) {
        Node oldFirst = this.first;
        this.first = new Node(e);
        this.first.next = oldFirst;
        size++;
    }

    @Override
    public void remove() {
        if (size > 0) {
            first = first.next;
            size--;
        }
    }

    @Override
    public boolean contains(E e) {
        Node current = this.first;

        while (current != null) {
            if (current.item.equals(e)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
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
}
