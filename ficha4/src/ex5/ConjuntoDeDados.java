package ex5;

public interface ConjuntoDeDados<E> {

    void add (E e);
    boolean contains(E e);

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();
}
