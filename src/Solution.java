import util.heap.HeapUtils;
import util.tree.TreeNode;
import util.tree.TreeUtils;

import java.util.List;

class Solution {

  public static void main(String[] args) {
    int[] nums = {0, 1, 2, 3, 4, 5, 6};
    TreeNode root = TreeUtils.arrayToCompleteBinaryTree(nums);
    HeapUtils.printHeap(nums);

    System.out.println();

    List<List<Integer>> res = TreeUtils.levelOrderTraversalIte2(root);

    System.out.println(res.toString());
  }

}