package LeetCode;

import java.util.ArrayList;
import java.util.List;

class Item9 {

  public static void main(String[] args) {
    int[] nums = new int[]{0, 1, 2, 3, 4};
    int n = nums.length;
    System.out.print(nums[n / 2]);
  }

  // x=1523
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    if (x <= 1) return true;
    List<Integer> list = new ArrayList<>();
    while (x != 0) {
      list.add(x % 10);
      x = x / 10;
    }
    int n = list.size();
    int l, r;
    if (n % 2 == 0) {
      l = (n - 1) / 2;
      r = (n - 1) / 2 + 1;
    } else {
      l = n / 2 - 1;
      r = n / 2 + 1;
    }
    while (r < n) {
      if (!list.get(l--).equals(list.get(r++))) return false;
    }
    return true;
  }

}
