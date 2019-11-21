package leet_code;

class Item10 {

  public boolean isMatch(String text, String pattern) {
    // 判断是否为空
    if (pattern.isEmpty()) return text.isEmpty();

    // 判断第一个字符是否匹配
    boolean firstMatch = (!text.isEmpty() &&
      (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

    // 如果pattern的长度大于等于2且第二个为星
    if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
      return (isMatch(text, pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern)));
    }
    // 如果pattern的长度为1或者大于等于2但是第二不为星
    else {
      return firstMatch && isMatch(text.substring(1), pattern.substring(1));
    }
  }
}