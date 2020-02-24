import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.heap.HeapUtils;
import util.tree.TreeNode;
import util.tree.TreeUtils;

class Solution {

  public static void main(String[] args) {
    TreeNode root = TreeUtils.arrayToCompleteBinaryTree(new int[]{0, 1, 2, 3, 4, 5, 6});
    List<Integer> res = postorderTraversal(root);
    System.out.println(res);
  }

  public static List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> res = new LinkedList<>();

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        res.addFirst(curr.val);
        stack.push(curr);
        curr = curr.right;
      }
      curr = stack.pop();
      curr = curr.left;
    }

    return res;
  }

}