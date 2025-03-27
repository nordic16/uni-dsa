package ex6;

import java.util.Arrays;
import java.util.Iterator;

public class PilhaComFuga<E>  {
    private static final int DEFAULT_MAX_SIZE = 16;
    private E[] data;
    private final int maxSize;

    // technically faster (but not necessary) to keep track of current index.
    private int currentIndex = 0; // só necessário caso seja feito com currentIndex++

    public PilhaComFuga() {
        this.maxSize = DEFAULT_MAX_SIZE;
        this.data = (E[]) new Object[maxSize];
    }

    public PilhaComFuga(int maxSize) {
        this.maxSize = maxSize;
        this.data = (E[]) new Object[maxSize];
    }

    /**
     * Feito como se fosse uma pilha.
     * @param key: element a ser adicionado ao topo da pilha. Este exercício ou não faz sentido com um array circular ou é complicado.
     *
     **/
    public void push(E key) {
        for (int i = data.length - 1; i > 0; i--) {
            data[i] = data[i-1];
        }
        data[0] = key;
    }

    public void pop() {
        for (int i = 0; i < data.length - 1; i++) {
            data[i] = data[i+1];
        }
        data[data.length - 1] = null;
    }


    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
