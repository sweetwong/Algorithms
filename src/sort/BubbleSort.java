package sort;

import java.util.Arrays;

class BubbleSort {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 1, 8, 3, -1, 24, 12};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void sort(int[] arr) {
    // i代表不需要被比较的数的量
    // 刚开始i=0,代表所有的数都要比较一遍
    // 之后i=1,代表只需要比较n-1个数
    for (int i = 0; i < arr.length; i++) {
      // j代表指针的位置
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }
}
