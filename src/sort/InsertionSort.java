package sort;

import java.util.Arrays;

class InsertionSort {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 1, 8, 3, -1, 24, 12};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int p = i;
      while (arr[p] > arr[i] && --p > 0) {
      }
      int temp = arr[p];
      arr[p] = arr[i];
      arr[i] = temp;
    }
  }
}
