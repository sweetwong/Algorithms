package leet_code;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 */
class Item347_前K个高频元素 {

  public static List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> res = new ArrayList<>();

    // 用HashMap来记录每个数字出现的次数, 并可以利用Map的特性消掉重复Map
    Map<Integer, Integer> count = new HashMap<>();
    for (int num : nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }

    // 按照每个数字出现的次数构建有限队列
    PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(count.get(o2), count.get(o1)));
    for (int num : count.keySet()) {
      heap.offer(num);
    }

    // 拿到前k个
    for (int i = 0; i < k; i++) {
      res.add(heap.poll());
    }

    return res;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 1, 1, 2, 2, 3};
    List<Integer> res = topKFrequent(nums, 3);
    System.out.println(res.toString());
  }
}
