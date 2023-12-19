class LRUCache {
    
    int capacity;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    
    class ListNode {
        
        int key;
        int value;
        ListNode next;
        ListNode prev;
        
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key))
            return -1;
        
        ListNode temp = map.get(key);
        remove(temp);
        add(temp);
        
        return temp.value;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)) {
            ListNode temp = map.get(key);
            remove(temp);
        }
        
        ListNode newNode = new ListNode(key, value);
        add(newNode);
        map.put(key, newNode);
        
        if(map.size() > capacity) {
            ListNode temp = tail.prev;
            remove(temp);
            map.remove(temp.key);
        }
    }
    
    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void add(ListNode node) {        
        ListNode temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */