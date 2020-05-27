package leet_code.important;

import java.util.ArrayList;
import java.util.List;

class Item22_括号生成_DFS {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n);
        return res;
    }

    public static void dfs(List<String> res, String s, int open, int close) {
        if (open + close == 0) {
            res.add(s);
            return;
        }

        if (open > 0)
            dfs(res, s + "(", open - 1, close);

        if (open < close)
            dfs(res, s + ")", open, close - 1);
    }

}
