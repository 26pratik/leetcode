class Solution {
    public int lengthOfLongestSubstring(String s) {
  
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        
        for(int right = 0; right<s.length(); right++) {
            
            char c = s.charAt(right);
            
            if(set.contains(c)) {               
                while(c != s.charAt(left)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            else {
                set.add(c);
                max = Math.max(max, right-left+1);
            }
        }
        
        return max;
    }
}