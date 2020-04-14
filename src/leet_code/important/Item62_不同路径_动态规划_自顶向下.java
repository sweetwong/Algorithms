package leet_code.important;

class Item62_不同路径_动态规划_自顶向下 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(12, 23));
    }

    public static int uniquePaths(int m, int n) {
        return uniquePaths(new int[Math.max(m, n) + 1][Math.min(m, n) + 1], m, n);
    }

    public static int uniquePaths(int[][] memo, int m, int n) {
        if (m == 1 || n == 1) return 1;

        int max = Math.max(m, n);
        int min = Math.min(m, n);

        if (memo[max][min] != 0) {
            return memo[max][min];
        }

        // 大问题分成两个小问题
        int res = uniquePaths(memo, m - 1, n) + uniquePaths(memo, n - 1, m);
        memo[max][min] = res;

        return res;
    }

}
