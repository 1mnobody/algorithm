package leetcode.construct.tree.from.preorder.inorder.traverse;

/**
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Created by wuzhsh on 11/15/2019.
 */
public class Solution {

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return buildTree(preOrder, 0, inOrder, 0, inOrder.length - 1);
    }

    // preOrder中的第一个元素为当前子树的根，找到其在inOrder中的位置i，inOrder中i元素左边为左子树，右边为右子树
    // preOrder中第二个元素为左子树的跟，i+（左子树元素个数）+1处为右子树的根
    public TreeNode buildTree(int[] preOrder, int curPreIdx, int[] inOrder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        TreeNode node = new TreeNode(preOrder[curPreIdx]);
        if (inLeft == inRight) {
            return node;
        } else {// 存在子树
            int i;
            for (i = inLeft; i <= inRight; i++) {
                if (inOrder[i] == preOrder[curPreIdx]) {
                    break;
                }
            }
            node.left = buildTree(preOrder, curPreIdx + 1, inOrder, inLeft, i - 1);
            node.right = buildTree(preOrder, curPreIdx + (i - inLeft) + 1, inOrder, i + 1, inRight);
            return node;
        }
    }
}

