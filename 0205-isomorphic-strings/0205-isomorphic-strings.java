// Solution using 1 HashMap, 1 HashSet
class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        
        Map<Character, Character> sMap = new HashMap<>();
        Set<Character> tSet = new HashSet<>();
        
        for(int i=0; i<s.length(); i++) {
            
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if(sMap.containsKey(sChar)) {
                if(sMap.get(sChar) != tChar) return false;
            }
            else {
                if(tSet.contains(tChar)) return false;
                tSet.add(tChar);
                sMap.put(sChar, tChar);
            }
        }
        
        return true;
    }
}