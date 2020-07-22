package leet_code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * TODO 重新完成这道题
 */
public class Item93_复原IP地址 {

    public static List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n < 4 || n > 12) {
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        backtrack(s, res, new int[]{1, 1, 1});
        return new ArrayList<>(res);
    }

    private static void backtrack(String s, Set<String> set, int[] cuts) {
        int total = 0;
        for (int cut : cuts) {
            total += cut;
            if (cut > 4) {
                return;
            }
        }
        if (total > s.length()) {
            return;
        }

        String part1 = s.substring(0, cuts[0]);
        String part2 = s.substring(cuts[0], cuts[0] + cuts[1]);
        String part3 = s.substring(cuts[0] + cuts[1], cuts[0] + cuts[1] + cuts[2]);
        String part4 = s.substring(cuts[0] + cuts[1] + cuts[2], s.length());

        if (isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)) {
            set.add(part1 + "." + part2 + "." + part3 + "." + part4);
        }

        for (int i = 0; i < 3; i++) {
            cuts[i]++;
            backtrack(s, set, cuts);
            cuts[i]--;
        }
    }

    private static boolean isValid(String s) {
        if (s.isEmpty() || (s.length() > 1 && s.charAt(0) == '0')) return false;
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("0279245587303"));;
    }

}
