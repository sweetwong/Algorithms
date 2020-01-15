package classical;

/**
 * 汉诺塔问题
 *
 * 相传在古印度圣庙中，有一种被称为汉诺塔(Hanoi)的游戏。该游戏是在一块铜板装置上，有三根杆(编号A、B、C)，
 * 在A杆自下而上、由大到小按顺序放置64个金盘(如下图)。游戏的目标：把A杆上的金盘全部移到C杆上，并仍保持原有顺序叠好。
 * 操作规则：每次只能移动一个盘子，并且在移动过程中三根杆上都始终保持大盘在下，小盘在上，操作过程中盘子可以置于A、B、C任一杆上。
 *
 * f(n) = 2^n - 1
 * n盘子数, f(n)需要移动的次数
 */
class TowerOfHanoi {

  private static int count = 0;

  public static void main(String[] args) {
    hanoi("A", "B", "C", 3);
    System.out.println("一共搬运了" + count + "次");
  }

  public static void hanoi(String from, String temp, String to, int n) {
    // 终止条件, 也是真正搬运的步骤
    if (n == 1) {
      count++;
      System.out.println(from + " -> " + to);
      return;
    }

    // 大问题化成小问题, 问题规模从n减小到n-1, 直到n=1终止递归

    hanoi(from, to, temp, n - 1);
    hanoi(from, temp, to, 1);
    hanoi(temp, from, to, n - 1);
  }
}
