class MinStack {

    int min;
    Stack<Integer> stack1;
    
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        stack1 = new Stack<>();
    }
    
    public void push(int val) {
        stack1.push(min);
        stack1.push(val);     
        min = Math.min(min, val);
    }
    
    public void pop() {

        stack1.pop();
        min = stack1.pop();
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