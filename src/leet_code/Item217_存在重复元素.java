package leet_code;

import java.util.HashSet;
import java.util.Set;

class Item217_存在重复元素 {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) return true;
      set.add(num);
    }
    return false;
  }

}
