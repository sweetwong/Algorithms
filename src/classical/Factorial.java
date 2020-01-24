package classical;

/**
 * 求n的阶乘, n是非负数
 * 注意0的阶乘是1
 */
public class Factorial {

  public static int factorial(int n) {
    if (n <= 1) return 1;
    // 此处大问题只分解成一个子问题, 所以不存在最优子结构的问题, 所以不需要动态规划和记忆化递归
    return n * factorial(n - 1);
  }

  public static int factorialIte(int n) {
    int res = 1;
    for (int i = 2; i <= n; i++) {
      res *= i;
    }
    return res;
  }

}
