package leet_code;

class Item238_除自身以外数组的乘积 {

  public int[] productExceptSelf(int[] nums) {
    int allProduct = 1;

    for (int num : nums) {
      allProduct *= num;
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = allProduct / nums[i];
    }

    return nums;
  }

}
