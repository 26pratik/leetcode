/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        
        if(head == null) return null;
        
        Node curr = head;
        
        while(curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        
        curr = head;
        Node copyCurr = curr.next;
        
        while(curr != null) {
            if(curr.random != null)
                copyCurr.random = curr.random.next;
            curr = curr.next.next;
            if(copyCurr.next != null)
                copyCurr = copyCurr.next.next;
        }
        
        curr = head;
        copyCurr = curr.next;
        Node copyHead = copyCurr;
        
        while(curr != null) {
            curr.next = curr.next.next;
            if(copyCurr.next != null)
                copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return copyHead;
    }
}