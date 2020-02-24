package classical;

/**
 * 打印等腰三角形
 */
class PrintIsosceles {

  public static void printStar(int n) {
    // 控制行数
    for (int i = 1; i <= n; i++) {
      // 控制空格的个数
      for (int k = 1; k <= n - i; k++) {
        System.out.print(" ");
      }
      // 控制打印的图形
      for (int j = 1; j <= 2 * i - 1; j++) {
        System.out.print("*");
      }
      // 控制换行
      System.out.println();
    }
  }

  public static void main(String[] args) {
    printStar(10);
  }

}
