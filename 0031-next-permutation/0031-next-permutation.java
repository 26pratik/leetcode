class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        if(n == 1) return;
        
        int i = n-2;
        
        while(i>=0 && nums[i] >= nums[i+1]) i--; //Find the breach
        
        if(i>=0) { //If breach is there, find the immediate bigger number and swap
            int j = n-1;
            while(nums[j] <= nums[i])  j--;           
            swap(nums, i, j);
        }
        
        reverse(nums, i+1, n-1); //reverse
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while(i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}