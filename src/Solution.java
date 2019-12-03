import sort.MergeSort;
import sort.Person;
import sort.QuickSort;
import util.Array;

import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    int[] arr = Array.createRandomArrays(100, 1000, false);
    QuickSort.sort(arr);
    Array.printArray(arr);
  }

}