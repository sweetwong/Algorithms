package leet_code;

class Item1013_将数组分成和相等的三个部分 {

  public boolean canThreePartsEqualSum(int[] nums) {
    int n = nums.length;
    int sum = 0;

    for (int num : nums) sum += num;

    if (sum % 3 != 0) return false;

    int partSum = sum / 3;

    int count = 0;
    int currSum = 0;
    for (int num : nums) {
      currSum += num;
      if (currSum == partSum) {
        currSum = 0;
        count++;
      }
    }

    return currSum == 0 && (count == 3 || (partSum == 0 && count >= 3));
  }

}
