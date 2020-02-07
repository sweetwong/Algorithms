package classical;

/**
 * 计算n以内的有多少个素数
 */
class CountPrimes {

  public int countPrimes(int n) {
    // 默认不是质数(既合数)
    boolean[] isNotPrime = new boolean[n];

    // 遍历范围[2, 根号n]
    for (int i = 2; i * i <= n; i++) {
      if (isNotPrime[i]) {
        // 剔除i的倍数
        for (int j = i * i; j < n; j += i) {
          isNotPrime[j] = true;
        }
      }
    }

    int count = 0;
    for (int i = 2; i < n; i++) {
      if (!isNotPrime[i]) count++;
    }

    return count;
  }

}
