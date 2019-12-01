package util.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

  public static TreeNode nonNullArrayToTree(int[] array, int index) {
    TreeNode root = null;
    if (index < array.length) {
      int value = array[index];
      root = new TreeNode(value);
      root.left = nonNullArrayToTree(array, 2 * index + 1);
      root.right = nonNullArrayToTree(array, 2 * index + 2);
      return root;
    }
    return root;
  }


  /**
   *  示例:
   *         0
   *       1    2
   *               3
   *
   *  [0, 1, 2, null, null, null, 3]
   */
  public static Integer[] treeToNullableArray(TreeNode root) {
    int depth = Tree.maxDepth(root);
    int length = (1 << depth) - 1;

    Integer[] res = new Integer[length];

    // LinkedList可空, ArrayDeque不可空
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    for (int i = 0; i < length && !queue.isEmpty(); i++) {
      TreeNode temp = queue.poll();

      if (temp != null) res[i] = temp.val;
      else res[i] = null;

      if (temp != null && temp.left != null) queue.offer(temp.left);
      else queue.offer(null);

      if (temp != null && temp.right != null) queue.offer(temp.right);
      else queue.offer(null);
    }

    return res;
  }

  //         0
  //     1       2
  //   3   4   5   6
  //                  14
  // 前序遍历: [0, 1, 3, 4, 2, 5, 6, 14]
  // 中序遍历: [3, 1, 4, 0, 5, 2, 6, 14]
  // 后序遍历: [3, 4, 1, 5, 14, 6, 2, 0]
  public static TreeNode createDemoBinaryTree() {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.right.right = new TreeNode(14);
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.right = new TreeNode(12);
    root.right.right = new TreeNode(15);

    Integer[] arr = treeToNullableArray(root);
    System.out.println(Arrays.toString(arr));
  }

}
