package leet_code;

import util.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Item111 {

  public int minDepth(TreeNode root) {
    if (root == null) return 0;

    int leftMin = minDepth(root.left);
    int rightMin = minDepth(root.right);

    if (root.left != null && root.right != null)
      return Math.min(leftMin, rightMin) + 1;
    else
      return leftMin + rightMin + 1;
  }

  public static int minDepthDFS(TreeNode root) {
    return -1;
  }

  public static int minDepthBFS(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 1;
    while (!queue.isEmpty()) {
      int levelLength = queue.size();
      for (int i = 0; i < levelLength; i++) {
        TreeNode curr = queue.poll();
        if (curr.left == null && curr.right == null) return depth;
        if (curr.left != null) queue.offer(curr.left);
        if (curr.right != null) queue.offer(curr.right);
      }
      depth++;
    }
    return -1;
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    t1.left = new TreeNode(2);
    t1.right = new TreeNode(3);
    t1.left.left = new TreeNode(4);
    t1.right.right = new TreeNode(5);
    System.out.println(minDepthBFS(t1));

    TreeNode t2 = new TreeNode(3);
    t2.left = new TreeNode(9);
    t2.right = new TreeNode(20);
    t2.right.left = new TreeNode(15);
    t2.right.right = new TreeNode(7);
    System.out.println(minDepthBFS(t2));
  }

}
