package classical;

/*
 * 斐波那契数列:
 *
 *           n : 1、2、3、4、5、6、7、 8、 9
 * fibonacci(n): 1、1、2、3、5、8、13、21、34
 *
 * 此题参考爬楼梯问题, 是同一个问题, 唯一不同点是:
 *
 * 斐波那契数列: f(1) = 1, f(2) = 1, f(3) = 2
 *   爬楼梯问题: f(1) = 1, f(2) = 2, f(3) = 3
 */
public class Fibonacci {

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            System.out.println(fibonacci(i));
        }
    }

    public static int fibonacci(int n) {
        if (n <= 2) return 1;

        int p = 1, q = 1;
        for (int i = 3; i <= n; i++) {
            int sum = p + q;
            p = q;
            q = sum;
        }

        return q;
    }


}
