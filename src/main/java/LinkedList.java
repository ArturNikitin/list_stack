

public interface LinkedList<T> {
    boolean add(T value);
    boolean remove(T value);
    boolean addFirst(T value);
    boolean addLast(T value);
    boolean removeLast();
    boolean removeFirst();
    boolean addAfter(T previousValue, T value);
    boolean contains(T value);
    T getFirst();
    T getLast();
    int size();
    LinkedList<T> reverse(LinkedList<T> list);
}
