class Solution {
    
	private static final HashMap<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();
	
	static {
		OPERATIONS.put("+", (a,b) -> a+b);
		OPERATIONS.put("-", (a,b) -> a-b);
		OPERATIONS.put("*", (a,b) -> a*b);
		OPERATIONS.put("/", (a,b) -> a/b);
	}
    
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        
        for(String el: tokens) {
            if(!OPERATIONS.containsKey(el)) {
                st.push(Integer.parseInt(el));
            }
            else {
                int second = st.pop();
                int first = st.pop();
                BiFunction<Integer, Integer, Integer> operator = OPERATIONS.get(el);
                int value = operator.apply(first, second);
                st.push(value);
            }
        }
        
        return st.pop();
    }
}