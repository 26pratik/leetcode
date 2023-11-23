class Solution {
    public void sortColors(int[] nums) {
        
        int low = 0, high = nums.length-1, mid = low;
        
        while(mid <= high) {
            
            if(nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
            else if(nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            }
            else {
                mid++;
            }
        }
    }
    
    private void swap(int[] nums, int mid, int index) {
        int temp = nums[mid];
        nums[mid] = nums[index];
        nums[index] = temp;
    }
}