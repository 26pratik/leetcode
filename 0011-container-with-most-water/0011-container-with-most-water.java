class Solution {
    public int maxArea(int[] height) {
        
        int low = 0, high = height.length-1;
        int max = Integer.MIN_VALUE;
        
        while(low < high) {
            int area = 0;
            if(height[low] < height[high]) {   
                area =  (high-low) * height[low];
                low++;
            }
            else {
                area =  (high-low) * height[high];
                high--;
            }
            max = Math.max(max, area);
        }
        
        return max;
    }
}