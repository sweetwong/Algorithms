package leet_code;

import data_structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Item107_二叉树的层次遍历II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
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

            res.addFirst(levelList);
        }
        return res;
    }

}
