class Solution {
    public int calculate(String s) {
        
        int result = 0;
        int currNum = 0;
        char lastSign = '+';
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }
            
            if((!Character.isDigit(c) && c != ' ') || (i == s.length()-1)) {
                if(lastSign == '+') {
                    st.push(currNum);
                }
                else if(lastSign == '-') {
                    st.push(-currNum);
                }
                else if(lastSign == '*') {
                    int n = st.pop();
                    st.push(currNum * n);
                }
                else if(lastSign == '/') {
                    int n = st.pop();
                    st.push(n / currNum);
                }
                
                currNum = 0;
                lastSign = c;
            }
        }
        
        
        
        while(!st.isEmpty()) {
            System.out.println(st.peek());
            result += st.pop();
        }
        
        return result;
    }
}