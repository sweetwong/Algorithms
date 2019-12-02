package util.tree;

import java.util.*;

public class TreeUtils {

  public static TreeNode arrayToCompleteBinaryTree(int[] array, int index) {
    TreeNode root = null;
    if (index < array.length) {
      int value = array[index];
      root = new TreeNode(value);
      root.left = arrayToCompleteBinaryTree(array, 2 * index + 1);
      root.right = arrayToCompleteBinaryTree(array, 2 * index + 2);
      return root;
    }
    return root;
  }

  public static List<Integer> treeToNullableList(TreeNode root) {
    int maxDepth = Tree.maxDepth(root);
    int maxLength = (1 << maxDepth) - 1;

    List<Integer> res = new ArrayList<>(maxLength);

    // LinkedList可空, ArrayDeque不可空
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    for (int i = 0; i < maxLength; i++) {
      TreeNode temp = queue.poll();

      if (temp != null) res.add(temp.val);
      else res.add(null);

      if (temp != null && temp.left != null) queue.offer(temp.left);
      else queue.offer(null);

      if (temp != null && temp.right != null) queue.offer(temp.right);
      else queue.offer(null);
    }

    return res;
  }

  public static List<List<Integer>> treeToNullableLists(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    int maxDepth = Tree.maxDepth(root);
    // 最大深度对应的最大节点数
    int maxLength = (1 << maxDepth) - 1;

    // LinkedList可空, ArrayDeque不可空
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int currDepth = 0;
    int i = 0;
    while (i < maxLength) {
      List<Integer> levelList = new ArrayList<>();
      // 点前深度的最大节点数
      int levelLength = 1 << currDepth;
      for (int j = 0; j < levelLength; j++) {
        TreeNode curr = queue.poll();
        if (curr != null) levelList.add(curr.val);
        else levelList.add(null);

        if (curr != null && curr.left != null) queue.offer(curr.left);
        else queue.offer(null);

        if (curr != null && curr.right != null) queue.offer(curr.right);
        else queue.offer(null);

        i++;
      }
      res.add(levelList);

      currDepth++;
    }

    return res;
  }


  public static void printLists(List<List<Integer>> lists) {
    int size = lists.size();
    if (size == 0) {
      System.out.println("[]");
      return;
    }
    System.out.println("[");
    for (int i = 0; i < size - 1; i++) {
      System.out.println("  " + lists.get(i).toString() + ",");
    }
    System.out.println("  " + lists.get(size - 1));
    System.out.println("]");
  }

}
