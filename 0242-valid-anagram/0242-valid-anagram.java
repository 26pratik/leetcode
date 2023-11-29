class Solution {
    public boolean isAnagram(String s, String t) {
        
        int[] si = new int[26];
        int[] ti = new int[26];
        
        for(char c: s.toCharArray()) 
            si[c-'a'] += 1;
        for(char c: t.toCharArray()) 
            ti[c-'a'] += 1;
        
        for(int i=0; i<26; i++) {
            if(si[i] != ti[i])
                return false;
        }
        
        return true;
    }
}