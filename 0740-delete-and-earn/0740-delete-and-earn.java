class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        
        for(int n: nums)
            max = Math.max(max, n);
        
        int[] dp = new int[max+1];
        
        for(int n: nums)
            dp[n] += n;
        
        for(int i=2; i<=max; i++)
            dp[i] = Math.max(dp[i-1], dp[i]+dp[i-2]);
        
        return dp[max];
        // return helper(dp, 0, 0);
    }
    
//     private int helper(int[] dp, int i, int points) {
        
//         //base
//         if(i >= dp.length) return points;
//         //logic
//         int case0 = helper(dp, i+1, points);
//         int case1 = helper(dp, i+2, points+dp[i]);
        
//         return Math.max(case0, case1);
//     }
}