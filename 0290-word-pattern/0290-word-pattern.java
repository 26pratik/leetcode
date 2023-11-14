class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        if(pattern == null || pattern.length() == 0 || s == null || s.length() == 0) return false;
        
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] sArr = s.split(" ");
        
        if(pattern.length() != sArr.length) return false;
        
        for(int i=0; i<pattern.length(); i++) {
            
            char c = pattern.charAt(i);
            String str = sArr[i];
            
            if(map.containsKey(c)) {
               if(!map.get(c).equals(str)) return false; 
            }
            else {
                if(set.contains(str)) return false;
                set.add(str);
                map.put(c, str);
            }
        }
        
        return true;
    }
}