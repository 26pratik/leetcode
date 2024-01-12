class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int maxId = 0;
        int max = height[0];
        int result = 0;
        for(int i=1; i<n; i++) 
            if(height[i] > max) {
                maxId = i;
                max = height[i];
            }
        
        int l = 0; int lw = 0;
        while(l < maxId) {
            if(lw > height[l]) result += lw - height[l];
            else lw = height[l];
            l++;
        }
        
        int r = n-1; int rw = 0;
        while(r > maxId) {
            if(rw > height[r]) result += rw - height[r];
            else rw = height[r];
            r--;
        }
        
        return result;
    }
}