class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[][] dp = new int[n][n];
        
        for(int i=0; i<n; i++)
            dp[n-1][i] = matrix[n-1][i];
        
        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<n; j++) {
                if(j == 0)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                else if(j == n-1)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j-1]);
                else
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], Math.min(dp[i+1][j-1], dp[i+1][j+1]));
            }
        }

        int min = dp[0][0];
        for(int i=1; i<n; i++)
            min = Math.min(min, dp[0][i]);
        
        return min;
//         if(matrix.length == 1) return matrix[0][0];
        
//         int min = Integer.MAX_VALUE;
        
//         for(int i=0; i<matrix.length; i++) 
//             min = Math.min(min, helper(matrix, 0, i, 0));
            
//         return min;
    }
    
//     private int helper(int[][] matrix, int sum, int i, int row) {
        
//         //base
//         if(i < 0 || i == matrix.length) return Integer.MAX_VALUE;        
//         if(row == matrix.length) return sum;

//         //logic
//         if(i == 0) 
//             return Math.min(helper(matrix, sum+matrix[row][i], i, row+1), helper(matrix, sum+matrix[row][i+1], i+1, row+1));
//         else if(i == matrix.length-1) 
//             return Math.min(helper(matrix, sum+matrix[row][i], i, row+1), helper(matrix, sum+matrix[row][i-1], i-1, row+1));
//         else 
//             return Math.min(helper(matrix, sum+matrix[row][i], i, row+1), Math.min(helper(matrix, sum+matrix[row][i-1], i-1, row+1), 
//                                                                                    helper(matrix, sum+matrix[row][i+1], i+1, row+1)));            
       
//     }
}