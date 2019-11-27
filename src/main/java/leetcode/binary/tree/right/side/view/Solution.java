package leetcode.binary.tree.right.side.view;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by wuzhsh on 11/27/2019.
 */
public class Solution {
    TreeNode dummyNode = new TreeNode(-1);

    public List<Integer> rightSideView(TreeNode root) {
        return bfs(root, new ArrayList<>());
    }

    public List<Integer> bfs(TreeNode root, List<Integer> res) {
        if (root == null) return res;
        Deque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.addLast(root);
        treeNodes.addLast(dummyNode);
        TreeNode lastNode = root;
        while (true) {
            TreeNode node = treeNodes.remove();
            if (node == dummyNode) {
                res.add(lastNode.val);
                // 队列为空，表示树已经遍历完毕
                if (treeNodes.isEmpty()) break;
                treeNodes.addLast(dummyNode);
            } else {
                lastNode = node;
                if (node.left != null) treeNodes.addLast(node.left);
                if (node.right != null) treeNodes.addLast(node.right);
            }
        }
        return res;
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