import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import net.archasmiel.homework.collections.stack.MyStack;
import net.archasmiel.homework.collections.stack.Stack;
import org.junit.jupiter.api.Test;

public class MyStackTest {

  @Test
  void testMyStack() {
    Stack<String> stack = new MyStack<>();
    stack.push("1");
    stack.push("2");
    stack.push("3");
    stack.push("4");
    stack.push("5");
    assertEquals(5, stack.size());

    assertEquals("5", stack.peek());
    assertEquals(5, stack.size());

    assertEquals("5", stack.pop());
    assertEquals(4, stack.size());

    assertEquals("4", stack.pop());
    assertEquals("3", stack.pop());
    assertEquals("2", stack.pop());
    assertEquals("1", stack.pop());
    assertNull(stack.pop());

    assertEquals(0, stack.size());

    stack.push("1");
    stack.push("2");
    stack.push("3");
    stack.push("4");
    stack.push("5");
    assertEquals(5, stack.size());

    stack.clear();
    assertEquals(0, stack.size());
  }

}
