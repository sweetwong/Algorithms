package leet_code;

class Item9_回文数 {

  public boolean isPalindrome(int num) {
    if (num < 0) return false;
    if (num == 0) return true;
    // 因为 0 * 10 = 0, 导致不是在中间停止
    if (num % 10 == 0) return false;

    int rev = 0;
    while (num > rev) {
      int pop = num % 10;
      num = num / 10;
      rev = rev * 10 + pop;
    }

    return num == rev || num == rev / 10;
  }

}
