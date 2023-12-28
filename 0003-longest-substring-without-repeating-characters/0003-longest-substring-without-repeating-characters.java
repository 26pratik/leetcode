class Solution {
    public int lengthOfLongestSubstring(String s) {
  
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        
        for(int right = 0; right<s.length(); right++) {
            
            char c = s.charAt(right);
            if(map.containsKey(c) && left<=map.get(c)) {
                left = Math.max(left, map.get(c)+1);
                map.put(c, right);                
            }
            else {

                map.put(c, right);
                max = Math.max(max, right-left+1);
            }
        }
        
        return max;
    }
}