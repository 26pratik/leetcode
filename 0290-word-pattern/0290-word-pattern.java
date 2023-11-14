// 1 array, 1 HashSet
class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        if(pattern == null || pattern.length() == 0 || s == null || s.length() == 0) return false;

        Set<String> set = new HashSet<>();
        String[] sArr = s.split(" ");
        String[] sMap = new String[26];
        
        if(pattern.length() != sArr.length) return false;
        
        for(int i=0; i<pattern.length(); i++) {
            
            char c = pattern.charAt(i);
            String str = sArr[i];
            
            if(sMap[c-'a'] != null) {
               if(!sMap[c-'a'].equals(str)) return false; 
            }
            else {
                if(set.contains(str)) return false;
                set.add(str);
                sMap[c-'a'] = str;
            }
        }
        
        return true;
    }
}