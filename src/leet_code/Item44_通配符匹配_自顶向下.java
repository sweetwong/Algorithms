package leet_code;

class Item44_通配符匹配_自顶向下 {

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, new Boolean[s.length() + 1][p.length() + 1]);
    }

    public boolean isMatch(String s, String p, Boolean[][] dp) {
        int lenS = s.length();
        int lenP = p.length();

        // 拦截p为空
        if (lenP == 0) return lenS == 0;

        if (dp[lenS][lenP] != null) return dp[lenS][lenP];

        char firstP = p.charAt(0);

        boolean res;

        // 第一个p是*
        if (firstP == '*') {
            if (lenS == 0) res = lenP == 1 || isMatch(s, p.substring(1), dp);
            else res = isMatch(s.substring(1), p, dp) || isMatch(s, p.substring(1), dp);
        }
        // 第一个p是?
        else if (firstP == '?') {
            res = lenS != 0 && isMatch(s.substring(1), p.substring(1), dp);
        }
        // 第一个p是正常字符
        else {
            res = lenS != 0 && firstP == s.charAt(0) && isMatch(s.substring(1), p.substring(1), dp);
        }

        dp[lenS][lenP] = res;

        return res;
    }


}
