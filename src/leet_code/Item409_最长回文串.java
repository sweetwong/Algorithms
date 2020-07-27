package leet_code;

class Item409_最长回文串 {

    /**
     * 记住: ASCII中, 英文字母, 'z'在最后, 'A'在最前
     */
    public static int longestPalindrome(String s) {
        int count = 0;
        int[] freq = new int['z' - 'A' + 1];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            // 采用两两抵消的方法
            if (++freq[c - 'A'] == 2) {
                freq[c - 'A'] = 0;
                count += 2;
            }
        }
        for (int f : freq) {
            if (f > 0) {
                count++;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

}
