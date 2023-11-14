class Solution {
    public int missingElement(int[] nums, int k) {
        
        int low = 0, high = nums.length-1;
        
        while(low < high) {
            int mid = high - (high-low)/2;
            
            if(nums[mid] - nums[0] - mid < k)
                low = mid;
            else
                high = mid - 1;
        }
        
        return nums[0]+k+low;
    }
}