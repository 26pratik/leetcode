class Solution {
    
    HashMap<Integer, Boolean> map;
    public boolean canJump(int[] nums) {
        
        if(nums.length <= 1) return true;
        this.map = new HashMap<>();
        return dfs(nums, 0);
    }
    
    private boolean dfs(int[] nums, int idx) {
        
        //base
        if(idx >= nums.length-1) return true;
        if(map.containsKey(idx)) return map.get(idx);
        //logic
        for(int i=1; i<=nums[idx]; i++) {
            int newIdx = idx+i;
            if(dfs(nums, newIdx)) {
                map.put(newIdx, true);
                return true;
            }
                
        }
        map.put(idx, false);
        return false;
    }
}