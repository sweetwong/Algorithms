package leet_code;

class Item13_罗马数字转整数 {

  public static void main(String[] args) {
    System.out.println(romanToInt("MCMXCIV"));
  }

  // todo 用HashMap优化下, 这个看了想打人
  public static int romanToInt(String s) {
    int len = s.length();
    char[] chars = s.toCharArray();

    int sum = 0;

    int i = 0;
    while (i < len - 1) {
      char curr = chars[i];
      char next = chars[i + 1];

      switch (curr) {
        case 'I':
          if (next == 'V') {
            sum += 4;
            i += 2;
          } else if (next == 'X') {
            sum += 9;
            i += 2;
          } else {
            sum += 1;
            i++;
          }
          break;
        case 'V':
          sum += 5;
          i++;
          break;
        case 'X':
          if (next == 'L') {
            sum += 40;
            i += 2;
          } else if (next == 'C') {
            sum += 90;
            i += 2;
          } else {
            sum += 10;
            i++;
          }
          break;
        case 'L':
          sum += 50;
          i++;
          break;
        case 'C':
          if (next == 'D') {
            sum += 400;
            i += 2;
          } else if (next == 'M') {
            sum += 900;
            i += 2;
          } else {
            sum += 100;
            i++;
          }
          break;
        case 'D':
          sum += 500;
          i++;
          break;
        case 'M':
          sum += 1000;
          i++;
          break;
      }
    }
    if (i == len - 1) {
      switch (chars[i]) {
        case 'I':
          sum += 1;
          break;
        case 'V':
          sum += 5;
          break;
        case 'X':
          sum += 10;
          break;
        case 'L':
          sum += 50;
          break;
        case 'C':
          sum += 100;
          break;
        case 'D':
          sum += 500;
          break;
        case 'M':
          sum += 1000;
          break;
      }
    }

    return sum;
  }
}
