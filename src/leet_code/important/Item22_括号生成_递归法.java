package leet_code.important;

import java.util.ArrayList;
import java.util.List;

class Item22_括号生成_递归法 {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(res, "", n, n);
        return res;
    }

    public static void backtracking(List<String> res, String s, int open, int close) {
        if (open + close == 0) {
            res.add(s);
            return;
        }

        if (open > 0)
            backtracking(res, s + "(", open - 1, close);

        if (open < close)
            backtracking(res, s + ")", open, close - 1);
    }

}
