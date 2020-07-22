package leet_code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Item93_复原IP地址_答案 {

    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        // 如果长度不够，不搜索
        if (n < 4 || n > 12) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        int splitTimes = 0;
        backtrack(s, n, 0, path, res);
        return res;
    }

    private void backtrack(String s, int n, int begin, Deque<String> path, List<String> res) {
        int split = path.size();
        if (begin == n) {
            if (split == 4) {
                res.add(String.join(".", path));
            }
            return;
        }

        // 看到剩下的不够了，就退出（剪枝），n - begin 表示剩余的还未分割的字符串的位数
        if (n - begin < (4 - split) || n - begin > 3 * (4 - split)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (begin + i >= n) {
                break;
            }

            int ipSegment = judgeIfIpSegment(s, begin, begin + i);
            if (ipSegment != -1) {
                // 在判断是 ip 段的情况下，才去做截取
                path.addLast(ipSegment + "");
                backtrack(s, n, begin + i + 1, path, res);
                path.removeLast();
            }
        }
    }

    /**
     * 判断 s 的子区间 [left, right] 是否能够成为一个 ip 段
     * 判断的同时顺便把类型转了
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;

        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }

        // 转成 int 类型
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        if (res > 255) {
            return -1;
        }
        return res;
    }


}
