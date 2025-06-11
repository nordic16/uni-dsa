package utils;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Random;

/**
 * Uma tabela de símbolos implementada com uma árvore binária de pesquisa
 * 
 * Algoritmos e Estruturas de Dados 2023-24, Faculdade de Ciências, Universidade
 * de Lisboa
 * 
 * @author Sedgewick and Waine, Algorithms, 4th edition, Addison-Wesley
 *
 * @param <Key>   As chaves desta tabela de símbolos
 * @param <Value> Os valores desta tabela de símbolos
 */
public class BST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

	private Node root;
	private static final Random random = new Random(System.currentTimeMillis());

	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private int n;

		public Node(Key key, Value val, int n) {
			this.key = key;
			this.val = val;
			this.n = n;
		}


		@Override
		public String toString() {
			return key.toString();
		}
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node x) {
		return x == null ? 0 : x.n;
	}

	@Override
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		// Return the value associated with key in the subtree rooted at x; return null
		// if key not present in subtree rooted at x.
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.val;
	}

	@Override
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		// Change key’s value to val if key in subtree rooted at x.
		// Otherwise, add new node to subtree associating key with val.
		if (x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}

	/**
	 * @return O mais pequena chave na árvore
	 * @requires A árvore não é vazia
	 */
	public Key min() {
		return min(root).key;
	}

	private Node min(Node x) {
		return x.left == null ? x : min(x.left);
	}

	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null)
			return null;
		return x.key;
	}

	private Node floor(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;
		if (cmp < 0)
			return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null)
			return t;
		else
			return x;
	}

	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		// Return number of keys less than x.key in the subtree rooted at x.
		if (x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return rank(key, x.left);
		else if (cmp > 0)
			return 1 + size(x.left) + rank(key, x.right);
		else
			return size(x.left);
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public Iterator<Key> iterator() {
		Queue<Key> queue = new ArrayDeque<>();
		fill(root, queue);
		return queue.iterator();
	}

	private void fill(Node x, Queue<Key> queue) {
		if (x == null) return;
		fill(x.left, queue);
		queue.add(x.key);
		fill(x.right, queue);
	}

	// ex 5 (a)
	public int height() {
		return height(root);
	}


	private int height(Node x) {
		if (x == null) { return 0; }
		if (x.left == null) {
			return 1 + height(x.right);
		}
		return 1 + height(x.left);
	}

	public Key min_i() {
		return min_i(root);
	}

	// 7) a)
	private Key min_i(Node node) {
		Node val = node.left;
		while (val.left != null) {
			val = val.left;
		}
		return val.key;
	}


	public Key floor_i(Key max) {
		return floor_i(root, max);
	}

	// 7 b)
	private Key floor_i(Node n, Key max) {
		Key current = min_i();

		while (n != null) {
			int cmp = n.key.compareTo(max);
			if (cmp == 0) { return n.key; }

			if (cmp > 0) {
				n = n.left;
			} else {
				current = n.key;
				n = n.right;
			}
		}

		return current;
	}

	public Node select(int rk) {
		return select(root, rk);
	}

	// ex 9
	private Node select(Node n, int rk) {
		if (n == null) {
			return null;
		}
		int cmp = rank(n.key);
		if (cmp > rk) {
			return select(n.left, rk);

		}
		else if (cmp < rk) {
			return select(n.right, rk);

		}
		else {
			return n;
		}
	}

	// ex 10
	public Key randomKey() {
		return select(random.nextInt(size())).key;
	}
}
