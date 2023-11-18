class Solution {
    public int rob(int[] nums) {
        
        // return helper(nums, 0, 0);
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        // int[] dp = new int[nums.length];
        
        int prev = nums[0];
        int current = Math.max(nums[0], nums[1]);
        
        for(int i=2; i<nums.length; i++) {
            int temp = current;
            current = Math.max(current, prev+nums[i]);
            prev = temp;
        }
        
        return current;
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