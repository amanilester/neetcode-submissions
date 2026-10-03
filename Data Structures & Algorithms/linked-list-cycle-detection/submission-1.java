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
        HashMap<Integer, ListNode> indexVals = new HashMap<>();
        int i = 0;
        while(head != null) {
            if(indexVals.containsValue(head))
                return true;
            indexVals.put(i, head);
            i++;
            head = head.next;
        }
        return false;
    }
}
