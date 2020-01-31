package leet_code;

import java.util.HashMap;
import java.util.Map;

class Item169_多数元素 {

  public static void main(String[] args) {
    Item169_多数元素 a = new Item169_多数元素();
    System.out.println(a.majorityElement(new int[]{2, 2, 1, 1, 1, 1, 1, 2, 2}));
  }

  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    Map.Entry<Integer, Integer> maxEntry = null;
    int maxCount = 0;

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() >= maxCount) {
        maxEntry = entry;
        maxCount = entry.getValue();
      }
    }

    return maxEntry.getKey();
  }

}
