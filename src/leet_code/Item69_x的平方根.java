package leet_code;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * TODO 理解这道题
 */
public class Item69_x的平方根 {

    public static int mySqrt(int x) {
        if (x == 0) return 0;

        int lo = 1, hi = x / 2;
        int ans = 1;

        while (lo <= hi) {
            int mid = lo + hi >>> 1;
            long midVal = (long) mid * (long) mid;
            if (midVal <= x) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(37));
    }

}
