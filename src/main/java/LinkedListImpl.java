import java.util.Objects;
import java.util.function.Consumer;

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
            header.lastElement = node;
        } else {
            Node<T> previousElement = header.lastElement;
            header.lastElement = node;
            previousElement.nextElement = node;
        }
        size++;
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
                    size--;
                    return true;
                } else if (currentNode.nextElement == null) {
                    header.lastElement = previousNode;
                    size--;
                    return true;
                } else {
                    previousNode.nextElement = nextNode;
                    size--;
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
        Node<T> node = new Node<>(value);
        if (header.firstElement == null) {
            header.firstElement = node;
            header.lastElement = node;
        } else {
            node.nextElement = header.firstElement;
            header.firstElement = node;
        }
        size--;
        return true;
    }

    @Override
    public boolean addLast(T value) {
        add(value);
        return true;
    }


    @Override
    public boolean removeFirst() {
        Node<T> node = header.firstElement.nextElement;
        header.firstElement = node;
        size--;
        return true;
    }

    @Override
    public boolean addAfter(T previousValue, T value) {
        Node<T> node = new Node<>(value);
        Node<T> currentNode = header.firstElement;
        Node<T> previousNode = null;
        Node<T> nextNode = null;
        do {
            nextNode = currentNode.nextElement;
            if (currentNode.value.equals(previousValue)) {
                if (currentNode.nextElement == null) {
                    header.lastElement = node;
                } else {
                    node.nextElement = nextNode;
                }
                currentNode.nextElement = node;
                size++;
                return true;
            }
            previousNode = currentNode;
            currentNode = nextNode;
        } while (previousNode.nextElement != null);

        return false;
    }

    @Override
    public boolean contains(T value) {
        Node<T> currentNode = header.firstElement;
        Node<T> nextNode = currentNode.nextElement;
        while (currentNode != null) {
            nextNode = currentNode.nextElement;
            if (currentNode.value.equals(value)) {
                return true;
            } else {
                currentNode = nextNode;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
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
    public LinkedList<T> reverse() {
        Node<T> currentElement = this.header.firstElement;
        Node<T> previousElement = null;
        Node<T> nextElement = currentElement.nextElement;
        this.header.lastElement = currentElement;
        do {
            currentElement.nextElement = previousElement;
            previousElement = currentElement;
            currentElement = nextElement;
            nextElement = currentElement.nextElement;
        } while (currentElement.nextElement != null);
        currentElement.nextElement = previousElement;
        this.header.firstElement = currentElement;
        return this;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        Node<T> currentElement = header.firstElement;
        Node<T> nextElement = null;
        while (currentElement != null) {
            nextElement = currentElement.nextElement;
            action.accept(currentElement.value);
            currentElement = nextElement;
        }
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
