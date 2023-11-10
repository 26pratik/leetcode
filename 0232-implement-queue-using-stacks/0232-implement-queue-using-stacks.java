class MyQueue {

    Stack<Integer> primary;
    Stack<Integer> secondary;
    
    public MyQueue() {
        primary = new Stack<>();
        secondary = new Stack<>();
    }
    
    public void push(int x) {
        primary.push(x);
    }
    
    public int pop() {
        
        if(empty()) return -1;
        
        transfer();
        
        return secondary.pop();
    }
    
    public int peek() {
        
        if(empty()) return -1;
        
        transfer();

        return secondary.peek();
    }
    
    public boolean empty() {
        return primary.isEmpty() && secondary.isEmpty();
    }
    
    private void transfer() {

        if(secondary.isEmpty()) 
            while(!primary.isEmpty()) 
                secondary.push(primary.pop());        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */