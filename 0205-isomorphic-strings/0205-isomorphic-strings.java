// Solution using 2 arrays
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        
        Map<Character, Character> sMap = new HashMap<>();
        Set<Character> tSet = new HashSet<>();
        char[] sArr = new char[224];
        char[] tArr = new char[224];
        
        for(int i=0; i<s.length(); i++) {
            
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if(sArr[sChar-' '] != 0) {
                if(sArr[sChar-' '] != tChar) return false;
            }
            else {
                if(tArr[tChar-' '] != 0) return false;
                tArr[tChar-' '] = tChar;
                sArr[sChar-' '] = tChar;
            }
        }
        
        return true;
    }
}