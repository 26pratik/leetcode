class Solution {
    public int arrayPairSum(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        
        for(int i=0; i<n; i=i+2) {
            if(i == n-1) 
                result += nums[i];
            else 
                result += Math.min(nums[i], nums[i+1]);
        }
        
        return result;
    }
}