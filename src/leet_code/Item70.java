package leet_code;

/**
 * 爬楼梯问题, 参考classical
 */
class Item70 {

  public static int climbStairs(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    return climbStairs(n - 1) + climbStairs(n - 2);
  }
}
