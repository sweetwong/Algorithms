package leet_code;

import java.util.ArrayList;
import java.util.List;

class Item6_Z字形变换 {

  public String convert(String s, int numRows) {
    if (s.length() <= numRows || numRows <= 1) return s;

    List<StringBuilder> rows = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      rows.add(new StringBuilder());
    }

    boolean down = true;
    int j = 0;

    for (int i = 0; i < s.length(); i++) {
      rows.get(j).append(s.charAt(i));
      if (j == 0 && !down) down = true;
      if (j == numRows - 1 && down) down = false;

      if (down) j++;
      if (!down) j--;
    }

    StringBuilder res = new StringBuilder();
    for (StringBuilder sb : rows) {
      res.append(sb);
    }
    return res.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Item6_Z字形变换().convert("AB", 1));
  }

}
