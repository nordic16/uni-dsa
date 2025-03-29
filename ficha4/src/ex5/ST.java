package ex5;

/**
 * Associação de valores a chaves
 * 
 * Algoritmos e Estruturas de Dados 2023-24, Faculdade de Ciências, Universidade
 * de Lisboa
 * 
 * @author Sedgewick and Waine, Algorithms, 4th edition, Addison-Wesley
 *
 * @param <Key>   As chaves desta tabela de símbolos
 * @param <Value> Os valores desta tabela de símbolos
 */
public interface ST<Key extends Comparable<Key>, Value> extends Iterable<Key>{

	void put(Key key, Value val);
	
	Value get(Key key);

	int size();
	
	default boolean contains(Key key) { return get(key) != null; };
	
	default boolean isEmpty() { return size() == 0; }
	
	default void delete(Key key) { put(key, null); }
}
