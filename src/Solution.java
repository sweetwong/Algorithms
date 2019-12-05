import java.util.HashMap;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {
    System.out.println(isValid("([)]"));
  }

  public static boolean isValid(String s) {
    char[] chars = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();

    for (char c : chars) {
      System.out.println(c);
      if (c == '(' || c == '[' || c == '{') {
        Integer prev = map.get(c);
        if (prev == null) prev = 0;
        map.put(c, prev + 1);
        continue;
      }
      Integer prev;
      if (c == ')') {
        prev = map.get('(');
        map.put('(', prev - 1);
        if (prev == null || prev <= 0) return false;
      } else if (c == ']') {
        prev = map.get('[');
        if (prev == null || prev <= 0) return false;
        map.put('[', prev - 1);
      } else if (c == '}') {
        prev = map.get('{');
        if (prev == null || prev <= 0) return false;
        map.put('{', prev - 1);
      }
    }

    for (Integer value : map.values()) {
      System.out.println(value);
      if (value < 0) return false;
    }

    return true;
  }


}