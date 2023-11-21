class Solution {
    public int minCost(int[][] costs) {
        
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
        for(int i=1; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(j == 0)
                    dp[i][j] = Math.min(dp[i-1][1]+costs[i][j], dp[i-1][2]+costs[i][j]);
                if(j == 1)
                    dp[i][j] = Math.min(dp[i-1][0]+costs[i][j], dp[i-1][2]+costs[i][j]);
                if(j == 2) 
                    dp[i][j] = Math.min(dp[i-1][0]+costs[i][j], dp[i-1][1]+costs[i][j]);
            }
        }
        
        return Math.min(dp[m-1][0], Math.min(dp[m-1][1], dp[m-1][2]));
    }
}
// class Solution {
//     public int minCost(int[][] costs) {
        
//         int red = helper(costs, 0, 0, 0);
//         int blue = helper(costs, 1, 0, 0);
//         int green = helper(costs, 2, 0, 0);
        
//         return Math.min(red, Math.min(blue, green));
//     }
    
//     private int helper(int[][] costs, int color, int amount, int row) {
        
//         //base
//         if(row == costs.length)
//             return amount;
        
//         //logic
//         if(color == 0) {
//             return Math.min(helper(costs, 1, amount+costs[row][0], row+1),
//             helper(costs, 2, amount+costs[row][0], row+1));
//         }
        
//         if(color == 1) {
//             return Math.min(helper(costs, 0, amount+costs[row][1], row+1),
//             helper(costs, 2, amount+costs[row][1], row+1));
//         } 
        
//         if(color == 2) {
//             return Math.min(helper(costs, 1, amount+costs[row][2], row+1),
//             helper(costs, 0, amount+costs[row][2], row+1));
//         }
        
//         return amount;
//     }
// }