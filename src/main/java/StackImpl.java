public class StackImpl<T> implements Stack<T> {
    private int size;
    private Header<T> header;

    public StackImpl() {
        this.header = new Header<>();
    }

    @Override
    public boolean add(T value) {
        Node<T> node = new Node<>(value);
        if (header.firstElement == null) {
            header.firstElement = node;
            size++;
            return true;
        }
        node.nextElement = header.firstElement;
        header.firstElement = node;
        size++;
        return true;
    }

    @Override
    public T peek() {
        return header.firstElement.value;
    }

    @Override
    public T poll() {
        if (header.firstElement == null) {
            return null;
        } else {
            final Node<T> current = header.firstElement.nextElement;
            T result = header.firstElement.value;
            header.firstElement = current;
            size--;
            return result;
        }
    }

    @Override
    public int size() {
        return size;
    }

    class Node<T> {
        private T value;
        private Node<T> nextElement;

        public Node(T value) {
            this.value = value;
        }
    }

    class Header<T> {
        private Node<T> firstElement;
    }
}
