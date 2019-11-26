package util;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.LinkedList;

public class Tree {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  private static List<Integer> list = new ArrayList<>();

  /**
   * 二叉树的前序遍历
   */
  public static void preorderTraversal(TreeNode root) {
    if (root != null) {
      list.add(root.val);
      preorderTraversal(root.left);
      preorderTraversal(root.right);
      System.out.println("val: " + root.val + ", 高度: " + height(root));
    }
  }

  /**
   * 二叉树的中序遍历递归法
   */
  public static void inorderTraversal(TreeNode root) {
    if (root != null) {
      inorderTraversal(root.left);
      list.add(root.val);
      inorderTraversal(root.right);
    }
  }

  //         0
  //     1       2
  //   3   4   5   6
  //                  7

  /**
   * 二叉树中序遍历迭代法
   */
  public static void inorderTraversalIte(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    stack.push(new TreeNode(-1));
    // 指针指向根节点
    TreeNode curr = root;
    while (!stack.empty()) {
      // 向左遍历, 包括当前指针, 压入栈中, 最后curr会变成null, 向左溢出
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      // 指针位置恢复到出栈位置
      curr = stack.pop();
      list.add(curr.val);
      // 向右子节点走, 如果有值就会在下一轮遍历中压入栈中, 如果无值就向右溢出, 通过下一步出栈恢复
      curr = curr.right;
    }
    if (!list.isEmpty()) list.remove(list.size() - 1);
  }


  /**
   * 二叉树的后序遍历
   */
  public static void postorderTraversal(TreeNode root) {
    if (root != null) {
      postorderTraversal(root.left);
      postorderTraversal(root.right);
      list.add(root.val);
    }
  }

  private static Queue<Integer> queue = new LinkedList<>();

  public static void levelTraversal(TreeNode root) {
    if (root != null) {
      queue.offer(root.val);

      while (!queue.isEmpty()) {
      }
    }
  }


  //         0
  //     1       2
  //   3   4   5   6
  //                  7
  // 前序遍历: [0, 1, 3, 4, 2, 5, 6, 7]
  // 中序遍历: [3, 1, 4, 0, 5, 2, 6, 7]
  // 后序遍历: [3, 4, 1, 5, 7, 6, 2, 0]
  public static TreeNode createTree() {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.right.right = new TreeNode(7);
    return root;
  }

  //         5
  //     3       8
  //   1   4   6   9
  //                  10
  // 中序遍历: [1, 3, 4, 5, 6, 8, 9, 10]
  public static TreeNode createBinarySearchTree() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);
    root.right.right.right = new TreeNode(10);
    return root;
  }

  public static int height(TreeNode root) {
    if (root == null) return 0;

    /* compute height of each subtree */
    int lHeight = height(root.left);
    int rHeight = height(root.right);

    /* use the larger one */
    if (lHeight > rHeight) return (lHeight + 1);
    else return (rHeight + 1);
  }

  public static void main(String[] args) {
    TreeNode root = createTree();
    inorderTraversalIte(root);
    System.out.println(list.toString());
  }

}
