import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import net.archasmiel.homework.collections.queue.MyQueue;
import net.archasmiel.homework.collections.queue.Queue;
import org.junit.jupiter.api.Test;

public class MyQueueTest {

  @Test
  void testMyQueue() {
    Queue<String> queue = new MyQueue<>();
    queue.add("1");
    queue.add("2");
    queue.add("3");
    queue.add("4");
    queue.add("5");
    assertEquals(5, queue.size());

    assertEquals("1", queue.peek());
    assertEquals(5, queue.size());

    assertEquals("1", queue.poll());
    assertEquals(4, queue.size());

    assertEquals("2", queue.poll());
    assertEquals("3", queue.poll());
    assertEquals("4", queue.poll());
    assertEquals("5", queue.poll());
    assertNull(queue.poll());

    assertEquals(0, queue.size());

    queue.add("1");
    queue.add("2");
    queue.add("3");
    queue.add("4");
    queue.add("5");
    assertEquals(5, queue.size());

    queue.clear();
    assertEquals(0, queue.size());
  }

}
