class Solution {
    public int rob(int[] nums) {
        
        // return helper(nums, 0, 0);
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        
        return dp[nums.length-1];
    }
    
//     private int helper(int[] nums, int index, int amount) {
        
//         //base
//         if(index >= nums.length) return amount;
        
//         //logic
//         int case0 = helper(nums, index+1, amount);
//         int case1 = helper(nums, index+2, amount+nums[index]);
        
//         return Math.max(case0, case1);
//     }
}