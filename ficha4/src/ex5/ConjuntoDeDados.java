package ex5;

public interface ConjuntoDeDados<E> {

    void add (E e);
    boolean contains(E e);
    int size();
    void remove();

    default boolean isEmpty() {
        return size() == 0;
    }
}