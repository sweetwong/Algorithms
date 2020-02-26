package util.other;

import java.util.List;

class ListUtils {

  public static <T> void printLists(List<List<T>> lists) {
    int size = lists.size();
    if (size == 0) {
      System.out.println("[]");
      return;
    }
    System.out.println("[");
    for (int i = 0; i < size - 1; i++) {
      System.out.println("  " + lists.get(i).toString() + ",");
    }
    System.out.println("  " + lists.get(size - 1));
    System.out.println("]");
  }


}
