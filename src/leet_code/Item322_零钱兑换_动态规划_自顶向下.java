package leet_code;

class Item322_零钱兑换_动态规划_自顶向下 {

  public int coinChange(int[] coins, int amount) {
    return coinChange(coins, amount, new int[amount + 1]);
  }

  public int coinChange(int[] coins, int amount, int[] memo) {
    if (amount < 0) return -1;
    if (amount == 0) return 0;

    if (memo[amount] != 0) return memo[amount];

    int minCount = -1;
    for (int coin : coins) {
      int lastCount = coinChange(coins, amount - coin, memo);
      if (lastCount == -1) continue;

      if (minCount == -1) minCount = lastCount + 1;
      else minCount = Math.min(minCount, lastCount + 1);
    }

    memo[amount] = minCount;

    return minCount;
  }

  public static void main(String[] args) {
    Item322_零钱兑换_动态规划_自顶向下 a = new Item322_零钱兑换_动态规划_自顶向下();
    System.out.println(a.coinChange(new int[]{2, 5, 10, 1}, 20));
  }

}
