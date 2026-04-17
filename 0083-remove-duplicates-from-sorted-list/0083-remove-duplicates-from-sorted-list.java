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
    public ListNode deleteDuplicates(ListNode head) {
        // Start with the current node at the head
        ListNode current = head;
        
        // Traverse until the end of the list
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Duplicate found: skip the next node
                current.next = current.next.next;
            } else {
                // No duplicate: move to the next node
                current = current.next;
            }
        }
        
        return head;
    }
}
