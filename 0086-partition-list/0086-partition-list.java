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
    public ListNode partition(ListNode head, int x) {
        // Dummy nodes to start the 'before' and 'after' lists
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                // Add to the 'before' list
                before.next = head;
                before = before.next;
            } else {
                // Add to the 'after' list
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Important: End the 'after' list to avoid cycles
        after.next = null;
        
        // Link the 'before' list to the 'after' list
        before.next = afterHead.next;

        return beforeHead.next;
    }
}
