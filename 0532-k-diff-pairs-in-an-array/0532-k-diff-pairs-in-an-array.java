class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int low=0, high=1;
        int n = nums.length, count = 0;
        while(low < n && high < n) {
            if(low == high || nums[high]-nums[low] < k)
                high++;
            else if(nums[high]-nums[low] > k)
                low++;
            else {
                count++;
                low++;
                while(low < n && nums[low] == nums[low-1])
                    low++;
            }
        }
        
        return count;
    }
}