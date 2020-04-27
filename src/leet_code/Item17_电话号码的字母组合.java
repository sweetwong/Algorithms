package leet_code;

import java.util.ArrayList;
import java.util.List;

class Item17_电话号码的字母组合 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        String[] dic = {
                "", "", "abc", "def",
                "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"
        };
        backtrack(digits, dic, res, digits.length(), "", 0);
        return res;
    }

    public void backtrack(String digits, String[] dic, List<String> res, int len, String prev, int start) {
        if (start == len) {
            res.add(prev);
            return;
        }
        char[] letters = dic[digits.charAt(start) - '0'].toCharArray();
        for (char letter: letters) {
            backtrack(digits, dic, res, len, prev + letter, start + 1);
        }
    }

    public static void main(String[] args) {
        Item17_电话号码的字母组合 a = new Item17_电话号码的字母组合();
        List<String> strings = a.letterCombinations("23");
        System.out.println(strings);
    }

}
