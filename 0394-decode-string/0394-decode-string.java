class Solution {
    public String decodeString(String s) {
        
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }
            else if(c == '[') {
                strSt.push(currStr);
                numSt.push(currNum);
                currNum = 0;
                currStr = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder temp = new StringBuilder();
                int num = numSt.pop();
                for(int j=0; j<num; j++) {
                    temp.append(currStr);
                }
                
                currStr = strSt.pop();
                currStr.append(temp);
            }
            else {
                currStr.append(c);
            }
        }
            
            return currStr.toString();
    }
}