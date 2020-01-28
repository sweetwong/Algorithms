package leet_code;

import java.util.Comparator;
import java.util.PriorityQueue;

class Item215_数组中第K个最大元素 {

  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest(nums, 2));;
  }

  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        return b - a;
      }
    });

    for (int num : nums) pq.offer(num);

    int res = nums[0];
    for (int i = 0; i < k; i++) {
      res = pq.poll();
    }

    return res;
  }

}
