package leet_code;

class Item292_Nim游戏_自底向上 {

  public boolean canWinNim(int n) {
    if (n <= 3) return true;

    boolean[] dp = new boolean[n + 1];

    for (int i = 1; i <= 3; i++) {
      dp[i] = true;
    }

    for (int i = 4; i < n + 1; i++) {
      dp[i] = !dp[i - 1] || !dp[i - 2] || !dp[i - 3];
    }

    return dp[n];
  }

}
