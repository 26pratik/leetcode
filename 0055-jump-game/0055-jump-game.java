class Solution {
    
    int[] arr;
    public boolean canJump(int[] nums) {
        
        if(nums.length <= 1) return true;
        this.arr = new int[nums.length];  //0:unexplored, 1:explored and true, -1: explored nad false 
        return dfs(nums, 0);
    }
    
    private boolean dfs(int[] nums, int idx) {
        
        //base
        if(idx >= nums.length-1) return true;
        if(arr[idx] == 1) return true;
        if(arr[idx] == -1) return false;
        
        //logic
        for(int i=1; i<=nums[idx]; i++) {
            int newIdx = idx+i;
            if(arr[newIdx] == 0) {
                boolean temp = dfs(nums, newIdx);
                if(temp) {
                    arr[newIdx] = 1;
                    return true;
                }
                else {
                    arr[newIdx] = -1;
                }
            }
        }
        arr[idx] = -1;
        return false;
    }
}