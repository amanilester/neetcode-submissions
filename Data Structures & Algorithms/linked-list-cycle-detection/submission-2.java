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
        HashSet<ListNode> indexVals = new HashSet<>();
        while(head != null) {
            if(indexVals.contains(head))
                return true;
            indexVals.add(head);
            head = head.next;
        }
        return false;
    }
}
