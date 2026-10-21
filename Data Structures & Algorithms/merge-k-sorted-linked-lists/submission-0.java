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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 1) {
            return lists[0];
        }
        if(lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        int l = 0;
        for(int r = 1; r < lists.length; r++) {
            ListNode list1 = lists[l];
            ListNode list2 = lists[r];
            ListNode ptr = dummy;
            while(list1 != null && list2 != null) {
                if(list1.val <= list2.val) {
                    ptr.next = list1;
                    list1 = list1.next;
                } else {
                    ptr.next = list2;
                    list2 = list2.next;
                }
                ptr = ptr.next;
            }
            if(list1 != null) {
                ptr.next = list1;
                ptr = ptr.next;
            }
            if(list2 != null) {
                ptr.next = list2;
                ptr = ptr.next;
            }
            lists[l] = dummy.next;
        }
        return dummy.next;
    }
}
