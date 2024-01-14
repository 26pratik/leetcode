class Solution {
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        
        for(int i=0; i<n; i++) {
            int diff = n-i;
            if(citations[i] >= diff)
                return diff;
        }
        
        return 0;
    }
}