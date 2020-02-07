package leet_code;

import java.util.Comparator;
import java.util.PriorityQueue;

class Item215_数组中第K个最大元素 {

  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest(nums, 2));
    ;
  }

  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

    for (int num : nums) {
      pq.offer(num);
    }

    int res = nums[0];
    // 取k次, 例如: 取1次是第1大的, 取2次是第2大的
    for (int i = 0; i < k; i++) {
      res = pq.poll();
    }

    return res;
  }

}
