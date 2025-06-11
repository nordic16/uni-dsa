package utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringJoiner;

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
public class BinarySearchST<Key extends Comparable<Key>, Value> implements Iterable<Key>  {

	private Key[] keys;
	private Value[] vals;
	private int size;
	private static final int DEFAULT_CAPACITY = 10000;
	private static int last_accessed;
	
	public BinarySearchST () {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	

	public void put(Key key, Value val) {
		int i = rank(key);

		if (i < size-1) { // if i is largest element there is no need to shift any elements to the right. (ex 11)
			if (keys[i].compareTo(key) == 0) {
				vals[i] = val;
				return;
			}
			for (int j = size; j > i; j--) {
				keys[j] = keys[j - 1];
				vals[j] = vals[j - 1];
			}
		}
		keys[i] = key;
		vals[i] = val;
		size++;
	}

	public Value get(Key key) {
		int i = rank(key);
		if (i < size && keys[i].compareTo(key) == 0) {
			last_accessed = i;
			return vals[i];
		}

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
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<Key> iterator() {
		Deque<Key> queue = new ArrayDeque<>();
		for (int i = 0; i < size; i ++)
			queue.add(keys[i]);
		return queue.iterator();
	}

	// Exercise 8...
	public void delete(Key key) {
		for (int i = 0; i < size; i++) {
			if (keys[i].compareTo(key) == 0) {
				for (int j = i+1; j < size; j++) {
					exch(keys, j, j-1);
					exch(vals, j, j-1);
				}

				// effectively removing them from the list...
				// optional, except for size-- and break.
				keys[size-1] = null;
				vals[size-1] = null;
				size--;
				break;
			}
		}
	}

	private static void exch(Object[] keys, int j, int i) {
		Object tmp = keys[j];
		keys[j] = keys[i];
		keys[i] = tmp;
	}

	public String toString() {
		StringJoiner sj = new StringJoiner(", ");
		for (Key k : this) {
			sj.add(k.toString());
		}
		return "[" + sj.toString() + "]";
	}


	// ex10 a)
	/**
	 * @param key
	 * @return a maior chave <= key.
	 * */
	public Key floor(Key key) {
		Key max = keys[0];

        for (Key val : this) {
            if (val.compareTo(max) > 0 && val.compareTo(key) <= 0) {
                max = val;
            }
        }
		return max;
	}

	// ex 10 b) (assumido que delete() não pode ser utilizado).
	public void deleteMin() {
		for (int i = 1; i < size; i++) {
			keys[i-1] = keys[i];
			vals[i-1] = vals[i];
		}
		keys[size-1] = null;
		vals[size-1] = null;
		size--;
	}

	// ex 10 c) (assumindo que delete() não pode ser utilizado).
	public void deleteMax() {
		keys[size-1] = null;
		vals[size-1] = null;
		size--;
	}

	// ex10

	public boolean contains(Key key) {
		if (keys[last_accessed] != null && keys[last_accessed].compareTo(key) == 0) {
			return true;
		}

		return get(key) != null;
	}
}
