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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l1Ptr = l1, l2Ptr = l2;
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;

        while(l1Ptr != null && l2Ptr != null) {
            ptr.next = new ListNode((l1Ptr.val + l2Ptr.val + carry) % 10);
            carry = (l1Ptr.val + l2Ptr.val + carry) / 10;
            l1Ptr = l1Ptr.next;
            l2Ptr = l2Ptr.next;
            ptr = ptr.next;
        }

        while(l1Ptr != null) {
            ptr.next = new ListNode((l1Ptr.val + carry) % 10);
            carry = (l1Ptr.val + carry) / 10;
            l1Ptr = l1Ptr.next;
            ptr = ptr.next;
        }
        while(l2Ptr != null) {
            ptr.next = new ListNode((l2Ptr.val + carry) % 10);
            carry = (l2Ptr.val + carry) / 10; 
            l2Ptr = l2Ptr.next;
            ptr = ptr.next;
        }
        if(carry > 0)
            ptr.next = new ListNode(carry);
        return dummy.next;
    }
}
