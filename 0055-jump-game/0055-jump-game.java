class Solution {
    
    HashSet<Integer> set;
    public boolean canJump(int[] nums) {
        
        if(nums.length <= 1) return true;
        this.set = new HashSet<>();
        return dfs(nums, 0);
    }
    
    private boolean dfs(int[] nums, int idx) {
        
        //base
        if(idx >= nums.length-1) return true;
        if(set.contains(idx)) return false;
        //logic
        for(int i=1; i<=nums[idx]; i++) {
            int newIdx = idx+i;
            if(dfs(nums, newIdx))
                return true;
        }
        set.add(idx);
        return false;
    }
}