import static org.junit.jupiter.api.Assertions.assertEquals;

import net.archasmiel.homework.collections.list.List;
import net.archasmiel.homework.collections.list.MyArrayList;
import org.junit.jupiter.api.Test;


public class MyArrayListTest {

  @Test
  void testMyArrayList() {
    List<String> list = new MyArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    assertEquals(5, list.size());

    list.remove(5);
    assertEquals(5, list.size());

    list.remove(3);
    assertEquals(4, list.size());

    list.clear();
    assertEquals(0, list.size());
  }

}
