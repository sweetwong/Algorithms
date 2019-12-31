package classic;

import util.Time;

/**
 * 爬楼梯问题, 每次可以爬1层, 也可以爬2层
 * 问跳到n层一共有多少种方式?
 *
 * f(n) = f(n-1) + f(n-2)
 *
 * 第一次可以跳一层, 也可以跳两层, 大问题 -> 小问题
 *
 * 递归思想: 是把f(n)化成f(n-1)和f(n-2)
 * 迭代思想: 已知f(1)和f(2), 求f(3), f(4), ..., f(n)
 */
class ClimbStairs {

  public static void main(String[] args) {
    Time.watch(() -> climbStairsDpIte(1000000));
  }

  /**
   * 方法一: 爬楼梯问题, 最简单的解法, 不过非常慢, 因为子问题重复计算, 效率极差
   */
  public static int climbStairs(int n) {
    if (n <= 2) return n;
    return climbStairs(n - 1) + climbStairs(n - 2);
  }

  /**
   * 方法二: 动态规划 + 递归, 在第一种解法的基础上加入了dp用来缓存
   */
  public static int climbStairsDp(int n) {
    int[] dp = new int[n + 1];
    return climbStairsDpHelper(n, dp);
  }


  /**
   * 方法二的辅助方法, 在方法一的基础上加入了一个缓存
   */
  public static int climbStairsDpHelper(int n, int[] dp) {
    if (n <= 2) return n;

    int cache = dp[n];
    if (cache != 0) {
      return cache;
    } else {
      int value = climbStairsDpHelper(n - 1, dp) + climbStairsDpHelper(n - 2, dp);
      dp[n] = value;
      return value;
    }
  }

  /**
   * 方法三: 动态规划 + 迭代
   */
  public static int climbStairsDpIte(int n) {
    if (n <= 2) return n;

    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i < n + 1; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }


}
