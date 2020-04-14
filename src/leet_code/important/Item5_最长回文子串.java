package leet_code.important;

/**
 * 最长回文子字符串
 */
class Item5_最长回文子串 {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        // 由于要返回的是字符串, 所以记录了起始点和终点
        // 如果只用返回长度, 记录最大的长度会更高
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (len > end - start + 1) {
                // 对于偶数长度的start, 因为i是中间偏左, 左右起始点必须这么求
                start = i - (len - 1) / 2;
                // 对于奇数长度的end, (len - 1) / 2和 len / 2的值是一样的, 因此根据偶数的要求决定
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // 关键, 此处返回的是长度len, 通过长度len求出左起始点和又起始点
    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 最后还会执行多一次l--,r++, 所以return r-l-1而不是return r-l+1
        return right - left - 1;
    }
}
