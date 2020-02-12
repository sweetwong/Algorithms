package leet_code;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 */
class Item58_最后一个单词的长度 {

  public static void main(String[] args) {
    System.out.println(lengthOfLastWord("Hello World"));
  }

  public static int lengthOfLastWord(String s) {
    int len = s.length();
    char[] chars = s.toCharArray();
    int i = len - 1;

    int count = 0;

    while (i >= 0 && chars[i] == ' ') {
      i--;
    }

    while (i >= 0 && chars[i] != ' ') {
      count++;
      i--;
    }

    return count;
  }

}
