package leet_code;

class Item62_不同路径_动态规划_自顶向下_important {

  public static void main(String[] args) {
    System.out.println(uniquePaths(12, 23));
  }

  public static int uniquePaths(int m, int n) {
    int[][] memo = new int[Math.max(m, n) + 1][Math.min(m, n) + 1];
    return dp(memo, m, n);
  }

  public static int dp(int[][] memo, int m, int n) {
    if (m == 1 || n == 1) return 1;

    int max = Math.max(m, n);
    int min = Math.min(m, n);

    if (memo[max][min] != 0) {
      return memo[max][min];
    }

    int res = dp(memo, m - 1, n) + dp(memo, n - 1, m);
    memo[max][min] = res;

    return res;
  }

}
