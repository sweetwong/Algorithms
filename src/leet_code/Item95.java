package leet_code;

import util.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Item95 {

  /*

    输入: 3
    输出:
      [
        [1,null,3,2],
        [3,2,null,1],
        [3,1,null,null,2],
        [2,1,3],
        [1,null,2,null,3]
      ]
    解释:
    以上的输出对应以下 5 种不同结构的二叉搜索树：

      1        3     3      2      1
      \       /     /      / \      \
       3     2     1      1   3      2
      /     /       \                 \
     2     1         2                 3

  */
  public static List<TreeNode> generateTrees(int n) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int[] arr = new int[n];
      for (int j = i + 1; j <= n + i; j++) {
        int index;
        if (j <= n) index = j;
        else index = j - n;

        System.out.println("i: " + i + ", index: " + index);
      }
    }
    return null;
  }

  public static TreeNode generateTree(List<Integer> list) {
    return null;
  }

  public static void main(String[] args) {
    generateTrees(3);
  }

}
