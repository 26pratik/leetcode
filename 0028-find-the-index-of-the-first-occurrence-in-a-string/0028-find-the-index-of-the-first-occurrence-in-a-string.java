class Solution {
    public int strStr(String haystack, String needle) {
        
        int m = haystack.length(), n = needle.length();
        if(m < n) return -1;
        
        int i=0, j=0;
        
        while(i <= m-n) {
            int k = i;
            
            while(haystack.charAt(k) == needle.charAt(j)) {
                k++;
                j++;
                if(j == n) return i;
            }
            i++;
            j=0;
        }
        
        return -1;
    }
}