class Solution {
    
    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {

        int costIndex = 0;
        int max = days[days.length-1];
        this.dp = new int[max + 1];

        for (int j = 1; j <= max; j++) {
            if (days[costIndex] > j) dp[j] = dp[j - 1];
            else {
                dp[j] = Math.min(dp[j - 1] + costs[0],
                        Math.min(dp[Math.max(0, j - 7)] + costs[1], dp[Math.max(0, j - 30)] + costs[2]));
                costIndex++;
            }
        }

        return dp[max];        
    }
}