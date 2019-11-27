package leetcode.binary.tree.right.side.view;

import java.util.*;

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

    public List<Integer> rightSideView2(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map, 0);
        return new ArrayList<>(map.values());
    }

    //  这里使用了map，先遍历左边的节点，再遍历右边的节点，同一层级的左边节点会被右边节点覆盖
    // leetcode上还有使用 list 直接存储的，这种情况下，就是先遍历右边节点，将相关的数据填充到list（list.size表示当前层级，
    // 所以只加最后一个元素），再遍历左节点，完成更下层节点对应数据的填充
    public void dfs(TreeNode node, Map<Integer, Integer> map, int level) {
        if (node != null) {
            map.put(level, node.val);
            dfs(node.left, map, level + 1);
            dfs(node.right, map, level + 1);
        }
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