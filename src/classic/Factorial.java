package classic;

/**
 * 求n的阶乘, n是非负数
 * 注意0的阶乘是1
 */
class Factorial {

  public static int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
  }

  public static int factorialTest(int n) {
    if (n <= 1) return 1;
    int lastFactorial = factorialTest(n - 1);
    int num = lastFactorial * n;
    System.out.println(lastFactorial + " × " + n + " = " + num);
    return num;
  }

  public static void main(String[] args) {
    factorialTest(10);
  }
}
