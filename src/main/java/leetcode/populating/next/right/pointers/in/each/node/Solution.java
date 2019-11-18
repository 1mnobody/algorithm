package leetcode.populating.next.right.pointers.in.each.node;

/**
 * Created by wuzhsh on 11/18/2019.
 */
public class Solution {

    public Node connect(Node root) {
        if (root != null) {
            doConnect(root);
        }
        return root;
    }

    public void doConnect(Node node) {
        if (node.left == null && node.right == null) return;
        if (node.left != null) {
            node.left.next = node.right;
        }
        if (node.right != null && node.next != null) {
            node.right.next = node.next.left;
        }
        if(node.left!=null) doConnect(node.left);
        if(node.right!=null) doConnect(node.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
