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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        int i = 0;
        while(slow != null && fast != null) {
            if(slow == fast)
                i++;
            if(i == 2)
                return true;
            slow = slow.next;
            try {
                fast = fast.next.next;
            } catch (NullPointerException e) {
                return false;
            }
        }
        return false;
    }
}
