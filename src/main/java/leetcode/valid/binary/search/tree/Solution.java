package leetcode.valid.binary.search.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 搜索二叉树中序遍历得到的结果是有序的
    public boolean isValidBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inOrder(root, l);
        for (int i = 0; i < l.size()-1; i++) {
            if (l.get(i) >= l.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.val);
            inOrder(node.right, list);
        }
    }

    public boolean isValidBST2(TreeNode root) {
        return valid(root, null, null);
    }

    public boolean valid(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min !=null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        return valid(node.left, min, node.val) && valid(node.right, node.val, max);
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