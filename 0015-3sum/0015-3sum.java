class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
                twoSum(nums, i, result);
            }
        }
        return result;
    }
    
    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        
        int low = i+1, high = nums.length-1;
        
        while(low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            
            if(sum == 0) {
                result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                low++;
                high--;
                while(low < high && nums[low] == nums[low-1])
                    low++;
            }
            else if(sum < 0)
                low++;
            else
                high--;
        }
    }
}