package sort;

import java.util.Arrays;

class SelectionSort {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 1, 8, 3, -1, 24, 12};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void sort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      // 选出最小的index
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      // 交换i和最小的index
      int temp = arr[i];
      arr[i] = arr[minIndex];
      arr[minIndex] = temp;
    }
  }
}
