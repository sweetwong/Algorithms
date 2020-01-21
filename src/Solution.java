class Solution {

  public static void main(String[] args) {
    System.out.println(isPalindrome(1100));
  }

  public static boolean isPalindrome(int num) {
    if (num < 0) return false;
    if (num == 0) return true;
    if (num % 10 == 0) return false;

    int rev = 0;
    while (num > rev) {
      int pop = num % 10;
      num = num / 10;
      rev = rev * 10 + pop;
    }

    return num == rev || num == rev / 10;
  }

  public static int reverse(int num) {
    int rev = 0;
    while (num != 0) {
      int pop = num % 10;
      num = num / 10;

      if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) return 0;
      if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) return 0;

      rev = rev * 10 + pop;

      System.out.println("num = " + num + ", rev = " + rev);
    }
    return rev;
  }

}