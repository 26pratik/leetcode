class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] result = new int[n];
        int hottest = 0;
        for(int i=n-1; i>=0; i--) {
            if(temperatures[i] >= hottest) {
                hottest = temperatures[i];
                continue;
            }
            
            int days = 1;
            while(temperatures[i+days] <= temperatures[i])
                days += result[i+days];
            result[i] = days;
        }

        return result;
    }
}