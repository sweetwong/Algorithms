package leet_code;

import util.other.NumberUtils;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 */
class Item136 {

  public static void main(String[] args) {
    NumberUtils.printBinary(5 ^ 12 ^ 13 ^ 12 ^ 13);
  }

  /**
   * 方法一: 利用异或, 一个数异或两次会等于它原来的数, 异或操作还满足交换律
   */
  public static int singleNumberXOR(int[] nums) {
    int res = nums[0];
    if (nums.length > 1) {
      for (int i = 1; i < nums.length; i++) {
        res = res ^ nums[i];
      }
    }
    return res;
  }


}

