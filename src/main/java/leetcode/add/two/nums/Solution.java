package leetcode.add.two.nums;

/**
 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode index1 = l1;
        ListNode index2 = l2;
        ListNode index = null;
        int carry = 0;
        ListNode head = null;

        // 1 处理都不为空的情况
        while(index1 != null && index2 != null) {
            int val = index1.val + index2.val + carry;
            if (val >= 10) {
                val = val - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(val);
            if(head == null) {
                head = node;
                index = head;
            } else {
                index.next = node;
                index = index.next;
            }
            index1 = index1.next;
            index2 = index2.next;
        }
        // 2 有一个链表已经遍历完毕
        ListNode n = index1 == null ? index2 : index1;
        while(n != null) {
            int val = n.val + carry;
            if(val >= 10) {
                carry = 1;
                val = val - 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(val);
            n = n.next;
            index.next = node;
            index = index.next;
        }
        // 最后还有进位的情况
        if (carry == 1) {
            index.next = new ListNode(1);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        n2.next = n3;
        ListNode h = Solution.addTwoNumbers(n1, n2);
        for(ListNode i = h; i != null; i = i.next) {
            System.out.print(i.val + " ");
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
