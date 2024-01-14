//TC: O(n)
//SC: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int result = 0;
        int i=0;
        int min = 0, max = 0;
        while(i < n-1) {
            while(i < n-1 && prices[i] >= prices[i+1]) i++;
            min = prices[i];
            while(i<n-1 && prices[i] <= prices[i+1]) i++;
            max = prices[i];
            result += max - min;
        }
        
        return result;
    }
}