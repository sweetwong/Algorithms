package util;

public class MyHeap {

  public static void printHeap(int[] arr) {
    int size = arr.length;
    int lineNum = 1;//首先遍历第一行
    int lines = (int) (Math.log(size) / Math.log(2)) + 1;//lines是堆的层数
    int spaceNum = (int) (Math.pow(2, lines) - 1);
    for (int i = 1; i <= size; ) { //因为在[1...size]左闭右闭区间存数据，data[0]不存数据

      //每层都是打印这个区间[2^(层数-1) ... (2^层数)-1]。如果堆里的数不够(2^层数)-1个，那就打印到size。所以取min((2^层数)-1,size).
      for (int j = (int) Math.pow(2, lineNum - 1); j <= Math.min(size, (int) Math.pow(2, lineNum) - 1); j++) {
        printSpace(spaceNum); //打印spaceNum个空格
        System.out.printf("%3s", arr[j - 1]);//打印数据
        System.out.printf("%3s", "");//图片中绿色方框
        printSpace(spaceNum);//打印spaceNum个空格
        i++;//每打印一个元素就 + 1
      }
      lineNum++;
      spaceNum = spaceNum / 2;
      System.out.println();
    }
  }

  public static void printSpace(int n) {//打印n个空格(在这里用‘\t’来代替)
    for (int i = 0; i < n; i++) {
      System.out.printf("%3s", "");
    }
  }

}