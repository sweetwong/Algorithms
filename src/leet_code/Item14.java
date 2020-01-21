package leet_code;

class Item14 {

  public static void main(String[] args) {
    String[] strs = new String[]{"aca", "cba"};
    String result = longestCommonPrefix(strs);

    if (result.equals("")) result = "null";
    System.out.println(result);
  }

  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    StringBuilder res = new StringBuilder();
    int i = 0;
    boolean next = true;

    while (next) {
      if (i < strs[0].length()) {
        // 把数组中第一个字符串的第i个值赋给curr
        char curr = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j++) {
          if (i < strs[j].length()) {
            // 分别拿后面的值与curr比较,如果都相同,则继续,如果不相同,终止
            if (strs[j].charAt(i) != curr) {
              next = false;
              break;
            }
          } else {
            next = false;
            break;
          }
        }
        if (next) {
          res.append(curr);
          i++;
        }
      } else {
        break;
      }
    }
    return res.toString();
  }
}
