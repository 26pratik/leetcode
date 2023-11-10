class MyHashMap {
    
    int size;
    Node[] hashMap;
    
    class Node {
        int key;
        int value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.size = 10000;
        hashMap = new Node[size];
    }
    
    private int getHash(int key) {
        return key % size;    
    }
    
    public void put(int key, int value) {
        
        int hash = getHash(key);
        
        if(hashMap[hash] == null) 
            hashMap[hash] = new Node(-1,-1);
        
        Node prev = findPrev(hashMap[hash], key);
        
        if(prev.next == null)
            prev.next = new Node(key, value);
        else {
            prev.next.key = key;
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        
        int hash = getHash(key);
        
        if(hashMap[hash] == null)
            return -1;
        
        Node prev = findPrev(hashMap[hash], key);
        
        if(prev.next != null)
            return prev.next.value;
        
        return -1;
    }
    
    public void remove(int key) {
        
        int hash = getHash(key);
        
        if(hashMap[hash] != null) {
            Node prev = findPrev(hashMap[hash], key);
            
            if(prev.next != null) {
                prev.next = prev.next.next;
            }
        }
    }
    
    private Node findPrev(Node node, int key) {
        
        while(node.next != null && node.next.key != key) {
            node = node.next;
        }
        
        return node;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */