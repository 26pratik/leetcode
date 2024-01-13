class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int result = 0;       
        int l = 0; int lw = height[0];
        int r = n-1; int rw = height[n-1];
        while(l <= r) {
            if(lw < rw) {
                if(lw < height[l]) lw = height[l];
                else result += lw - height[l];
                l++;                
            }
            else {
                if(rw < height[r]) rw = height[r];
                else result += rw - height[r];
                r--;                
            }
        }       
        return result;
    }
}