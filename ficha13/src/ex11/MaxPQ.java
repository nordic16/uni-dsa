package ex11;

import java.util.Arrays;

/**
 * Fila de prioridades orientada ao máximo
 * 
 * Algoritmos e Estruturas de Dados 2023-24, Faculdade de Ciências, Universidade
 * de Lisboa
 * 
 * @author Sedgewick and Waine, Algorithms, 4th edition, Addison-Wesley
 *
 * @param <Key> O tipo dos elementos nesta fila de prioridades
 */
public class MaxPQ<Key extends Comparable<Key>> {

	private final Key[] pq;
	private int size;

	@SuppressWarnings("unchecked")
	public MaxPQ(int n) {
		pq = (Key[]) new Comparable[n + 1];
	}

	public void insert(Key key) {
		pq[++size] = key;
		swim(size);
	}

	public int size() {
		return size;
	}

	public Key delMax() {
		Key max = pq[1];
		exch(1, size);
		pq[size--] = null;
		sink(1);
		return max;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= size) {
			int j = 2 * k;
			if (j < size && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	@Override
	public String toString () {
		return Arrays.toString(Arrays.copyOfRange(pq, 1, size + 1));
	}
}
