public interface Stack<T> {
    boolean add(T value);
    T peek();
    T poll();
    int size();
}
