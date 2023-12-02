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
        
        int count = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        while(count <= n) {
            fast = fast.next;
            count++;
        }
        
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Line 1 and 2 are needed for garbage collection. 
        // ListNode temp = slow.next;           //Line 1
        slow.next = slow.next.next;
        // temp.next = null;                    //Line 2
        
        // return head;                      WILL NOT WORK IN EXAMPLE 2 -> input: head = [1], n = 1, OUTPUT: []
        return dummy.next;
    }
}