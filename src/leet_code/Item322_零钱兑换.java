package leet_code;

class Item322_零钱兑换 {

  public int coinChange(int[] coins, int amount) {
    return coinChange(coins, amount, new int[amount + 1]);
  }

  public int coinChange(int[] coins, int amount, int[] count) {
    if (amount < 0) return -1;
    if (amount == 0) return 0;

    if (count[amount] != 0) return count[amount];

    int minCount = -1;
    for (int coin : coins) {
      int lastCount = coinChange(coins, amount - coin, count);
      if (lastCount == -1) continue;

      if (minCount == -1) minCount = lastCount + 1;
      else minCount = Math.min(minCount, lastCount + 1);
    }

    count[amount] = minCount;

    return minCount;
  }

}
