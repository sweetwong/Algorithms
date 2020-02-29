package leet_code;

class Item45_跳跃游戏II_贪心法 {

  /**
   * 注意, 此贪心法不是贪的nums[i]就是不是要求每次能跳最远的
   * 而是贪的nums[i] + i, 既跳完之后再跳是最远的
   */
  public int jump(int[] nums) {
    int end = 0;
    int maxPosition = 0;
    int count = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      //找能跳的最远的
      maxPosition = Math.max(maxPosition, nums[i] + i);
      //遇到边界，就更新边界，并且步数加一
      if (i == end) {
        end = maxPosition;
        count++;
      }

      System.out.println("maxPosition = " + maxPosition + ", end = " + end + ", count = " + count);
    }
    return count;
  }

  public static void main(String[] args) {
    Item45_跳跃游戏II_贪心法 a = new Item45_跳跃游戏II_贪心法();
    System.out.println(a.jump(new int[]{2, 3, 1, 1, 4}));
  }

}
