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
    
    HashMap<Node, Node> map;
    
    public Node copyRandomList(Node head) {
        
        if(head == null) return null;
        
        map = new HashMap<>();
        
        Node curr = head;
        Node copyHead = new Node(curr.val);
        Node copyCurr = copyHead;
        map.put(curr, copyHead);
        
        while(curr.next != null) {
            copyCurr.next = new Node(curr.next.val);
            map.put(curr.next, copyCurr.next);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        curr = head;
        copyCurr = copyHead;
        
        while(curr != null) {
            if(curr.random != null)
                copyCurr.random = map.get(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;            
        }
        
        return copyHead;
    }
}