class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        for(String el: tokens) {
            if(!set.contains(el)) {
                st.push(Integer.parseInt(el));
            }
            else {
                int second = st.pop();
                int first = st.pop();
                
                if(el.equals("+")) {
                    int result = first + second;
                    st.push(result);
                }
                else if(el.equals("-")) {
                    int result = first - second;
                    st.push(result);                    
                }
                else if(el.equals("*")) {
                    int result = first * second;
                    st.push(result);                    
                }
                else if(el.equals("/")) {
                    int result = first / second;
                    st.push(result);                    
                }
            }
        }
        
        return st.pop();
    }
}