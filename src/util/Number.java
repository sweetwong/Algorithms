package util;

public class Number {

  public static void main(String[] args) {
    // 1100
    int a = -64;
    print32BitBinaryString(a);
    System.out.println();
    int b = a >>> 2;
    int c = a >> 2;
    print32BitBinaryString(b);
    System.out.println();
    print32BitBinaryString(c);
  }

  public static void print32BitBinaryString(int num) {
    System.out.println(num + "  ");
    StringBuilder sBuilder = new StringBuilder();
    for (int i = 0; i < 32; i++) {
      sBuilder.append(num & 1);
      num = num >>> 1;
    }
    System.out.println(sBuilder.reverse().toString());
    System.out.println();
  }

}
