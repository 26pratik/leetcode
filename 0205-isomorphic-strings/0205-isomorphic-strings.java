// Solution using 1 HashMap
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        
        Map<Character, Character> sMap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if(sMap.containsKey(sChar)) {
                if(sMap.get(sChar) != tChar) return false;
            }
            else {
                if(sMap.containsValue(tChar)) return false;
                sMap.put(sChar, tChar);
            }
        }
        
        return true;
    }
}