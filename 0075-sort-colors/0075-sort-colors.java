class Solution {
    public void sortColors(int[] nums) {
        
        int oneC=0, twoC=0, zeroC=0;
        
        for(int n: nums) {
            if(n == 0) zeroC++;
            else if(n == 1) oneC++;
            else twoC++;
        }
        
        for(int i=0; i<zeroC; i++) 
            nums[i] = 0;
        
        for(int i=zeroC; i<(zeroC+oneC); i++)
            nums[i] = 1;
        
        for(int i=(zeroC+oneC); i<nums.length; i++)
            nums[i] = 2;
    }
}