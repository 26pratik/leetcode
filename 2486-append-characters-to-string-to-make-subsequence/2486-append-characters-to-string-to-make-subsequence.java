class Solution {
    public int appendCharacters(String s, String t) {
        
        if(s.equals("")) return t.length();
        
        int p1 = 0, p2 = 0;
        
        while(p1 < s.length() && p2 < t.length()) {
            if(s.charAt(p1) == t.charAt(p2)) {    
                p2++;
            }
            p1++; 
        }
        return t.length()-p2;
    }
}