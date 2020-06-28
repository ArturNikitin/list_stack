import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListImplTest {
    private LinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new LinkedListImpl<>();
        list.add("First");
        list.add("Second");
        list.add("Third");
    }

    @Test
    void size() {
        assertEquals(3, list.size());
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
        list.addFirst("NewFirst");
        assertEquals("NewFirst", list.getFirst());
    }

    @Test
    void addLast() {
        list.addLast("NewFirst");
        assertEquals("NewFirst", list.getLast());
    }

    @Test
    void removeFirst() {
        list.removeFirst();
        assertEquals("Second", list.getFirst());
    }

    @Test
    void addAfter() {
        assertEquals("Third", list.getLast());
        list.addAfter("Third", "Fourth");
        assertEquals("Fourth", list.getLast());
    }

    @Test
    void containsTrue() {
        boolean result = list.contains("Third");
        assertTrue(result);
    }

    @Test
    void containsFalse() {
        assertFalse(list.contains("Fourth"));
    }

    @Test
    void getFirst() {
        assertEquals("First", list.getFirst());
    }

    @Test
    void getLast() {
        assertEquals("Third", list.getLast());
    }

    @Test
    void reverse() {
        String first = list.getFirst();
        String last = list.getLast();
        list.reverse();
        assertEquals(first, list.getLast());
        assertEquals(last, list.getFirst());

    }
    @Test
    void reverseMoreValues() {
        list.add("oops");
        list.add("well");
        String first = list.getFirst();
        String last = list.getLast();
        list.reverse();
        assertEquals(first, list.getLast());
        assertEquals(last, list.getFirst());
        list.remove("well");
        assertEquals("oops", list.getFirst());
    }
}