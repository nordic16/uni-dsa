package ex3;

import java.util.Arrays;
import java.util.Stack;

public class ArrayStack<E> extends Stack<E> {
    private E[] data;
    private int length;

    public ArrayStack(int length) {
        this.data = (E[]) new Object[length];
        this.length = 0;
    }

    @Override
    public E push(E val) {
        int length = this.data[data.length - 1] == null ? data.length : data.length + 1;
        int lengthToCopy = this.data[data.length - 1] == null ? data.length - 1 : data.length;
        E[] newData = (E[]) new Object[length];
        System.arraycopy(this.data, 0, newData, 1, lengthToCopy);
        newData[0] = val;

        this.data = newData;
        this.length++;

        return val;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.data);
    }
}
