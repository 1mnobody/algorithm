package leetcode.tree.level.order;

import java.util.*;

/**
 * Created by wuzhsh on 11/7/2019.
 */
public class Solution {
    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> tmp = new ArrayList<>();
            while(size -- > 0) {
                TreeNode node = deque.poll();
                tmp.add(node.val);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    // DFS
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode node, int level) {
        // 当前层级还没有array来保存数据，则新增一个array
        if (res.size() == level) {
            res.add(level, new ArrayList<>());
        }
        res.get(level).add(node.val);
        if(node.left != null) dfs(res, node.left, level+1);
        if(node.right != null) dfs(res, node.right, level+1);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
