//TC: O(k*l) -> O(L) where L is length of resultant string
//SC: O(L)
class Solution {
    
    int i=0;
    public String decodeString(String s) {
        
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
        
        while(i < s.length()) {
            char c = s.charAt(i);
            i++;
            if(Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }
            else if(c == '[') {
                String result = decodeString(s);
                for(int i=0; i<currNum; i++) {
                    currStr.append(result);
                }
                currNum = 0;
            }
            else if(c == ']') {
                return currStr.toString();
            }
            else {
                currStr.append(c);
            }
        }
            
        return currStr.toString();
    }
}