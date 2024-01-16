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
        
        while(curr != null) {
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return copyHead;
    }
    
    private Node clone(Node node) {
        if(node == null) return null;
        if(!map.containsKey(node))
            map.put(node, new Node(node.val));
        return map.get(node);
    }
}