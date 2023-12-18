class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int pivot, List<Integer> path) {
        
        //base
        result.add(new ArrayList<>(path));
        if(pivot == nums.length) return;

        for(int i=pivot; i<nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}