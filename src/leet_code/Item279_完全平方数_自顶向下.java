package leet_code;

class Item279_完全平方数_自顶向下 {

  public int numSquares(int n) {
    return numSquares(n, new int[n + 1]);
  }

  public int numSquares(int n, int[] dp) {
    if (n == 0) return 0;

    if (dp[n] == 0) {
      dp[n] = n;
      for (int i = 1; i * i <= n; i++) {
        dp[n] = Math.min(dp[n], numSquares(n - (i * i), dp) + 1);
      }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    Item279_完全平方数_自顶向下 a = new Item279_完全平方数_自顶向下();
    System.out.println(a.numSquares(12));

  }

}
