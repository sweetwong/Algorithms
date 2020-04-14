package leet_code;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.tree.TreeNode;

public class Item103_二叉树的锯齿形层次遍历 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);

        boolean forward = true;

        while (!deque.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();

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

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.right.right = new TreeNode(5);

        List<List<Integer>> lists1 = zigzagLevelOrder(t1);
        System.out.println(lists1.toString());

        TreeNode t2 = new TreeNode(3);
        t2.left = new TreeNode(9);
        t2.right = new TreeNode(20);
        t2.right.left = new TreeNode(15);
        t2.right.right = new TreeNode(7);

        List<List<Integer>> lists2 = zigzagLevelOrder(t2);
        System.out.println(lists2.toString());
    }

}
