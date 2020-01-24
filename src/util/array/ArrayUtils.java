package util.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtils {

  /**
   * @param n 随机数组的长度
   * @return n个随机数字组成的数组
   */
  public static int[] createRandomArray(int n) {
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++)
      arr[i] = (int) (Math.random() * Integer.MAX_VALUE);
    return arr;
  }

  /**
   * @param n   随机数组的长度
   * @param max 每个数字的最大值
   * @return n个随机数字组成的数组
   */
  public static int[] createRandomArray(int n, int max, boolean neg) {
    if (max == 0) max = Integer.MAX_VALUE;
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      double num = Math.random() * max;
      if (neg && Math.random() < 0.5) num = -num;
      arr[i] = (int) num;
    }
    return arr;
  }

  public static int[] convertIntToArray(int x) {
    List<Integer> list = new ArrayList<>();
    while (x != 0) {
      int pop = x % 10;
      list.add(pop);
      x = x / 10;
    }
    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(list.size() - 1 - i);
    }
    return res;
  }

  public static void printArray(int[] nums) {
    System.out.println(toString(nums));
  }

  public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      System.out.print(addEmpty(String.valueOf(row[0])));
      for (int i = 1; i < row.length; i++) {
        System.out.print(" " + addEmpty(String.valueOf(row[i])));
      }
      System.out.println();
    }
  }

  public static String addEmpty(String s) {
    int len = s.length();
    if (len == 0) {
      return "   ";
    } else if (len == 1) {
      return s + "  ";
    } else {
      return s + " ";
    }
  }

  public static String toString(int[] a) {
    if (a == null)
      return "null";
    int iMax = a.length - 1;
    if (iMax == -1)
      return "[]";

    StringBuilder b = new StringBuilder();
    b.append('[');
    for (int i = 0; ; i++) {
      b.append(i);
      b.append(": ");
      b.append(a[i]);
      if (i == iMax)
        return b.append(']').toString();
      b.append(", ");
    }
  }


}
