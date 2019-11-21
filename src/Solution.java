import util.MyArray;
import util.MyHeap;

public class Solution {

  public static void main(String[] args) {
    int[] arr = MyArray.createRandomArrays(8, 50);
    MyArray.printArray(arr);
    System.out.println();
    MyHeap.printHeap(arr);
  }

}