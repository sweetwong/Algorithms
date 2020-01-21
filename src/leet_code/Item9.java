package leet_code;

class Item9 {

  public boolean isPalindrome(int num) {
    if (num < 0) return false;
    if (num == 0) return true;

    // 这种情况是为了防止, rev不增大, 导致当停止递归时, 不是在数的中间
    // 例如: 1100会返回true
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
