import java.math.*;
class Solution {
    public int strStr(String haystack, String needle) {
        
        int m = haystack.length(), n = needle.length();
        if(m < n) return -1;
        
        BigInteger hashHay = BigInteger.ZERO, hashNeedle = BigInteger.ZERO;
        BigInteger t = BigInteger.valueOf(26);        
        BigInteger posFac = t.pow(n-1);
        
        for(int i=0; i<n; i++) {
            char c = needle.charAt(i);
            hashNeedle = hashNeedle.multiply(t).add(BigInteger.valueOf(c - 'a' + 1));
        }
        
        for(int i=0; i<m; i++) {
            if(i>=n) {
                char out = haystack.charAt(i-n);
                hashHay = hashHay.subtract(t.pow(n-1).multiply(BigInteger.valueOf(out - 'a' + 1)));
            }
            
            char in = haystack.charAt(i);
            hashHay = hashHay.multiply(t).add(BigInteger.valueOf(in - 'a' + 1));
            
            if(hashHay.equals(hashNeedle))
                return i-n+1;
        }
        
        return -1;
    }
}