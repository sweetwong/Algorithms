package leet_code;

import java.util.Stack;

public class Item20 {

  public boolean isValid(String s) {
    char[] chars = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (char c : chars) {
      // c是正括号
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      }
      // c是反括号
      else {
        if (stack.isEmpty()) return false;
        // 查看栈顶, 如果是一对就一起消掉, 如果不是就返回否
        char peek = stack.pop();
        if ((c == ')' && peek != '(')
          || (c == ']' && peek != '[')
          || (c == '}' && peek != '{'))
          return false;
      }
    }
    return stack.isEmpty();
  }

}
