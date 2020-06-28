import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackImplTest {
    private Stack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new StackImpl<>();
        stack.add("default");
    }

    @Test
    void add() {
        stack.add("First");
        assertEquals("First", stack.peek());
    }

    @Test
    void peek() {
        assertEquals("default", stack.peek());
    }

    @Test
    void peekTwoTimes() {
        assertEquals("default", stack.peek());
        assertEquals("default", stack.peek());
    }

    @Test
    void poll() {
        assertEquals("default", stack.poll());
    }

    @Test
    void pollTwoTimes() {
        stack.add("new");
        assertEquals("new", stack.poll());
        assertEquals("default", stack.poll());
    }

    @Test
    void pollNull() {
        assertEquals("default", stack.poll());
        assertNull(stack.poll());
    }

    @Test
    void size() {
        stack.add("First");
        stack.add("Second");
        stack.add("Third");
        assertEquals(4, stack.size());
        stack.add("Forth");
        assertEquals(5, stack.size());
    }
}