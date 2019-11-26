package classic;

/**
 * 跳楼梯问题, 每次可以跳1层, 也可以跳2层
 * 问跳到n层一共有多少种方式?
 */
class JumpStairs {

  public static int jumpStairs(int n) {
    if (n <= 2) return n;
    return jumpStairs(n - 1) + jumpStairs(n - 2);
  }

  public static void main(String[] args) {
    System.out.println(jumpStairs(4));
  }

}
