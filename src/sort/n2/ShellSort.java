package sort.n2;

import java.util.Arrays;

/**
 * 希尔排序, 是一种插入排序的变种, 在插入排序的基础上进行了优化
 * 时间复杂度O(nlog²n), 最好O(nlog²n), 最坏也是O(nlog²n), 空间复杂度O(1), 不稳定, 原地算法
 */
public class ShellSort {

  public static void main(String[] args) {
    int[] arr = new int[0];
    shellSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void shellSort(int[] arr) {
    int length = arr.length;
    int temp;
    for (int step = length / 2; step >= 1; step /= 2) {
      for (int i = step; i < length; i++) {
        temp = arr[i];
        int j = i - step;
        while (j >= 0 && arr[j] > temp) {
          arr[j + step] = arr[j];
          j -= step;
        }
        arr[j + step] = temp;
      }
    }
  }

}
