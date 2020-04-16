package classical;

/**
 * 爬楼梯问题, 每次可以爬1层, 也可以爬2层
 * 问跳到n层一共有多少种方式?
 *
 * f(n) = f(n-1) + f(n-2)
 *
 * 第一次可以跳一层, 也可以跳两层, 大问题 -> 小问题
 *
 * 递归思想: 是把f(n)化成f(n-1)和f(n-2)
 * 迭代思想: 已知f(1)和f(2), 求f(3), f(4), ..., f(n)
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairsFibonacci(10));
    }

    /**
     * 方法一: 爬楼梯问题, 暴力法, 非常慢, 因为子问题重复计算, 效率极差
     * 时间复杂度: O(2^n), 遍历一次
     * 空间复杂度: O(n), 递归深度可达到n
     */
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 方法二: 动态规划, 在第一种解法的基础上加入了备忘录来记录缓存, 又称记忆化递归
     * 时间复杂度: O(n), 树形递归大小可达到n
     * 空间复杂度: O(n), 递归深度可达到n
     *
     * 自顶向下(通过递归), 在递归的基础上加上了备忘录
     */
    public static int climbStairsDp(int n) {
        // 此长度处用n+1是因为, 存储时, 是从dp[1]开始存的, 因此dp[n]需要长度n+1的数组
        int[] dp = new int[n + 1];
        return climbStairsDp(n, dp);
    }

    /**
     * 方法二的辅助方法, 自顶向下
     */
    private static int climbStairsDp(int n, int[] dp) {
        // 终止条件
        if (n <= 2) return n;

        // 通过判断非0为没有存储, 如果所有的数都有可能出现, 可以改用Integer[], 然后通过是否为空来判断是否有记录, boolean等其他的同理
        if (dp[n] != 0)
            // 此处找到缓存就直接返回了, 没有再继续分化成子问题, 因此每个子问题只计算了一遍
            return dp[n];

        int res = climbStairsDp(n - 1, dp) + climbStairsDp(n - 2, dp);

        dp[n] = res;
        return res;
    }

    /**
     * 方法三: 动态规划
     * 时间复杂度: O(n), 遍历一次
     * 空间复杂度: O(n), 创造了一个dp存储
     *
     * 自底向上(通过迭代), 由简单解推算出复杂解
     */
    public static int climbStairsDpIte(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    /**
     * 方法四: 斐波那契数列
     * 时间复杂度: O(n), 遍历一次
     * 空间复杂度: O(1), 只用了常数量的额外变量, first和second
     *
     * 在方法三的基础上优化, 其实并不需要保存所有的数, 只要求出想要的第n个即可
     */
    public static int climbStairsFibonacci(int n) {
        if (n == 2) return n;

        int first = 1, second = 2;
        for (int i = 3; i < n + 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }


}
