import static org.junit.jupiter.api.Assertions.assertEquals;

import net.archasmiel.homework.collections.hashmap.HashMap;
import net.archasmiel.homework.collections.hashmap.MyHashMap;
import org.junit.jupiter.api.Test;

public class MyHashMapTest {

  @Test
  void testMyHashMap() {
    HashMap<Integer, String> map = new MyHashMap<>();
    map.put(1, "111");
    map.put(2, "22");
    map.put(3, "3");
    map.put(4, "4444");
    map.put(5, "55555");
    assertEquals(5, map.size());

    assertEquals("111", map.get(1));
    assertEquals("22", map.get(2));
    assertEquals("3", map.get(3));
    assertEquals("4444", map.get(4));
    assertEquals("55555", map.get(5));

    map.remove(1);
    map.remove(3);
    map.remove(5);
    assertEquals(2, map.size());

    map.put(1, "1");
    map.put(2, "2");
    map.put(3, "3");
    map.put(4, "4");
    map.put(5, "5");
    assertEquals(5, map.size());

    assertEquals("1", map.get(1));
    assertEquals("2", map.get(2));
    assertEquals("3", map.get(3));
    assertEquals("4", map.get(4));
    assertEquals("5", map.get(5));

    map.clear();
    assertEquals(0, map.size());
  }

}
