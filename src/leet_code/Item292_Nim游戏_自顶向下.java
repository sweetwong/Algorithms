package leet_code;

class Item292_Nim游戏_自顶向下 {

  public boolean canWinNim(int n) {
    Boolean[] memo = new Boolean[n + 1];
    return dp(memo, n);
  }

  public boolean dp(Boolean[] memo, int n) {
    if (n <= 3) return true;

    if (memo[n] != null) return memo[n];

    boolean canWin = !dp(memo, n - 1) || !dp(memo, n - 2) || !dp(memo, n - 3);

    memo[n] = canWin;

    return canWin;
  }

}
