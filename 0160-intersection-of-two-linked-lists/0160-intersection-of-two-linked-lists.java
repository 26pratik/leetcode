/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int m = 0, n = 0;
        int count = 0;
        ListNode tempA= headA;
        ListNode tempB = headB;
        
        while(tempA != null) {
            tempA = tempA.next;
            m++;
        }
        
        while(tempB != null) {
            tempB = tempB.next;
            n++;
        }
        
        if(m < n) {
            while(count < n-m) {
                headB = headB.next;
                count++;
            }
        }
        else if(n < m) {
            while(count < m-n) {
                headA = headA.next;
                count++;
            }
        }
        
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}