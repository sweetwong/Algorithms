package leet_code;

import util.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Item199_二叉树的右视图 {

    /**
     * 开心, 一遍过o(*￣▽￣*)ブ
     * 用的是BFS的层次遍历
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        List<List<Integer>> traversal = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode curr = queue.poll();
                currLevel.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            traversal.add(currLevel);
        }

        for (List<Integer> level : traversal) {
            res.add(level.get(level.size() - 1));
        }

        return res;
    }

}
