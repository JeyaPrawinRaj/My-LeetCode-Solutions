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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Step 1: Create a dummy node to act as the starting anchor
        ListNode dummy = new ListNode(0);
        // Step 2: Use a 'curr' pointer to build the new list
        ListNode curr = dummy;

        // Step 3: Compare heads of both lists while both are non-empty
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;   // Link to list1 node
                list1 = list1.next;  // Advance list1
            } else {
                curr.next = list2;   // Link to list2 node
                list2 = list2.next;  // Advance list2
            }
            curr = curr.next;        // Move curr pointer forward
        }

        // Step 4: Attach the remaining part of whichever list isn't empty
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        // Step 5: Return the head of the merged list (after the dummy)
        return dummy.next;
    }
}
