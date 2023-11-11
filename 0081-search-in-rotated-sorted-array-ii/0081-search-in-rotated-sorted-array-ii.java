class Solution {
    public boolean search(int[] nums, int target) {
        
        int low = 0, high = nums.length-1;
        
        while(low <= high) {
            
            int mid = low + (high-low)/2;
            
            if(nums[mid]  == target) 
                return true;
            
            if(nums[low] == nums[mid]) {
                low++;
                continue;
            }
            
            boolean pivotArr = false;
            if(nums[low] <= nums[mid])
                pivotArr = true;
            
            boolean targetArr = false;
            if(nums[low]  <= target)
                targetArr = true;
            
            if(pivotArr ^ targetArr)
                if(pivotArr)
                    low = mid + 1;
                else
                    high = mid - 1;
            else
                if(nums[mid] < target)
                    low = mid + 1;
                else
                    high = mid - 1;
        }
        
        return false;
    }
}