package classic;

/*
 * 斐波那契数列:
 *
 *           n : 1、2、3、4、5、6、7、 8、 9
 * fibonacci(n): 1、1、2、3、5、8、13、21、34
 *
 * 此题参考爬楼梯问题, 是同一个问题, 唯一不同点是:
 *
 * 斐波那契数列: f(1) = 1, f(2) = 1, f(3) = 2
 *   爬楼梯问题: f(1) = 1, f(2) = 2, f(3) = 3
 */
public class Fibonacci {

  /**
   * 暴力法, 非常慢, 因为子问题重复计算, 效率极差, 其他方法参考爬楼梯问题ClimbStairs
   */
  public static int fibonacci(int n) {
    if (n <= 2) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }


}
