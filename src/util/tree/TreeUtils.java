package util.tree;

import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;

import sort.nlogn.QuickSort;
import util.array.ArrayUtils;

/**
 * 二叉树的常规操作
 *
 * 1. 前/中/后序遍历的递归法和迭代法, 迭代法有分为先压入和后压入
 * 2. 层次遍历的递归法和迭代法
 * 3. 层次遍历, 区别每一层
 * 4. Z型遍历, 利用双端队列
 * 5. 获取树的深度
 * 6. 判断两个树是否相等/是否镜像对称
 * 7. 将树转为列表
 */
public class TreeUtils {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    TreeNode root = arrayToCompleteBinaryTree(nums, 0);

    inorderTraversal(root);
    System.out.println(res.toString());

    res.clear();

    inorderTraversalIte(root);
    System.out.println(res.toString());
  }

  private static LinkedList<Integer> res = new LinkedList<>();

  /**
   * 二叉树的前序遍历, 递归法, DFS
   */
  public static void preorderTraversal(TreeNode root) {
    if (root != null) {
      res.add(root.val);
      preorderTraversal(root.left);
      preorderTraversal(root.right);
    }
  }

  /**
   * 二叉树前序遍历, 迭代法, DFS, 先压入栈, 类似层次遍历的用法
   */
  public static void preorderTraversalIte(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode temp = stack.pop();
      res.add(temp.val);
      if (temp.right != null) stack.push(temp.right);
      if (temp.left != null) stack.push(temp.left);
    }
  }

  /**
   * 二叉树前序遍历, 迭代法, DFS, 后压入栈
   */
  public static void preorderTraversalIte1(TreeNode root) {
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
   * 二叉树的中序遍历, 递归法, DFS
   */
  public static void inorderTraversal(TreeNode root) {
    if (root != null) {
      inorderTraversal(root.left);
      res.add(root.val);
      inorderTraversal(root.right);
    }
  }

  /**
   * 二叉树中序遍历, 迭代法, 利用栈, DFS, 后压入
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
   * 二叉树的后序遍历, 递归法, DFS
   */
  public static void postorderTraversal(TreeNode root) {
    if (root != null) {
      postorderTraversal(root.left);
      postorderTraversal(root.right);
      res.add(root.val);
    }
  }

  /**
   * 二叉树后序遍历, 迭代法, DFS, 先压入栈
   */
  public static void postorderTraversalIte(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode temp = stack.pop();
      res.addFirst(temp.val);
      if (temp.left != null) stack.push(temp.left);
      if (temp.right != null) stack.push(temp.right);
    }
  }

  /**
   * 二叉树后序遍历, 迭代法, 利用栈, DFS, 后压入栈
   */
  public static void postorderTraversalIte2(TreeNode root) {
  }


  /**
   * 二叉树的层次遍历, 递归法,DFS
   * 在前/中/后序遍历的基础上, 给每一次遍历注明深度, 根据深度来加入到集合中
   */
  public List<List<Integer>> levelOrderTraversal(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    levelOrderTraversalHelper(res, root, 0);
    return res;
  }

  private void levelOrderTraversalHelper(List<List<Integer>> res, TreeNode root, int currDepth) {
    if (root != null) {
      if (res.size() == currDepth) res.add(new ArrayList<Integer>());

      res.get(currDepth).add(root.val);
      levelOrderTraversalHelper(res, root.left, currDepth + 1);
      levelOrderTraversalHelper(res, root.right, currDepth + 1);
    }
  }


  /**
   * 二叉树的层次遍历, 迭代法, 利用队列, BFS
   */
  public static void levelOrderTraversalIte(TreeNode root) {
    if (root == null) return;

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
   * 二叉树的层次遍历, 迭代法, 利用队列, 区别每一层, BFS
   */
  public static List<List<Integer>> levelOrderTraversalIte2(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      // 每次遍历一层
      List<Integer> levelList = new ArrayList<>();

      // 此处必须先赋值, 因为queue.size()会一直变化
      int levelLength = queue.size();
      // 每次把队列中前一层的拿完
      for (int i = 0; i < levelLength; i++) {
        TreeNode curr = queue.poll();
        levelList.add(curr.val);
        if (curr.left != null) queue.offer(curr.left);
        if (curr.right != null) queue.offer(curr.right);
      }

      res.add(levelList);
    }

    return res;
  }

  /**
   * Z字形层次遍历, 迭代法, 在层次遍历的基础上拓展, 利用双端队列, BFS
   */
  public static List<List<Integer>> zigzagLevelOrderTraversal(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerLast(root);

    boolean forward = true;

    while (!deque.isEmpty()) {
      List<Integer> levelList = new ArrayList<>();

      // 此处必须先赋值, 因为deque.size()会一直变化
      int levelLength = deque.size();
      for (int i = 0; i < levelLength; i++) {
        TreeNode curr;
        // 正向(正常的操作, 从队尾排入, 从队首取出, 先排左边, 再排右边)
        if (forward) {
          curr = deque.pollFirst();
          levelList.add(curr.val);
          if (curr.left != null) deque.offerLast(curr.left);
          if (curr.right != null) deque.offerLast(curr.right);

        }
        // 反向(反向的操作, 从队首排入, 从队尾取出, 先排右边, 再排左边)
        else {
          curr = deque.pollLast();
          levelList.add(curr.val);
          if (curr.right != null) deque.offerFirst(curr.right);
          if (curr.left != null) deque.offerFirst(curr.left);
        }
      }

      res.add(levelList);
      forward = !forward;
    }
    return res;
  }


  /**
   * 树的最大深度/高度, 递归法
   * 思路: 从上往下探深度
   */
  public static int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
    // 同时为空, 说明相等
    if (t1 == null && t2 == null) return true;
    // 不同是为空, 说明不相等
    if (t1 == null || t2 == null) return false;

    return t1.val == t2.val
      && isSame(t1.left, t2.left)
      && isSame(t1.right, t2.right);
  }

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

  /**
   * 把树转为可空列表, 如果有节点就传入节点的值, 没有就传入null
   */
  public static List<Integer> treeToNullableList(TreeNode root) {
    int maxDepth = TreeUtils.maxDepth(root);
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

  /**
   * 把树转为可空嵌套列表, 如果有节点就传入节点的值, 没有就传入null
   */
  public static List<List<Integer>> treeToNullableLists(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    int maxDepth = TreeUtils.maxDepth(root);
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

  public static <T> void printLists(List<List<T>> lists) {
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
