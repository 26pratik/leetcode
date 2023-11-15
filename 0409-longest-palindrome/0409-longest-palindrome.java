class Solution {
    public int longestPalindrome(String s) {
        
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        
        for(char c: s.toCharArray()) {
            if(!set.contains(c)) {
                set.add(c);
            }
            else {
                set.remove(c);
                count += 2;
            }
        }
        if(set.size() != 0)
            count += 1;
        
        return count;
    }
}