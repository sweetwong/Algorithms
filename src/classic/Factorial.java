package classic;

import util.Array;
import util.Time;

/**
 * 求n的阶乘, n是非负数
 * 注意0的阶乘是1
 */
class Factorial {

  public static int factorial(int n) {
    if (n <= 1) return 1;
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
