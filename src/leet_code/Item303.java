package leet_code;

import java.util.HashMap;
import java.util.Map;

class Item303 {

  private int[] nums;

  /**
   * 此处用String当Key
   * 也可以用Pair<Integer,Integer>当Key
   */
  private Map<String, Integer> map = new HashMap<>();

  public Item303(int[] nums) {
    this.nums = nums;
  }

  public int sumRange(int low, int high) {
    String key = low + "+" + high;
    if (map.containsKey(key)) {
      return map.get(key);
    } else {
      int sum = 0;
      for (int i = low; i <= high; i++) {
        sum += nums[i];
      }
      map.put(key, sum);
      return sum;
    }
  }

}
