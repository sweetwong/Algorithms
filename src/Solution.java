class Solution {

  public boolean isMatch(String text, String pattern) {
    Boolean[][] memo = new Boolean[text.length() + 1][pattern.length() + 1];
    return dp(0, 0, text, pattern, memo);
  }

  public boolean dp(int i, int j, String text, String pattern, Boolean[][] memo) {
    if (memo[i][j] != null) {
      return memo[i][j];
    }

    boolean res;
    if (j == pattern.length()) {
      res = i == text.length();
    } else {
      boolean first_match = (i < text.length() &&
        (pattern.charAt(j) == text.charAt(i) ||
          pattern.charAt(j) == '.'));

      if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
        res = (dp(i, j + 2, text, pattern, memo) ||
          first_match && dp(i + 1, j, text, pattern, memo));
      } else {
        res = first_match && dp(i + 1, j + 1, text, pattern, memo);
      }
    }
    memo[i][j] = res;
    return res;
  }
}