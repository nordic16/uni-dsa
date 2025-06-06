package ex6;

import utils.ST;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;


/**
 * Uma tabela de símbolos implementada com um vetor ordenado
 * 
 * Algoritmos e Estruturas de Dados 2023-24, Faculdade de Ciências, Universidade
 * de Lisboa
 * 
 * @author Sedgewick and Waine, Algorithms, 4th edition, Addison-Wesley
 *
 * @param <Key>   As chaves desta tabela de símbolos
 * @param <Value> Os valores desta tabela de símbolos
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
	public class Item implements Comparable<Key> {
		private final Key key;
		private Value value;

		public Item(Key k, Value v) {
			this.key = k;
			this.value = v;
		}

		@Override
		public int compareTo(Key o) {
			return key.compareTo(o);
		}
	}

	private Item[] items;
	private int size;
	private static final int DEFAULT_CAPACITY = 10000;
	
	public BinarySearchST () {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public BinarySearchST(int capacity) {
		items = (Item[]) new Object[capacity];
	}
	
	@Override
	public void put(Key key, Value value) {
		int i = rank(key);
		if (i < size && items[i].compareTo(key) == 0) {
			items[i] = new Item(key, value);
			return;
		}
		for (int j = size; j > i; j--) {
			items[j] = items[j - 1];
			items[j] = items[j - 1];
		}
		items[i] = new Item(key, value);
		size++;
	}

	@Override
	public Value get(Key key) {
		int i = rank(key);
		if (i < size && items[i].compareTo(key) == 0)
			return items[i].value;
		else
			return null;
	}

	/**
	 * @param key A chave
	 * @return número de chaves inferiores a key
	 */
	private int rank(Key key) {
		int lo = 0, hi = size - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(items[mid].key);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<Key> iterator() {
		Deque<Key> queue = new ArrayDeque<>();
		for (int i = 0; i < size; i ++)
			queue.add(items[i].key);
		return queue.iterator();
	}

	public void mergesort() {
		mergesort(items, 0, size-1);
	}

	private void mergesort(Item[] items, int lo, int hi) {
		if (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			mergesort(items, lo, mid);
			mergesort(items, mid + 1, hi);

			merge(items, lo, mid, hi);

		}
	}

	private void merge(Item[] items, int lo, int mid, int hi) {
		Item[] left = (Item[]) new Object[mid - lo + 1];
		Item[] right = (Item[]) new Object[hi - mid];

		System.arraycopy(items, lo, left, 0, left.length);
		System.arraycopy(items, mid + 1, right, 0, right.length);

		int i = 0, j = 0, k = lo;

		while (i < left.length && j < right.length) {
			int cmp = items[i].compareTo(items[j].key);
			if (cmp > 0) {
				items[k++] = right[j++];
			} else {
				items[k++] = left[i++];
			}
		}

		while (i < left.length) {
			items[k++] = left[i++];
		}

		while (j < right.length) {
			items[k++] = left[j++];
		}
 	}


}
