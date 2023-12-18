//TC: O (n * 2*n)
//SC: O()
class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        
        this.result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    //O(2^n )
    private void helper(int[] nums, int pivot, List<Integer> path) {
        
        //base
        //O(n)
        
        if(pivot == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        helper(nums, pivot+1, path);
        
        path.add(nums[pivot]);
        helper(nums, pivot+1, path);
        path.remove(path.size()-1);
    }
}