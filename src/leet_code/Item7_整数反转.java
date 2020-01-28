package leet_code;

class Item7_整数反转 {

  public int reverse(int x) {
    int res = 0;
    while (x != 0) {
      int pop = x % 10;
      x = x / 10;
      // 如果res > Integer.MAX_VALUE / 10
      // 那么res * 10 > Integer.MAX.VALUE
      if (res > Integer.MAX_VALUE / 10 ||
        res == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)
        return 0;
      if (res < Integer.MIN_VALUE / 10 ||
        res == Integer.MIN_VALUE / 10 && pop < Integer.MAX_VALUE % 10)
        return 0;
      // 这一步会导致溢出,要在溢出之前检查,因为溢出之后就不是原来的值了
      res = res * 10 + pop;
    }
    return res;
  }



}
