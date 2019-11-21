package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArray {

  /**
   * @param n 随机数组的长度
   * @return n个随机数字组成的数组
   */
  public static int[] createRandomArrays(int n) {
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      double num = Math.random() * Integer.MAX_VALUE;
      arr[i] = (int) num;
    }
    return arr;
  }

  /**
   * @param n   随机数组的长度
   * @param max 每个数字的最大值
   * @return n个随机数字组成的数组
   */
  public static int[] createRandomArrays(int n, int max) {
    if (max == 0) max = Integer.MAX_VALUE;
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      double num = Math.random() * max;
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

  public static void printArray(int[] arr) {
    System.out.println(Arrays.toString(arr));
  }


}
