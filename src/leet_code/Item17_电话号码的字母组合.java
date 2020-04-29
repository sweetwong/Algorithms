package leet_code;

import java.util.ArrayList;
import java.util.List;

class Item17_电话号码的字母组合 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        String[] phone = {
                "", "", "abc", "def",
                "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"
        };
        backtrack(digits, phone, res, "", 0);
        return res;
    }

    public void backtrack(String digits, String[] phone, List<String> res, String prev, int start) {
        if (start == digits.length()) {
            res.add(prev);
            return;
        }
        char[] letters = phone[digits.charAt(start) - '0'].toCharArray();
        for (char letter : letters) {
            backtrack(digits, phone, res, prev + letter, start + 1);
        }
    }

    public static void main(String[] args) {
        Item17_电话号码的字母组合 a = new Item17_电话号码的字母组合();
        List<String> strings = a.letterCombinations("2654");
        System.out.println(strings);
    }

}
