package leetcode.house.robberIII;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area,
 * called the "root." Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * Created by wuzhsh on 12/13/2019.
 */
public class Solution {

    // TODO 优化
    public int rob(TreeNode root) {
        int count1 = rob(root, true);
        int count2 = rob(root, false);
        return count1 > count2 ? count1 : count2;
    }

    public int rob(TreeNode node, boolean canRob) {
        if (node == null) return 0;
        if (canRob) {
            if (node.left == null && node.right == null) return node.val;
            int robChild = rob(node.left, true) + rob(node.right, true);
            int robParent = node.val + rob(node.left, false) + rob(node.right, false);
            return robChild > robParent ? robChild : robParent;
        } else {
            if (node.left == null && node.right == null) return 0;
            return rob(node.left, true) + rob(node.right, true);
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