package leet_code;

import util.Time;

class Item70 {

  public static void main(String[] args) {
    Time.watch(() -> System.out.println(climbStairs(45)));
  }

  public static int climbStairs(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    return climbStairs(n - 1) + climbStairs(n - 2);
  }
}
