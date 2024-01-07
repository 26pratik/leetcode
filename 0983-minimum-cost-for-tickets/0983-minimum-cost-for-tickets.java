class Solution {
    
    int dp[];
    public int mincostTickets(int[] days, int[] costs) {

        int max = days[days.length-1];
        int dayIndex = 0;
        this.dp = new int[max + 1];
        
        for(int i=1; i<=max; i++) {
            if(days[dayIndex] > i) 
                dp[i] = dp[i-1];
            else {
                dp[i] = Math.min(dp[i-1] + costs[0], 
                                 Math.min(dp[Math.max(0, i-7)] + costs[1], 
                                                             dp[Math.max(0, i-30)] + costs[2]));
                dayIndex++;
            }
        }
        
        return dp[max];
    }
}