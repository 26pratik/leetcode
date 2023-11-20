class Solution {
    
    public int change(int amount, int[] coins) {
        
        // return helper(coins, amount, 0);
        int m = coins.length;
        int n = amount;
        // int[][] dp = new int[m+1][n+1];
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        
        for(int i=1; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(j >= coins[i-1])
                    dp[j] = dp[j] + dp[j - coins[i-1]];
            }
        }
        
        return dp[n];
        
    }
    
//     private int helper(int[] coins, int amount, int i) {
        
//         //base
//         if(amount == 0) return 1;
//         if(i >= coins.length || amount < 0) return 0;
        
//         //logic
//         int case0 = helper(coins, amount, i+1);
//         int case1 = helper(coins, amount-coins[i], i);
        
//         return case0 + case1;
//     }
}