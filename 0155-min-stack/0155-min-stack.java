class MinStack {

    int min;
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        stack2.push(min);
    }
    
    public void push(int val) {
        stack1.push(val);
        if(val <= min) {
            stack2.push(min);
            min = val;
        }
        
    }
    
    public void pop() {
        
        if(stack1.pop() == min) 
            min = stack2.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */