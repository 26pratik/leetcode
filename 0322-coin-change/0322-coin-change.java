class Solution {
    public int coinChange(int[] coins, int amount) {

            // return helper(coins, amount, 0, 0);
        int m = coins.length;
        int n = amount;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=1; i<=n;i++)
            dp[0][i] = amount+1;
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
            }
        }
        
        if(dp[m][n] == amount+1)
            return -1;
        
        return dp[m][n];
    }
    
//     private int helper(int[] coins, int amount, int index, int coinsUsed) {
        
//         // base
//         if(index == coins.length || amount < 0) return -1;        
//         if(amount == 0) return coinsUsed;
        
//         // logic        
//         int case0 = helper(coins, amount, index+1, coinsUsed);
//         int case1 = helper(coins, amount-coins[index], index, coinsUsed+1);
        
//         if(case0 == -1) return case1;
//         if(case1 == -1) return case0;
        
//         return Math.min(case0, case1);
//     }
}