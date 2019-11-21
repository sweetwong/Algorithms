package util;

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
   * @param n 随机数组的长度
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


}
