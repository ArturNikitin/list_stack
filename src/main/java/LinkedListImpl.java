public class LinkedListImpl<T> implements LinkedList<T> {
    private final Header<T> header;
    private int size;

    public LinkedListImpl() {
        header = new Header<>();
    }

    @Override
    public boolean add(T value) {
        Node<T> node = new Node<T>(value);

        if (header.firstElement == null) {
            header.firstElement = node;
        }

        if (header.lastElement == null) {
            header.lastElement = node ;
        } else {
            Node<T> previousElement = header.lastElement;
            header.lastElement = node;
            previousElement.nextElement = node;
        }
        return true;
    }

    @Override
    public boolean remove(T value) {
        Node<T> currentNode = header.firstElement;
        Node<T> previousNode = null;
        do {
            Node<T> nextNode = currentNode.nextElement;
            if (currentNode.value.equals(value)) {
                if (previousNode == null) {
                    header.firstElement = nextNode;
                    if (currentNode.nextElement == null) {
                        header.lastElement = previousNode;
                    }
                    return true;
                } else if (currentNode.nextElement == null){
                    header.lastElement = previousNode;
                    return true;
                } else {
                    previousNode.nextElement = nextNode;
                    return true;
                }
            } else {
                previousNode = currentNode;
                currentNode = nextNode;
            }
        } while (previousNode.nextElement != null);

        return false;
    }

    @Override
    public boolean addFirst(T value) {
        return false;
    }

    @Override
    public boolean addLast(T value) {
        add(value);
        return true;
    }

    @Override
    public boolean removeLast() {
        return false;
    }

    @Override
    public boolean removeFirst() {
        return false;
    }

    @Override
    public boolean addAfter(T previousValue, T value) {
        return false;
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T getFirst() {
        return header.firstElement.value;
    }

    @Override
    public T getLast() {
        return header.lastElement.value;
    }

    @Override
    public LinkedList<T> reverse(LinkedList<T> list) {
        return null;
    }

    static class Header<T> {
        private Node<T> firstElement;
        private Node<T> lastElement;
    }

    static class Node<T> {
        private T value;
        private Node<T> nextElement;

        public Node(T value) {
            this.value = value;
        }
    }
}
