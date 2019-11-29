package util.tree;

import java.util.*;
import java.util.LinkedList;

public class BinaryTree {

  private List<Integer> res = new ArrayList<>();

  /**
   * 二叉树的前序遍历, 递归法
   */
  public void preorderTraversal(TreeNode root) {
    if (root != null) {
      res.add(root.val);
      preorderTraversal(root.left);
      preorderTraversal(root.right);
    }
  }

  /**
   * 二叉树前序遍历, 迭代法
   */
  public void preorderTraversalIte(TreeNode root) {
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
  public void inorderTraversal(TreeNode root) {
    if (root != null) {
      inorderTraversal(root.left);
      res.add(root.val);
      inorderTraversal(root.right);
    }
  }

  /**
   * 二叉树中序遍历, 迭代法, 利用栈
   */
  public void inorderTraversalIte(TreeNode root) {
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
  public void postorderTraversal(TreeNode root) {
    if (root != null) {
      postorderTraversal(root.left);
      postorderTraversal(root.right);
      res.add(root.val);
    }
  }

  /**
   * 二叉树的层次遍历, 迭代法, 利用队列
   */
  public void levelorderTraversalIte(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode temp = queue.poll();
      res.add(temp.val);
      if (temp.left != null) queue.offer(temp.left);
      if (temp.right != null) queue.offer(temp.right);
    }
  }

  //         0
  //     1       2
  //   3   4   5   6
  //                  14
  //                    30
  // 前序遍历: [0, 1, 3, 4, 2, 5, 6, 14, 30]
  // 中序遍历: [3, 1, 4, 0, 5, 2, 6, 14, 30]
  // 后序遍历: [3, 4, 1, 5, 14, 30, 6, 2, 0]
  public static TreeNode createBinaryTree() {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.right.right = new TreeNode(14);
    root.right.right.right.right = new TreeNode(30);
    return root;
  }


  public static TreeNode createBinaryTreeByArray(int[] array, int index) {
    TreeNode root = null;
    if (index < array.length) {
      int value = array[index];
      root = new TreeNode(value);
      root.left = createBinaryTreeByArray(array, 2 * index + 1);
      root.right = createBinaryTreeByArray(array, 2 * index + 2);
      return root;
    }
    return root;
  }

}
