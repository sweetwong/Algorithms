package classic;

/*
 * 斐波那契数列:
 *
 *           n : 1、2、3、4、5、6、7、 8、 9
 * fibonacci(n): 1、1、2、3、5、8、13、21、34
 *
 */
public class Fibonacci {

  public static int fibonacci(int n) {
    if (n <= 2) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }


  public static void main(String[] args) {
    System.out.println(fibonacci(9));
  }

}
