package ex4;

public interface Stack<E> {

    /**
     * Inserir um elemento no topo da pilha
     *
     * @param item O elemento a inserir
     */
    void push(E item);

    /**
     * O elemento no topo da pilha
     *
     * @return O elemento no topo da pilha
     * @requires A pilha não está vazia
     */
    E peek();

    /**
     * Retirar o elemento no topo da pilha
     *
     * @requires A pilha não está vazia
     */
    void pop();

    /**
     * Esta pilha está vazia?
     *
     * @return true se a pilha está vazia, false caso contrário
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Retirar todos os elementos de uma pilha
     */
    default void popAll() {
        while (!isEmpty())
            pop();
    }

    int size();
}