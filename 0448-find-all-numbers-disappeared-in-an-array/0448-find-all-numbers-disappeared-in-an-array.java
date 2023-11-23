class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            int x = Math.abs(nums[i]);
            if(nums[x-1] > 0)
                nums[x-1] *= -1;
        }
        
        for(int i=0; i<n; i++) {
            if(nums[i] > 0)
                result.add(i+1);
            else
                nums[i] *= -1;
        }
        
        return result; 
    }
}