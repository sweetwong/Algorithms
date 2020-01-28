package leet_code;

import java.util.Arrays;

class Item66_加一 {

  public static void main(String[] args) {
    int[] digits = {9, 9, 9};
    digits = plusOne(digits);
    System.out.println(Arrays.toString(digits));
  }

  public static int[] plusOne(int[] digits) {
    int n = digits.length;

    boolean allNight = true;
    for (int digit : digits) {
      if (digit != 9) {
        allNight = false;
        break;
      }
    }

    if (allNight) {
      digits = new int[n + 1];
      digits[0] = 1;
      return digits;
    }

    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] == 9) {
        digits[i] = 0;
      } else {
        digits[i] += 1;
        return digits;
      }
    }

    return digits;
  }

}
