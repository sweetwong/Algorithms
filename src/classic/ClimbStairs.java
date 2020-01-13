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
    Time.watch(() -> climbStairsDp(100));
  }

  /**
   * 方法一: 爬楼梯问题, 暴力法, 非常慢, 因为子问题重复计算, 效率极差
   */
  public static int climbStairs(int n) {
    if (n <= 2) return n;
    return climbStairs(n - 1) + climbStairs(n - 2);
  }

  /**
   * 方法二: 动态规划, 在第一种解法的基础上加入了备忘录来记录缓存, 又称记忆化递归
   *
   * 自顶向下(通过递归), 在递归的基础上加上了备忘录
   */
  public static int climbStairsDp(int n) {
    // 此长度处用n+1是因为, 存储时, 是从dp[1]开始存的, 因此dp[n]需要长度n+1的数组
    int[] dp = new int[n + 1];
    return helper(n, dp);
  }

  /**
   * 方法二的辅助方法, 自顶向下
   */
  public static int helper(int n, int[] dp) {
    // 通过判断非0为没有存储, 如果所有的数都有可能出现, 可以改用Integer[], 然后通过是否为空来判断是否有记录, boolean等其他的同理
    if (dp[n] != 0)
      // 此处找到缓存就直接返回了, 没有再继续分化成子问题, 因此每个子问题只计算了一遍
      return dp[n];

    int res;

    // 原递归函数
    if (n <= 2) res = n;
    else res = helper(n - 1, dp) + helper(n - 2, dp);

    dp[n] = res;
    return res;
  }

  /**
   * 方法三: 动态规划
   *
   * 自底向上(通过迭代), 由简单解推算出复杂解
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
