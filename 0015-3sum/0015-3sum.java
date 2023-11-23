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
        
        Set<Integer> set = new HashSet<>();
        
        for(int j=i+1; j<nums.length; j++) {
            int complement = -nums[i]-nums[j];
            if(set.contains(complement)) {
                result.add(Arrays.asList(nums[i], nums[j], complement));                
                while(j+1 < nums.length && nums[j] == nums[j+1])
                    j++;
            }
            set.add(nums[j]);
        }
    }
}