class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        if(nums == null || n == 0) return 0;        
        if(n == 1) return nums[0];
        
        int prev = nums[0];
        int current = Math.max(nums[0], nums[1]);
        
        for(int i=2; i<n; i++) {
            int temp = current;
            current = Math.max(current, nums[i]+prev);
            prev = temp;
        }
        
        return current;
    }
}