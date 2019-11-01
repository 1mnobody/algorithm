package leetcode.merge.two.sorted.lists;

/**
 * Created by wuzhsh on 2019/3/28.
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode headIndex = dummyHead;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                headIndex.next = l1;
                l1 = l1.next;
            } else {
                headIndex.next = l2;
                l2 = l2.next;
            }
            headIndex = headIndex.next;
        }
        if (l1 == null) {
            headIndex.next = l2;
        }
        if (l2 == null) {
            headIndex.next = l1;
        }
        return dummyHead.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}