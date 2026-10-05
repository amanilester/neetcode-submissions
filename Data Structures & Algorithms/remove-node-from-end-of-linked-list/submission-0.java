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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = 0;
        while(curr != null) {
            length++;
            curr = curr.next;
        }

        int index = length - n;
        int ptr = 0;
        curr = head;
        ListNode prev = null;
        while(curr != null) {
            if(ptr == index) {
                if(curr == head)
                    return head.next;
                else
                    prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
            ptr++;
        }
        return head;
    }
}
