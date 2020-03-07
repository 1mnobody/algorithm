package leetcode.binary.tree.inorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while(currentNode != null || !stack.isEmpty()) {
            // 处理树中最左边的节点
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            // 到此，树中最左边的节点在栈顶了（即，该节点可输出）
            currentNode = stack.pop();
            res.add(currentNode.val);
            // 处理最左节点的右子树
            currentNode = currentNode.right;
        }
        return res;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
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
