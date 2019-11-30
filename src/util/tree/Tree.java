package util.tree;

import java.util.*;
import java.util.LinkedList;

public class Tree {

  private static List<Integer> res = new ArrayList<>();

  /**
   * 二叉树的前序遍历, 递归法
   */
  public static void preorderTraversal(TreeNode root) {
    if (root != null) {
      res.add(root.val);
      preorderTraversal(root.left);
      preorderTraversal(root.right);
    }
  }

  /**
   * 二叉树前序遍历, 迭代法
   */
  public static void preorderTraversalIte(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    // 指针指向根节点
    TreeNode curr = root;
    // 记住这个条件
    while (curr != null || !stack.isEmpty()) {
      // 向左遍历, 包括当前指针, 压入栈中, 最后curr会变成null, 向左溢出
      while (curr != null) {
        stack.push(curr);
        // 添加的时候读值!!!
        res.add(curr.val);
        curr = curr.left;
      }
      // 指针位置恢复到出栈位置
      curr = stack.pop();
      // 向右子节点走, 如果有值就会在下一轮遍历中压入栈中, 如果无值就向右溢出, 通过下一步出栈恢复
      curr = curr.right;
    }
  }


  /**
   * 二叉树的中序遍历, 递归法
   */
  public static void inorderTraversal(TreeNode root) {
    if (root != null) {
      inorderTraversal(root.left);
      res.add(root.val);
      inorderTraversal(root.right);
    }
  }

  /**
   * 二叉树中序遍历, 迭代法, 利用栈
   */
  public static void inorderTraversalIte(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    // 指针指向根节点
    TreeNode curr = root;
    // 记住这个条件
    while (curr != null || !stack.isEmpty()) {
      // 向左遍历, 包括当前指针, 压入栈中, 最后curr会变成null, 向左溢出
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      // 指针位置恢复到出栈位置
      curr = stack.pop();
      // 取值的时候读值!!!
      res.add(curr.val);
      // 向右子节点走, 如果有值就会在下一轮遍历中压入栈中, 如果无值就向右溢出, 通过下一步出栈恢复
      curr = curr.right;
    }
  }


  /**
   * 二叉树的后序遍历, 递归法
   */
  public static void postorderTraversal(TreeNode root) {
    if (root != null) {
      postorderTraversal(root.left);
      postorderTraversal(root.right);
      res.add(root.val);
    }
  }

  /**
   * 二叉树的层次遍历, 迭代法, 利用队列
   */
  public static void levelorderTraversalIte(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode temp = queue.poll();
      res.add(temp.val);
      if (temp.left != null) queue.offer(temp.left);
      if (temp.right != null) queue.offer(temp.right);
    }
  }

  /**
   * 树的最大深度/高度, 递归法
   * 思路: 从上往下探
   */
  public static int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int lh = maxDepth(root.left);
    int rh = maxDepth(root.right);
    return Math.max(lh, rh) + 1;
  }

  /**
   * 判断两个树是否镜像对称, 递归法
   */
  public static boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;

    return t1.val == t2.val
      && isMirror(t1.left, t2.right)
      && isMirror(t2.right, t1.left);
  }

  /**
   * 判断两个树是否相同
   */
  public static boolean isSame(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;

    return t1.val == t2.val
      && isSame(t1.left, t2.left)
      && isSame(t1.right, t2.right);
  }

}
