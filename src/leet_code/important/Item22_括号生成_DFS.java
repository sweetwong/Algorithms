package leet_code.important;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */

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
