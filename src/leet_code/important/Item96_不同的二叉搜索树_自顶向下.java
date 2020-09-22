package leet_code.important;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Item96_不同的二叉搜索树_自顶向下 {

    public static int numTrees(int n) {
        return numTrees(n, new Integer[n + 1]);
    }

    private static int numTrees(int n, Integer[] dp) {
        if (n <= 1) return 1;

        if (dp[n] != null) {
            return dp[n];
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += numTrees(i - 1, dp) * numTrees(n - i, dp);
        }

        dp[n] = res;

        return res;
    }

}
