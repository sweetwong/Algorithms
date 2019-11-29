package util.tree;

public class BinarySearchTree {


  //         5
  //     3       8
  //   1   4   6   9
  //                  10
  // 中序遍历: [1, 3, 4, 5, 6, 8, 9, 10]

  /**
   *
   */
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

}
