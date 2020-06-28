import java.util.function.Consumer;

public interface LinkedList<T> {
    boolean add(T value);
    boolean remove(T value);
    boolean addFirst(T value);
    boolean addLast(T value);
    boolean removeFirst();
    boolean addAfter(T previousValue, T value);
    boolean contains(T value);
    T getFirst();
    T getLast();
    int size();
    LinkedList<T> reverse();
    void forEach(Consumer<? super T> action);
}
