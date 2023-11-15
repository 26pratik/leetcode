class Solution {
    public int longestPalindrome(String s) {
        
        // HashMap<Character> set = new HashMap<>();
        boolean[] set = new boolean[60];
        int count = 0;
        
        for(char c: s.toCharArray()) {
            if(!set[c-'A']) {
                set[c-'A'] = true;
            }
            else {
                set[c-'A'] = false;
                count += 2;
            }
        }
        
        for(int i=0; i<set.length; i++) {
            if(set[i]) {
                count++;
                break;
            }
        }
        
        return count;
    }
}