package leet_code;

/**
 * 在普通递归的基础上, 添加了记忆表
 */
class Item10_正则表达式匹配_动态规划_自顶向下 {

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        isMatch(s, p);
    }

    public static boolean isMatch(String s, String p) {
        return isMatch(s, p, new Boolean[s.length() + 1][p.length() + 1]);
    }

    public static boolean isMatch(String s, String p, Boolean[][] memo) {
        int lenS = s.length();
        int lenP = p.length();

        // 当p的长度为0, 递归的终止条件
        if (lenP == 0) return lenS == 0;

        // 判断第一个字符是否匹配
        boolean firstMatch = (lenS != 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        // 当p的长度为1, 这种情况不存在'*'问题
        if (lenP == 1) {
            return s.length() == 1 && firstMatch;
        }

        // p的长度为0和1都被拦截了, 下面的都是p长度大于1的情况

        if (memo[lenS][lenP] != null) {
            return memo[lenS][lenP];
        }

        boolean result;

        // 当p的长度大于1, 且第二字符为'*'
        if (p.charAt(1) == '*') {
            // 当第一个字符匹配, 大问题可以分为两种子问题, s进1 或者 p进2
            if (firstMatch) {
                result = isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            }
            // 当第一个字符不匹配, 减小问题范围, 只能 p进2(忽略掉'*'和其前一个字符)
            else {
                result = isMatch(s, p.substring(2));
            }
        }
        // 当p的长度大于1, 且第二个字符不为'*', 问题规模缩小1
        else {
            result = firstMatch && isMatch(s.substring(1), p.substring(1));
        }

        memo[lenS][lenP] = result;

        return result;

    }


}