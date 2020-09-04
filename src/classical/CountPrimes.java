package classical;

import data_structure.other.Time;

import java.util.Arrays;

/**
 * 计数质数
 *
 * 计算n以内的有多少个质数(素数)
 * 质数是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数。
 * 厄拉多塞筛选法
 */
public class CountPrimes {

    public static int countPrimes(int n) {
        // 因为题目要求的是, 求小于n的所有质数, 因此此处不包括n, 最大的索引为 n - 1
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // 考虑到质数的定义, 从2开始
        // 12 = 2 × 6
        // 12 = 3 × 4
        // 12 = sqrt(12) × sqrt(12)
        // 12 = 4 × 3
        // 12 = 6 × 2
        // 可以看到, 假设n为12, 在sqrt(12)之后的数都是重复的, 就只是左右调换位置
        // 所以如果到12为止, 还没有发现两个相乘的数等于n, 那么n为质数
        // 因为题目要求的是, 求小于n的所有质数, 因此此处不包括n
        for (int i = 2; i * i < n; i++) {
            // 如果i不是质数, 那就不用计算了
            // 比如 i == 4, 那其实当 i == 2 时已经计算过了
            if (isPrime[i]) {
                // 因为题目要求的是, 求小于n的所有质数, 因此此处不包括n
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            // 因为题目要求的是, 求小于n的所有质数, 因此此处不包括n
            if (isPrime[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Time.watch(() -> System.out.println(countPrimes(100000000)));
    }


}
