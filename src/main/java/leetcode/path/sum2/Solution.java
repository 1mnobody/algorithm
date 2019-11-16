package leetcode.path.sum2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        pathSum(res, new ArrayList<>(), root, sum);
        return res;
    }

    public void pathSum(List<List<Integer>> res, List<Integer> tmp, TreeNode node, int sum) {
        tmp.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == node.val) res.add(new ArrayList<>(tmp));
            // return，当前节点遍历完成，也要删除
            tmp.remove(tmp.size() - 1);
            return;
        }
        if (node.left != null) pathSum(res, tmp, node.left, sum - node.val);
        if (node.right != null) pathSum(res, tmp, node.right, sum - node.val);
        // 当前节点遍历完成，删除节点
        tmp.remove(tmp.size() - 1);
    }
}
