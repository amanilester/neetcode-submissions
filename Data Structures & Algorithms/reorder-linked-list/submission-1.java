/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode s = head;
        ListNode f = head.next;
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode second = s.next, prev = null;
        s.next = null;
        while(second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        second = prev;
        ListNode first = head;
        while(second != null) {
            ListNode tmp1 = first.next, tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
