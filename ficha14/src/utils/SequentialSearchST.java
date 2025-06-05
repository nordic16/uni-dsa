package utils;

import java.util.*;


/**
 * Uma tabela de símbolos implementada com uma lista não ordenada. Não requer
 * que as chaves estejam equipodas com uma relação de ordem.
 * 
 * Algoritmos e Estruturas de Dados 2022-23, Faculdade de Ciências, Universidade
 * de Lisboa
 * 
 * @author Sedgewick and Waine, Algorithms, 4th edition, Addison-Wesley
 *
 * @param <Key>   As chaves desta tabela de símbolos
 * @param <Value> Os valores desta tabela de símbolos
 */
public class SequentialSearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

	private Node first;
	private int size;

	private class Node {
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	public void put(Key key, Value val) {
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key)) {
				x.val = val;
				return;
			} // Search hit: update val.
		first = new Node(key, val, first); // Search miss: add new node.
		size++;
	}

	public Value get(Key key) {
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key))
				return x.val; // search hit
		return null; // search miss
	}

	public boolean contains(Key key) {
		return get(key) != null; // search miss
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<Key> iterator() {
		Deque<Key> keyList = new ArrayDeque<>();
		for (Node current = first; current != null; current = current.next)
			keyList.add(current.key);
		return keyList.iterator();
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(", ");
		for (Key k : this)
			sj.add(k.toString());
		return "[" + sj.toString() + "]";
	}

	// ex5.
	public Set<Key> keys() {
		Set<Key> keys = new HashSet<>();

		Node node = first;

		while (node != null) {
			keys.add(node.key);
			node = node.next;
		}

		return keys;
	}

	// ex5.
	@Override
	public void delete(Key key) {
		Node node = first;
		while (node != null) {
			if (node.next.key.compareTo(key) == 0) {
				node.next = node.next.next;
				break;
			}
			node = node.next;
		}
	}
}


