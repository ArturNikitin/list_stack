import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListImplTest {
    private LinkedListImpl<String> list;

    @BeforeEach
    void setUp() {
        list = new LinkedListImpl<>();
        list.add("First");
        list.add("Second");
        list.add("Third");
    }

    @Test
    void add() {
        list.add("String");
        assertEquals("String", list.getLast());
    }

    @Test
    void removeFirstByValue() {
        assertEquals("First", list.getFirst());
        list.remove("First");
        assertNotEquals("First", list.getFirst());
        assertEquals("Second", list.getFirst());
        assertEquals("Third", list.getLast());
    }

    @Test
    void removeLastByValue() {
        assertEquals("Third", list.getLast());
        list.remove("Third");
        assertEquals("Second", list.getLast());
        assertEquals("First", list.getFirst());
    }

    @Test
    void addFirst() {
    }

    @Test
    void addLast() {
    }

    @Test
    void removeLast() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void addAfter() {
    }

    @Test
    void contains() {
    }

    @Test
    void size() {
    }

    @Test
    void getFirst() {
    }

    @Test
    void getLast() {
    }
}